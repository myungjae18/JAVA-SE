//mysql�� �ڹ� ���� �����غ���
/*
����̹��� ���α׷��� �� �����ͺ��̽��� �ڵ鸵 �ϱ� ���� ����ü�̴�.
������ ���α׷� ������ ���α׷� �ڵ尡 �����ͺ��̽��� �������̾���.. 
�̴� db�� ��ü�� ��� ���α׷� �ڵ嵵 ���� ������ �Ǿ�� �ϴ� ����� �ҷ��Դ�..
�̸� �����ϱ� ���� ������ db ���߹��� ��� ���߻簡 ���ظ� �����ϰ�,
���� �� ���ؿ� �´� �����ͺ��̽� �ڵ鸵 �ڵ�� DB �����簡 �����ϴ� ������� �̷������..

JDBC(Java DataBase Connectivity)�� �ڹ� ���� �����ͺ��̽��� �����ϴ� ����� ����Ų��.
JDBC�� �̷�� �ִ� ��Ű���� ��ǥ���� �������̽�
	- Connection : ���� �� ���� ������ ���� ��ü, ���� �� ��ü�� null�� ��� ������ ������ ���̴�.
	- PreparedStatement : ������ ���� ��ü
	- ResultSet : ������ �� select���� ��� ���ڵ带 ��ȯ�ϹǷ� �ش� ���ڵ� ������ ��� �ִ� ��ü
*)JDBC�� �̷�� �ִ� ���� �������̽� ��ü���� ���� �����ڵ�� DB �����簡 �����ϰ� �ִ�.
	����) ���� �ڵ�� DB ������ ����������, JDBC API ������ sun�簡 �����Ѵ�
*/
package db;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

class DBHandler{
		//String url="jdbc:mariadb://localhost:3306/javaweb";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		//String user="root";
		String user="system";
		//String password="";
		String password="manager";
		Connection con; //������ ��, �� ������ ������ ��ü
		PreparedStatement pstmt; //������ ���� ��ü
	public DBHandler(){
		//����
		//�����ϱ� ���ؼ��� url, user, password�� �ʿ�
		try{
			try{
				//����̹� Ŭ���� �ε�, static ������ �ø�
				//Class.forName("org.mariadb.jdbc.Driver");
				Class.forName("oracle.jdbc.driver.OracleDriver");
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			//����̹� �ε�
			con=DriverManager.getConnection(url, user, password);
			if(con==null){
				System.out.println("���� ����");
			}else{
				System.out.println("���� ����");
				//���� ������ member ���̺� �ֱ�
				/*pstmt�� �������̽��� ������ �޸𸮿� new�� �ø� �� ����
				->�ø��� ��� : ������ �����Ǿ�� �������� ������ �� �����Ƿ�,
									Connection ��ü�κ��� ���������� �ν��Ͻ��� ���� �� �ִ�
				*/
				//String sql="insert into member(name, phone, age)";
				String sql="insert into member2(member2_id, name, phone, age)";
				//sql=sql+" values('�Ÿ���', '010-0000-0000', 20)";
				sql=sql+" values(seq_member2.nextval, 'babo', '010-0100-0220', 30)";
				pstmt=con.prepareStatement(sql);
				//pstmt.executeUpdate(); //DML ����
				int result=pstmt.executeUpdate(); //DML ����
				if(result==1){
					System.out.println("�Է� ����");
				}else{
					System.out.println("�Է� ����");
				}
			}
		}catch(SQLException e){
			System.out.println("����̹� Ŭ�������� Ȯ�����ּ���");
		}finally{
			//�����ͺ��̽��� ���õ� ��ü�� ��� �ݴ´�
			if(pstmt!=null){
				try{
					pstmt.close();
				}catch(SQLException e){}
			}
			if(con!=null){
				try{
					con.close();
				}catch(SQLException e){}
			}
		}
	}
	public static void main(String[] args){
		new DBHandler();
	}
}
