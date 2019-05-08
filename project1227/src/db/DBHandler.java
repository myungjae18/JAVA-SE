//mysql을 자바 언어로 제어해본다
/*
드라이버란 프로그래밍 언어가 데이터베이스를 핸들링 하기 위한 구현체이다.
고전적 프로그램 시절엔 프로그램 코드가 데이터베이스에 의존적이었다.. 
이는 db가 교체될 경우 프로그램 코드도 같이 변경이 되어야 하는 결과를 불러왔다..
이를 개선하기 위해 현재의 db 개발법은 언어 개발사가 기준만 제시하고,
실제 그 기준에 맞는 데이터베이스 핸들링 코드는 DB 벤더사가 구현하는 방식으로 이루어진다..

JDBC(Java DataBase Connectivity)란 자바 언어로 데이터베이스를 연동하는 기술을 가리킨다.
JDBC를 이루고 있는 패키지의 대표적인 인터페이스
	- Connection : 접속 후 접속 정보를 가진 객체, 따라서 이 객체가 null일 경우 접속이 실패한 것이다.
	- PreparedStatement : 쿼리문 수행 객체
	- ResultSet : 쿼리문 중 select문의 경우 레코드를 반환하므로 해당 레코드 집합을 담고 있는 객체
*)JDBC를 이루고 있는 많은 인터페이스 객체들의 실제 구현코드는 DB 벤더사가 보유하고 있다.
	주의) 구현 코드는 DB 벤더가 보유하지만, JDBC API 문서는 sun사가 보유한다
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
		Connection con; //접속한 후, 그 정보를 보유한 객체
		PreparedStatement pstmt; //쿼리문 수행 객체
	public DBHandler(){
		//접속
		//접속하기 위해서는 url, user, password가 필요
		try{
			try{
				//드라이버 클래스 로드, static 영역에 올림
				//Class.forName("org.mariadb.jdbc.Driver");
				Class.forName("oracle.jdbc.driver.OracleDriver");
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			//드라이버 로드
			con=DriverManager.getConnection(url, user, password);
			if(con==null){
				System.out.println("접속 실패");
			}else{
				System.out.println("접속 성공");
				//나의 정보를 member 테이블에 넣기
				/*pstmt는 인터페이스기 때문에 메모리에 new로 올릴 수 없다
				->올리는 방법 : 접속이 성공되어야 쿼리문을 수행할 수 있으므로,
									Connection 객체로부터 간접적으로 인스턴스를 얻어올 수 있다
				*/
				//String sql="insert into member(name, phone, age)";
				String sql="insert into member2(member2_id, name, phone, age)";
				//sql=sql+" values('신명재', '010-0000-0000', 20)";
				sql=sql+" values(seq_member2.nextval, 'babo', '010-0100-0220', 30)";
				pstmt=con.prepareStatement(sql);
				//pstmt.executeUpdate(); //DML 수행
				int result=pstmt.executeUpdate(); //DML 수행
				if(result==1){
					System.out.println("입력 성공");
				}else{
					System.out.println("입력 실패");
				}
			}
		}catch(SQLException e){
			System.out.println("드라이버 클래스명을 확인해주세요");
		}finally{
			//데이터베이스와 관련된 객체를 모두 닫는다
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
