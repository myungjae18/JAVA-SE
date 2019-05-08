/*����ġ�� POI�� �̿��Ͽ� ������ �����غ���. 
 *�� ���������� ������ �������� �����ϰ� �� �ȿ� �����͸� ä���ֱ⸦ �Ѵ�*/
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
	
	HSSFWorkbook workbook; //����
	HSSFSheet sheet;
	public ExcelTest() {
		//����Ŭ ���̺� ��������
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
		
		//������ �����Ѵ�
		workbook=new HSSFWorkbook();
		sheet=workbook.createSheet("member3 table");
		
		//select�� ����
		String sql="select * from member3";
		try {
			pstmt=con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs=pstmt.executeQuery();
			//�÷��� ����
			ResultSetMetaData meta=rs.getMetaData();
			//row : �� ����
			int columnCount=meta.getColumnCount(); //�÷� ��
			
			HSSFRow row=sheet.createRow(0); //���� ����� row
			
			for (int i = 1; i < columnCount; i++) {
				HSSFCell cell=row.createCell(i-1);
				cell.setCellValue(meta.getColumnName(i));
			}
			//���ڵ� ä���
			rs.last();
			int total=rs.getRow();
			rs.beforeFirst(); //�ٽ� ����ġ
			for (int i = 1; i <= total; i++) {
				HSSFRow r=sheet.createRow(i);
				rs.next(); //Ŀ�� ������
				for (int j = 0; j < columnCount; j++) {
					HSSFCell cell=r.createCell(j);
					cell.setCellValue(rs.getString(j+1));
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//�� �ϼ��� �޸� ���� ������ ���� ���Ϸ� �����Ų��
		String path="E:/java_developer/javaSE/Project0107/res/fruits.xls";
		try {
			workbook.write(new File(path));
			System.out.println("����Ϸ�");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ExcelTest();
	}
}
