package com.javaclient.payment;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

public class CartModel extends AbstractTableModel{
	String[] columnName= {"����","�̹���","�����ڵ�","��ǰ��","����"};
	Object[][] data;
	ImageIcon icon;
	Image img;
	String path="C:/Users/myung/java_developer/data/";
	
	public CartModel() {
		icon=new ImageIcon(path);
		img=icon.getImage();
		Image scaledImg=img.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
		ImageIcon thumb=new ImageIcon(scaledImg);
		
		
	}
	
	public int getRowCount() {
		return data.length;
	}
	
	public String getColumnName(int col) {
		return columnName[col];
	}
	
	public int getColumnCount() {
		return columnName.length;
	}
	
	public Class getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	}
	
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}
	
	public void setValueAt(Object obj, int row, int col) {
		if(col==0) { //checkbox�� ���� ������ �� �ֵ��� ������ �ο�
			data[row][col]=obj;
		}
	}
	
	public boolean isCellEditable(int row, int col) {
		return true;
	}
}
