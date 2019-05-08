package com.javaclient.product;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.javaclient.main.ClientMain;

public class ProductMain extends JPanel{
	ClientMain clientMain;
	String path="C:/Users/myung/java_developer/data/";
	
	JPanel container; //상품이 붙게 될 패널
	JPanel p_south; //각종 버튼들이 위치할 남쪽 패널
	JButton bt_cart;
	
	//장바구니 역할을 할 리스트 선언
	List cartList=new ArrayList(); //제너릭은 리스트 사용 직전 형고정이 필요할 때 사용
	
	public ProductMain(ClientMain clientMain) {
		this.clientMain=clientMain;
		
		container=new JPanel();
		p_south=new JPanel();
		bt_cart=new JButton("장바구니");
				
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(1300, 800));
		
		p_south.add(bt_cart);
		p_south.setBackground(Color.YELLOW);
		add(container);
		add(p_south, BorderLayout.SOUTH);
		
		bt_cart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(clientMain, "선택한 상품을 장바구니에 담으시겠습니까?");
				if(result==JOptionPane.OK_OPTION) {
					goCart(5);
				}				
			}
		});
		
		selectAll();
	}
	
	//데이터베이스에 존재하는 상품만큼 Product 객체 생성
	public void selectAll() {
		Connection con=clientMain.getCon();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from product order by product_id asc";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				String fileName=path+rs.getString("img");
				int product_id=rs.getInt("product_id");
				String name=rs.getString("product_name");
				String price=rs.getString("price");
				
				Product product=new Product(this, fileName, product_id, name, price);
				container.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	//장바구니 패널을 화면에 보여주는 메서드
	public void goCart(int member_id) {
		//장바구니에 입력
		Connection con=clientMain.getCon();
		PreparedStatement pstmt=null;
		
		StringBuffer sb=new StringBuffer();
		
		sb.append("insert into cart(cart_id, member_id, product_id, ea)");
		sb.append(" values(seq_cart.nextval, ?, ?, ?)");
		
		for (int i = 0; i < cartList.size(); i++) {
			int product_id=(Integer)cartList.get(i);
			try {
				pstmt=con.prepareStatement(sb.toString());
				pstmt.setInt(1, member_id); //member_id
				pstmt.setInt(2, product_id); //product_id
				pstmt.setInt(3, 1); //_id
				int result=pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(pstmt!=null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
				
		clientMain.showPage(1); //입력 후
	}
}
