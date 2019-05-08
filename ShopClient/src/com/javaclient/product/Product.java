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
   
   //�������� �����س��°� ����..Ŭ�������� ����� �� �����ϱ�
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
      //�̹��� ����...
      icon = new ImageIcon(path);
      img = icon.getImage();
      
      can = new Canvas() {
         public void paint(Graphics g) {
            g.drawImage(img, 0, 0, 146, 85,this); //null������ ������Ʈ�� �ȵ�
         }
      };
      
      // ĵ���� ������ ����
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
            System.out.println("���� ��ٱ����� ����"+productMain.cartList.size());
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