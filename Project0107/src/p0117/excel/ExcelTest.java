/*아파치의 POI를 이용하여 엑셀을 제어해본다. 
 *이 예제에서는 엑셀을 동적으로 생성하고 그 안에 데이터를 채워넣기를 한다*/
package p0117.excel;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelTest {
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="adams";
	String password="1234";
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	HSSFWorkbook workbook; //엑셀
	HSSFSheet sheet;
	public ExcelTest() {
		//오라클 테이블 가져오기
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//엑셀을 생성한다
		workbook=new HSSFWorkbook();
		sheet=workbook.createSheet("member3 table");
		
		//select문 수행
		String sql="select * from member3";
		try {
			pstmt=con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs=pstmt.executeQuery();
			//컬럼명 조사
			ResultSetMetaData meta=rs.getMetaData();
			//row : 행 생성
			int columnCount=meta.getColumnCount(); //컬럼 수
			
			HSSFRow row=sheet.createRow(0); //제일 꼭대기 row
			
			for (int i = 1; i < columnCount; i++) {
				HSSFCell cell=row.createCell(i-1);
				cell.setCellValue(meta.getColumnName(i));
			}
			//레코드 채우기
			rs.last();
			int total=rs.getRow();
			rs.beforeFirst(); //다시 원위치
			for (int i = 1; i <= total; i++) {
				HSSFRow r=sheet.createRow(i);
				rs.next(); //커서 내리기
				for (int j = 0; j < columnCount; j++) {
					HSSFCell cell=r.createCell(j);
					cell.setCellValue(rs.getString(j+1));
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//다 완성된 메모리 상의 엑셀을 실제 파일로 존재시킨다
		String path="E:/java_developer/javaSE/Project0107/res/fruits.xls";
		try {
			workbook.write(new File(path));
			System.out.println("저장완료");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ExcelTest();
	}
}
