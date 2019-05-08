package p0116.db;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class MemberList extends JPanel{
	JPanel p_south;
	JButton bt_del, bt_excel;
	JTable table;
	JScrollPane scroll;
	AbstractTableModel model;
	String[][] data=new String[1][5];
	MemberManager memberManager;
	String[]columnTitle;
	
	public MemberList(MemberManager memberManager) {
		this.memberManager=memberManager;
		p_south=new JPanel();
		bt_del=new JButton("회원 삭제");
		bt_excel=new JButton("엑셀로 저장");
		table=new JTable();
		scroll=new JScrollPane(table);
		
		setLayout(new BorderLayout());
		p_south.add(bt_del);
		p_south.add(bt_excel);
		add(scroll);
		add(p_south, BorderLayout.SOUTH);
		
		getList();
		
		setPreferredSize(new Dimension(800,360));
		setBackground(Color.RED);
		setVisible(false);
	}
	public void getList() {
		String sql="select * from member3";
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
			pstmt=memberManager.con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs=pstmt.executeQuery();
			ResultSetMetaData meta=rs.getMetaData();
			int columnCount=meta.getColumnCount();
			System.out.println(columnCount);
			columnTitle=new String[columnCount];
			for (int i = 0; i < columnCount; i++) {
				columnTitle[i]=meta.getColumnName(i+1);
			}
			//2차원 배열에 rs의 내용을 옮겨담자
			rs.last();
			int total=rs.getRow(); //현재 row의 위치 반환
			data=new String[total][columnCount];
			
			showTable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//jtable에 반영하기
	public void showTable() {
		table.setModel(model=new AbstractTableModel() {
			public int getRowCount() {
				// TODO Auto-generated method stub
				return data.length;
			}
			public int getColumnCount() {
				// TODO Auto-generated method stub
				return columnTitle.length;
			}
			//컬럼 제목 넣기
			public String getColumnName(int column) {
				return columnTitle[column];
			}
			/*public boolean isCellEditable(int row int col) {
				System.out.println(col,row);
				return true;
			}*/
			public Object getValueAt(int rowIndex, int columnIndex) {
				// TODO Auto-generated method stub
				return "딸기";
			}
			
		});
	}
}