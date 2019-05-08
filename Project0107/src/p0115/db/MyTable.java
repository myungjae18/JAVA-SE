package p0115.db;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MyTable extends JFrame{
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="system";
	String password="manager";
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	JTable table;
	JScrollPane scroll;
	
	MyTableModel model;
		
	public MyTable() {
		connect();
		
		model=new MyTableModel();
		
		getData();
		
		table=new JTable(model);
		scroll=new JScrollPane(table);
		
		add(scroll);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				disconnect();
				System.exit(0);
			}
		});
		
		setSize(400,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void connect() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			if(con!=null) {
				this.setTitle(user+"로 접속중입니다");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void getData() {
		String sql="select * from fruit";
		String[][] fruits;
		
		try {
			pstmt=con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs=pstmt.executeQuery();
			
			//rs로부터 레코드의 개수가 몇개인지를 알아내기
			rs.last(); //제일 마지막 row로 보냄
			int row=rs.getRow();
			System.out.println("저"+row+"에 있어요");
			
			//row의 개수를 알아냈으니 이차원 배열을 만들 수 있다
			fruits=new String[row][3];
			//rs를 원상태로 돌려놓기
			rs.first();
			int row2=rs.getRow();
			System.out.println(row2);
			for (int i = 0; i < fruits.length; i++) {
				fruits[i][0]=rs.getString("name");
				fruits[i][1]=rs.getString("origin");
				fruits[i][2]=Integer.toString(rs.getInt("price"));
				System.out.println(fruits[i][0]);
				rs.next();
			}
			//TableModel이 보유한 데이터를 방금 만들어진 배열로 대체하자
			model.data=fruits;
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
	public static void main(String[] args) {
		new MyTable();
	}
}
