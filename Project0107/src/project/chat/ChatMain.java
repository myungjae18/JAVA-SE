package project.chat;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//채팅 메신져의 틀을 정의한다
public class ChatMain extends JFrame{
	Login login; //프로그램을 가동했을 때 처음 뜨는 로그인 화면 클래스( 배경 YELLOW )
	
	//프로그램을 켰을 때 오라클 데이터베이스에 즉시 접근되야 한다
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="adams";
	String password="1234";
	
	Connection con;
	
	public ChatMain() {
		connect(); //연결 메서드
		login=new Login();
		
		//로그인 화면을 틀에 부착
		add(login);
		
		//윈도우 창 종료		
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
				JOptionPane.showMessageDialog(this, "접속 실패");
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
