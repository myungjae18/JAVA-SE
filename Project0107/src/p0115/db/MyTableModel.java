/*JTable은 디자인과 데이터를 분리시킨 MVC를 따르는 대표적인 컴포넌트이다
MVC ( Model View Controller ) : 로직,데이터와 디자인은 분리시키라는 개발방법론(패턴)
	- Model : 데이터, 로직
	- View : 디자인
	- Controller : 디자인과 데이터를 연결시키는 중간자
*/

package p0115.db;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel{
	//보여질 데이터
	String[][] data= {
			{"복숭아", "한국", "2000"},
			{"멜론", "필리핀", "5000"},
			{"포도", "프랑스", "12000"}
	};
	
	//보여질 column
	String[] columnName= {"과일명", "원산지", "가격"};
		
	public int getColumnCount() {
		//System.out.println("층수는"+columnName.length);
		return columnName.length;
	}

	public int getRowCount() {
		//System.out.println("호수는"+data.length);
		return data.length;
	}

	public Object getValueAt(int row, int col) {
		//System.out.println("getValueAt("+row+","+col+")");
		return data[row][col];
	}
}
