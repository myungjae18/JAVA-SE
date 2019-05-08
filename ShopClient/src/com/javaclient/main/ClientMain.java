package com.javaclient.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import com.javaclient.db.ConnectionManager;
import com.javaclient.payment.CartMain;
import com.javaclient.product.ProductMain;

public class ClientMain extends JFrame{
	JPanel container;//ȭ�鱳ü�� �����̳ʰ� �� �г�!!
	JMenuBar bar;
	String[] menuTitle= {"��ǰ���","��ٱ���","ȸ������","ä��"};
	JMenu[] menu = new JMenu[4];
	
	//������ ����
	JPanel[] pages=new JPanel[menuTitle.length];
	private Connection con;
	ConnectionManager connectionManager;
	
	
	public ClientMain() {
		container = new JPanel();
		bar = new JMenuBar();
		bar.setBackground(new Color(0,204,102));
		connectionManager = new ConnectionManager();
		//�����ϱ�
		con=connectionManager.getConnection();
		
		
		for(int i=0;i<menuTitle.length;i++) {
			menu[i]= new JMenu(menuTitle[i]);
			bar.add(menu[i]);
			menu[i].setFont(new Font("����",Font.BOLD,20));
			menu[i].setForeground(new Color(237,239,133));

		}
		setJMenuBar(bar);
		add(container);
		
		//create page
		pages[0]=new ProductMain(this);
		pages[1]=new CartMain(this);
		pages[2]=new MemberMain(this);
		pages[3]=new ChatMain(this);
		
		
		//add panel index 0 
		container.add(pages[0]);
		container.add(pages[1]);
		container.add(pages[2]);
		container.add(pages[3]);
		
		//�� �޴����� ������ �޼��� ȣ��
		menu[0].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showPage(0);
			}
		});
		menu[1].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showPage(1);
			}
		});
		menu[2].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showPage(2);
			}
		});
		menu[3].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showPage(3);
			}
		});
		//�����츮����
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				connectionManager.disconnect(con);
				System.exit(0);
			}
		});
		setSize(1300, 900);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void showPage(int page) {
		for(int i=0;i<pages.length;i++) {
			if(i==page) {
				pages[i].setVisible(true);
			}else {
				pages[i].setVisible(false);
			}
		}
	}
	public Connection getCon() {
		return con;
	}
	
	public static void main(String[] args) {
		new ClientMain();
	}
}
