package project.chat;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//ä�� �޽����� Ʋ�� �����Ѵ�
public class ChatMain extends JFrame{
	Login login; //���α׷��� �������� �� ó�� �ߴ� �α��� ȭ�� Ŭ����( ��� YELLOW )
	
	//���α׷��� ���� �� ����Ŭ �����ͺ��̽��� ��� ���ٵǾ� �Ѵ�
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="adams";
	String password="1234";
	
	Connection con;
	
	public ChatMain() {
		connect(); //���� �޼���
		login=new Login();
		
		//�α��� ȭ���� Ʋ�� ����
		add(login);
		
		//������ â ����		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				disconnect();
				System.exit(0);
			}
		});
		
		setSize(400,500);
		setVisible(true);
	}
	public void connect() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			con.setAutoCommit(true);
			if(con==null) {
				JOptionPane.showMessageDialog(this, "���� ����");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void disconnect() {
		if(con !=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new ChatMain();
	} 
}
