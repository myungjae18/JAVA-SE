package p0114.db;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OracleInsert extends JFrame implements ActionListener{
	JPanel p_north, p_center, p_south;
	JTextField t_url, t_user, t_password, t_name, t_phone, t_age;
	JButton bt_connect, bt_insert;

	String driver="oracle.jdbc.driver.OracleDriver";
	String url;
	String user;
	String password;
	Connection con; //접속 정보 보유 객체
	PreparedStatement pstmt; //쿼리문 수행 인터페이스
	// 주의) MS 계열은 Connection이 접속 시도 객체이다
	public OracleInsert() {
		p_north=new JPanel();
		p_center=new JPanel();
		p_south=new JPanel();
		t_url=new JTextField(15);
		t_user=new JTextField(5);
		t_password=new JTextField(10);
		bt_connect=new JButton("접속");
		t_name=new JTextField();
		t_phone=new JTextField();
		t_age=new JTextField();
		bt_insert=new JButton("등록");
				
		Dimension d=new Dimension(480,25);
		t_name.setPreferredSize(d);
		t_phone.setPreferredSize(d);
		t_age.setPreferredSize(d);
		
		p_north.add(t_url);
		p_north.add(t_user);
		p_north.add(t_password);
		p_north.add(bt_connect);
		
		p_center.add(t_name);
		p_center.add(t_phone);
		p_center.add(t_age);
		
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		add(bt_insert, BorderLayout.SOUTH);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				close();
				System.exit(0);
			}
		});
		
		bt_connect.addActionListener(this);
		bt_insert.addActionListener(this);
				
		setSize(500,200);
		setVisible(true);
	}
	public void connect() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			url=t_url.getText();
			user=t_user.getText();
			password=t_password.getText();
			con=DriverManager.getConnection(url, user, password);
			if(con==null) {
				JOptionPane.showMessageDialog(this, "접속실패");
			}else {
				JOptionPane.showMessageDialog(this, "접속성공");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insert() {
		if(con==null) {
			JOptionPane.showMessageDialog(this, "접속을 먼저 하세요");
			return;
		}
		String name=t_name.getText();
		String phone=t_phone.getText();
		String age=t_age.getText();
		
		//강요되지 않은 예외? Runtime Exception
		try {
			int n=Integer.parseInt(age);
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(this, "디질래");
			return;
		}
		
		String sql="insert into member2(member2_id, name, phone, age)";
		sql+=" values(seq_member2.nextval, '"+name+"', '"+phone+"', '"+age+"')";
		System.out.println(sql);
		
		try {
			pstmt=con.prepareStatement(sql);
			int result=pstmt.executeUpdate();
			if(result==0) {
				JOptionPane.showMessageDialog(this, "등록 실패");
			}else {
				JOptionPane.showMessageDialog(this, "등록 성공");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close() {
		
	}
	public static void main(String[] args) {
		new OracleInsert();
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj==bt_connect) {
			connect();
		}
		if(obj==bt_insert) {
			insert();
		}
	}
}
