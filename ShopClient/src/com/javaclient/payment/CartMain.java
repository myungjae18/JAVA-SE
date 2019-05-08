package com.javaclient.payment;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.javaclient.main.ClientMain;

public class CartMain extends JPanel{
   ClientMain clientMain;
   JPanel p_south; //합계, 선택삭제, 결제 단추..
   JTable table;
   JScrollPane scroll;
   JButton bt_del,bt_pay;
   JLabel la_total; //총 구매금액.
   CartModel model;
   
   public CartMain(ClientMain clientMain) {
      this.clientMain=clientMain;
      
      p_south=new JPanel();
      table=new JTable();
      scroll=new JScrollPane(table);
      bt_del=new JButton("선택삭제");
      bt_pay=new JButton("결제");
      la_total=new JLabel("총 80,000원");
      
      p_south.add(bt_del);
      p_south.add(bt_pay);
      p_south.add(la_total);
      
      this.setLayout(new BorderLayout());
      add(scroll);
      add(p_south,BorderLayout.SOUTH);
      
      table.setRowHeight(50); //이미지 표시를 위한 테이블 높이 조절.
      table.setModel(model=new CartModel());
      
      //table과 마우스 리스너 연결.
      table.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent e) {
            int row=table.getSelectedRow();
            int col=0;
            System.out.println(table.getValueAt(row, col));
         }
      });
      this.setPreferredSize(new Dimension(1250,550));
      
      getCartList();
   }
   
   //장바구니와 관련된 테이블들을 join하여 래코드로 가져오기.
   public void getCartList() {
      Connection con=clientMain.getCon();
      PreparedStatement pstmt=null;
      ResultSet rs=null;
      
      StringBuffer sb=new StringBuffer();
      sb.append("select p.product_id as product_id,img,product_name,price");
      sb.append(" from cart c,member m,product p");
      sb.append(" where c.member_id=m.member_id");
      sb.append(" and c.product_id=p.product_id");
      sb.append(" and m.member_id=?");
      
      try {
         pstmt=con.prepareStatement(sb.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
         pstmt.setInt(1, 1/*member_id*/);//현재 로그인한 회원의 member_id로 치환.
         rs=pstmt.executeQuery();
         
         rs.last(); //커서를 끝까지 이동시킨 후...
         int total=rs.getRow(); //커서의 위치값을 구함으로써, 배열의 전체 행 값을 구한다.
         Object[][] data=new Object[total][model.columnName.length];
         rs.beforeFirst(); //용도를 다한 커서의 원상복귀.
         
         for(int k=0;k<total;k++) {
            rs.next();
            ImageIcon icon=new ImageIcon(model.path+rs.getString("img"));
            icon=new ImageIcon(icon.getImage().getScaledInstance(45,45,Image.SCALE_SMOOTH));
            data[k][0]=false;
            data[k][1]=icon;
            data[k][2]=rs.getInt("product_id");
            data[k][3]=rs.getString("product_name");
            data[k][4]=rs.getInt("price");
         }
         model.data=data; //data 대체.
         table.updateUI();
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         if(rs!=null) {
            try {
               rs.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
         if(pstmt!=null) {
            try {
               pstmt.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      }
   }
}