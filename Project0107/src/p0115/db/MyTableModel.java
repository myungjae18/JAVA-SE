/*JTable�� �����ΰ� �����͸� �и���Ų MVC�� ������ ��ǥ���� ������Ʈ�̴�
MVC ( Model View Controller ) : ����,�����Ϳ� �������� �и���Ű��� ���߹����(����)
	- Model : ������, ����
	- View : ������
	- Controller : �����ΰ� �����͸� �����Ű�� �߰���
*/

package p0115.db;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel{
	//������ ������
	String[][] data= {
			{"������", "�ѱ�", "2000"},
			{"���", "�ʸ���", "5000"},
			{"����", "������", "12000"}
	};
	
	//������ column
	String[] columnName= {"���ϸ�", "������", "����"};
		
	public int getColumnCount() {
		//System.out.println("������"+columnName.length);
		return columnName.length;
	}

	public int getRowCount() {
		//System.out.println("ȣ����"+data.length);
		return data.length;
	}

	public Object getValueAt(int row, int col) {
		//System.out.println("getValueAt("+row+","+col+")");
		return data[row][col];
	}
}
