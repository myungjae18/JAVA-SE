package p0115.db;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SelectTable extends JFrame{
	JButton bt;
	JTextArea area;
	JScrollPane scroll;
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="system";
	String password="manager";
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public SelectTable() {
		bt=new JButton("Load");
		area=new JTextArea();
		scroll=new JScrollPane(area);
	
		add(bt, BorderLayout.NORTH);
		add(scroll);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				disconnect();
				System.exit(0);
			}
		});
		
		bt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				load();				
			}
		});
		
		setSize(600,400);
		setVisible(true);
		
		connect();
	}
	public void connect() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			if(con==null) {
				JOptionPane.showMessageDialog(this, "접속 실패");
			}else {
				this.setTitle(user+"접속 중");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void disconnect() {
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
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//select문을 전송해서 그 결과를 area에 출력한다
	public void load() {
		String sql="select * from member2 order by member2_id desc";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			//커서 한 칸 전진
			while(true) {
				boolean x=rs.next();
				if(x==true) {
					int member2_id=rs.getInt("member2_id");
					String name=rs.getString("name");
					String phone=rs.getString("phone");
					int age=rs.getInt("age");
					area.append(member2_id+"\t"+name+"\t"+phone+"\t"+age+"\n");
					area.append("-----------------------------------------------------\n");
				}else {
					break;
				}	
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new SelectTable();
	}
}
