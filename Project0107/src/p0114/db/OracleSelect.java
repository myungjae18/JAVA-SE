//DML이 아닌 select문을 연습해보자
package p0114.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleSelect {
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="system";
	String password="manager";
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public OracleSelect() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			
			if(con==null) {
				System.out.println("접속 실패");
			}else {
				System.out.println("접속 성공");
				String sql="select * from member2 order by member2_id asc";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				//커서를 지원하는 rs 객체를 이용하여 각 레코드에 접근해보자
				while(true) {
					boolean x=rs.next();
					if(x==true) {
						String name=rs.getString("name");
						String phone=rs.getString("phone");
						int age=rs.getInt("age");
						System.out.println(name+","+phone+","+age);
					}else {
						break;
					}	
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new OracleSelect();
	}
}
