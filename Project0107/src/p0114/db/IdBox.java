package p0114.db;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IdBox extends JFrame{
	JPanel tP, bP;
	JTextField urlBox, userBox, pwBox, nameBox, phoneBox, ageBox;
	JButton goBt, registBt;
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="";
	String user="";
	String password="";
	String name="";
	String phone="";
	String age="";
	Connection con;
	PreparedStatement pstmt;
	
	public IdBox() {
		tP=new JPanel();
		bP=new JPanel();
		urlBox=new JTextField(20);
		userBox=new JTextField(10);
		pwBox=new JTextField(15);
		goBt=new JButton("����");
		nameBox=new JTextField(50);
		phoneBox=new JTextField(50);
		ageBox=new JTextField(50);
		registBt=new JButton("���");
				
		tP.setPreferredSize(new Dimension(630, 50));
				
		add(tP, BorderLayout.NORTH);
		add(bP);
		
		tP.add(urlBox);
		tP.add(userBox);
		tP.add(pwBox);
		tP.add(goBt);
		
		bP.add(nameBox);
		bP.add(phoneBox);
		bP.add(ageBox);
		bP.add(registBt, BorderLayout.SOUTH);
		
		goBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				oracleGo();
			}
		});
		
		setSize(630,250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}
	public void oracleGo() {
		url=urlBox.getText();
		user=userBox.getText();
		password=pwBox.getText();
				
		try {
			Class.forName(driver);
			System.out.println("����̹� �ε� ����");
			try {
				//����
				con=DriverManager.getConnection(url, user, password);
				if(con==null) {
					System.out.println("���� ����");
				}else {
					System.out.println("���� ����");
					name=nameBox.getText();
					phone=phoneBox.getText();
					age=ageBox.getText();
					
					String sql="insert into member2(member2_id, name, phone, age)";
					String nameValue=name;
					String phoneValue=phone;
					String ageValue=age;
					sql+=" values(seq_member2.nextval, ""'+nameValue+'"", ""'+phoneValue+'"", ""+agevalue+"")";
					pstmt=con.prepareStatement(sql); //����
					//���� ����
					int result=pstmt.executeUpdate();
					if(result==0) {
						System.out.println("��� ����");
					}else {
						System.out.println("��� ����");
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
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
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	public static void main(String[] args) {
		new IdBox();
	}

}
