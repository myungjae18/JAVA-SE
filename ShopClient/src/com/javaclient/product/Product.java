/*
 *  
 */
package com.javaclient.product;

import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Product extends JPanel{
   ProductMain productMain;
   ImageIcon icon;
   Image img;
   JLabel la_name;
   JLabel la_price;
   Checkbox ch;
   Canvas can;
   
   //정보들은 보관해놓는게 좋아..클릭했을때 끄집어낼 수 있으니까
   String path;
   int product_id;
   String name;
   String price;
   
   
   public Product(ProductMain productMain,String path,int product_id,String name,String price) {
      this.productMain = productMain;
      this.path = path;
      this.product_id = product_id;
      this.name = name;   
      this.price =price;
      //이미지 생성...
      icon = new ImageIcon(path);
      img = icon.getImage();
      
      can = new Canvas() {
         public void paint(Graphics g) {
            g.drawImage(img, 0, 0, 146, 85,this); //null넣으면 업데이트가 안됨
         }
      };
      
      // 캔버스 사이즈 지정
      can.setPreferredSize(new Dimension(130,100));
      la_name = new JLabel(name);
      la_price = new JLabel(price);
      ch = new Checkbox();
      la_name.setPreferredSize(new Dimension(150, 15));
      la_price.setPreferredSize(new Dimension(95, 15));
      
      ch.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {
            System.out.println(ch.getState());
            if(ch.getState()) {
               productMain.cartList.add(product_id);
            }else {
               productMain.cartList.remove(product_id);
            }
            System.out.println("현재 장바구니의 수는"+productMain.cartList.size());
         }
      });
      add(can);
      add(la_name);
      add(la_price);
      add(ch);
      
      setBackground(Color.WHITE);
      this.setPreferredSize(new Dimension(150, 150));
   }
}