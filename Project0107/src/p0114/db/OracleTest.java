package p0114.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OracleTest {
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="system";
	String password="manager";
	Connection con; //접속 후 그 정보를 보유한 인터페이스
	PreparedStatement pstmt; //쿼리문 수행 인터페이스
	//->접속한 후에, Connection 객체로부터 생성된다
	
	public OracleTest() {
		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			try {
				//접속
				con=DriverManager.getConnection(url, user, password);
				if(con==null) {
					System.out.println("접속 실패");
				}else {
					System.out.println("접속 성공");
					String sql="insert into member2(member2_id, name, phone, age)";
					sql+=" values(seq_member2.nextval, '호랑이', '0000', 3)";
					pstmt=con.prepareStatement(sql); //생성
					//쿼리 수행
					int result=pstmt.executeUpdate();
					if(result==0) {
						System.out.println("등록 실패");
					}else {
						System.out.println("등록 성공");
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
		// TODO Auto-generated method stub
		new OracleTest();
	}
}
