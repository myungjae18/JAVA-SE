//DML�� �ƴ� select���� �����غ���
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
				System.out.println("���� ����");
			}else {
				System.out.println("���� ����");
				String sql="select * from member2 order by member2_id asc";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				//Ŀ���� �����ϴ� rs ��ü�� �̿��Ͽ� �� ���ڵ忡 �����غ���
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
