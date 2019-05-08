package p0116.db;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import p0115.db.MemberManager;

public class MemberListTest extends JPanel{
	JPanel p_south;
	JButton bt_del, bt_excel;
	JTable table;
	JScrollPane scroll;
	AbstractTableModel model;
	RegistMember registMember;
	int count;
	String[][] tabledata;
				
	public MemberListTest() {
		System.out.println(count);
		registMember=new RegistMember(null, count);
		tabledata=new String[count][count+3];
		p_south=new JPanel();
		bt_del=new JButton("È¸¿ø »èÁ¦");
		bt_excel=new JButton("¿¢¼¿·Î ÀúÀå");
		table=new JTable(model=new AbstractTableModel() {
			String[] titleName= {
					"±â", "½Â", "Àü", "°á"
			};
			public int getRowCount() {
				return tabledata.length;
			}
			public int getColumnCount() {
				return titleName.length;
			}
			public Object getValueAt(int rowIndex, int columnIndex) {
				return tabledata[rowIndex][columnIndex];
			}
		});
		scroll=new JScrollPane(table);
		
		setLayout(new BorderLayout());
		p_south.add(bt_del);
		p_south.add(bt_excel);
		add(scroll);
		add(p_south, BorderLayout.SOUTH);
		
		setPreferredSize(new Dimension(780,360));
		setBackground(Color.RED);
		setVisible(false);
	}
}