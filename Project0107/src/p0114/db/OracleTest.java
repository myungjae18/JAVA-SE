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
	Connection con; //���� �� �� ������ ������ �������̽�
	PreparedStatement pstmt; //������ ���� �������̽�
	//->������ �Ŀ�, Connection ��ü�κ��� �����ȴ�
	
	public OracleTest() {
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
					String sql="insert into member2(member2_id, name, phone, age)";
					sql+=" values(seq_member2.nextval, 'ȣ����', '0000', 3)";
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
		// TODO Auto-generated method stub
		new OracleTest();
	}
}
