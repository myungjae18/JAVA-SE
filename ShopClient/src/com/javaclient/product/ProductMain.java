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
	
	JPanel container; //��ǰ�� �ٰ� �� �г�
	JPanel p_south; //���� ��ư���� ��ġ�� ���� �г�
	JButton bt_cart;
	
	//��ٱ��� ������ �� ����Ʈ ����
	List cartList=new ArrayList(); //���ʸ��� ����Ʈ ��� ���� �������� �ʿ��� �� ���
	
	public ProductMain(ClientMain clientMain) {
		this.clientMain=clientMain;
		
		container=new JPanel();
		p_south=new JPanel();
		bt_cart=new JButton("��ٱ���");
				
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(1300, 800));
		
		p_south.add(bt_cart);
		p_south.setBackground(Color.YELLOW);
		add(container);
		add(p_south, BorderLayout.SOUTH);
		
		bt_cart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(clientMain, "������ ��ǰ�� ��ٱ��Ͽ� �����ðڽ��ϱ�?");
				if(result==JOptionPane.OK_OPTION) {
					goCart(5);
				}				
			}
		});
		
		selectAll();
	}
	
	//�����ͺ��̽��� �����ϴ� ��ǰ��ŭ Product ��ü ����
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
	//��ٱ��� �г��� ȭ�鿡 �����ִ� �޼���
	public void goCart(int member_id) {
		//��ٱ��Ͽ� �Է�
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
				
		clientMain.showPage(1); //�Է� ��
	}
}
