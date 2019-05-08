/*
 * JTable�� ������(View) �Ұ��ϱ� ������ ������(model)��
 * �������ִ� ��Ʈ�ѷ��� �������̴�.
 * */
package com.javashop.admin.product;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class ProductTableModel extends AbstractTableModel{
	String[] columnTitle= {"����","�����ڵ�","��ǰ����","�����з�","�����з�","��ǰ��","����"};
	Object[][] data;


	public int getRowCount() {
		return data.length;
	}
	public int getColumnCount() {		
		return columnTitle.length;
	}
	//�÷����� ����ϱ�
	public String getColumnName(int col) {
		return columnTitle[col];
	}

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}
	
	
}
