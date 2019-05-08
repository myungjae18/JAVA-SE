/*
 * JTable은 껍데기(View) 불과하기 때문에 데이터(model)을
 * 제공해주는 컨트롤러에 의존적이다.
 * */
package com.javashop.admin.product;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class ProductTableModel extends AbstractTableModel{
	String[] columnTitle= {"선택","고유코드","상품사진","상위분류","하위분류","상품명","가격"};
	Object[][] data;


	public int getRowCount() {
		return data.length;
	}
	public int getColumnCount() {		
		return columnTitle.length;
	}
	//컬럼제목 출력하기
	public String getColumnName(int col) {
		return columnTitle[col];
	}

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}
	
	
}
