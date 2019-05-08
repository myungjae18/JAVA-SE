package p0116.db;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class MemberInfo2 extends JPanel{
	JPanel p_south;
	JButton bt_del, bt_excel;
	JTable table;
	JScrollPane scroll;
	AbstractTableModel model;
	MemberManager memberManager;
	String[][] data;
	public MemberInfo2(MemberManager memberManager) {
		this.memberManager=memberManager;
		p_south = new JPanel();
		bt_del = new JButton("È¸¿ø»èÁ¦");
		bt_excel = new JButton("¿¢¼¿·Î ÀúÀå");
		table = new JTable(model=new AbstractTableModel() {
			
			public int getRowCount() {
				PreparedStatement pstmt=null;
				ResultSet rs = null;
				String sql="select * from member3";
				int cnt=0;
				try {
					pstmt=memberManager.con.prepareStatement(sql);
					rs=pstmt.executeQuery();
					while(rs.next()) {
						cnt++;
					}
					int result=rs.getRow();
					//System.out.println(result);
					data = new String[result][5];
					System.out.println(rs.getString(1));
					for(int i=0;i<result;i++) {
						data[i][0]=rs.getString(1);
						data[i][1]=rs.getString(2);
						data[i][2]=rs.getString(3);
						data[i][3]=rs.getString(4);
						data[i][4]=rs.getString(5);
					}
					
				} catch (SQLException e) {

					e.printStackTrace();
				}finally {
					if(rs!=null) {
						try {
							rs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(pstmt != null) {
						try {
							pstmt.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				return data.length;
			}
			public int getColumnCount() {
				
				return 5;
			}
			public Object getValueAt(int row, int col) {
				
				return data[row][col] ;
			}
		});
		scroll = new JScrollPane(table);
		this.setLayout(new BorderLayout());
		add(scroll);
		p_south.add(bt_del);
		p_south.add(bt_excel);
		add(p_south, BorderLayout.SOUTH);
		
		setPreferredSize(new Dimension(800, 320));
		setBackground(Color.RED);
		setVisible(false);
	}
}
