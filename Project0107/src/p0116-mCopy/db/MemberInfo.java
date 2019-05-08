package p0116.db;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class MemberInfo extends JPanel{
	JPanel p_south;
	JButton bt_del, bt_excel;
	JTable table;
	JScrollPane scroll;
	AbstractTableModel model;
	String[][] data;
	String[] columnTitle;
	MemberManager memberManager;
	String member3_id;
	public MemberInfo(MemberManager memberManager) {
		this.memberManager=memberManager;
		p_south = new JPanel();
		bt_del = new JButton("회원삭제");
		bt_excel = new JButton("엑셀로 저장");
		table = new JTable();
		scroll = new JScrollPane(table);
		this.setLayout(new BorderLayout());
		add(scroll);
		p_south.add(bt_del);
		p_south.add(bt_excel);
		add(p_south, BorderLayout.SOUTH);
		
		getList();
		
		//테이블 마우스 이벤트 연결
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				int col =table.getSelectedColumn();
				//System.out.println(row+","+col);
				member3_id=(String) table.getValueAt(row, 0); //프라이머리키
				//System.out.println("pk"+table.getValueAt(row, 0));
			}
		});
		bt_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(memberManager, "삭제하시겠습니까?");
				if(result==JOptionPane.OK_OPTION) {
					delete();
				}
					
				
			}
		});
		setPreferredSize(new Dimension(800, 320));
		setBackground(Color.RED);
		setVisible(false);
	}
	/*회원정보 가져오기*/
	public void getList() {
		String sql="select * from member3";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=memberManager.con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=pstmt.executeQuery();
			ResultSetMetaData meta= rs.getMetaData();
			int columnCount=meta.getColumnCount();
			System.out.println("컬럼수는 "+columnCount);
			
			//컬럼정보 구성하기
			columnTitle = new String[columnCount];
			for(int i =0;i<columnCount;i++) {
				columnTitle[i]=meta.getColumnName(i+1);
			}
			//2차원 배열에 rs의 내용을 옮겨담자
			rs.last();
			int total=rs.getRow(); //현재 row의 위치 반환
			data=new String[total][columnCount];
			
			rs.beforeFirst();
			
			rs.next();
			//왜 1부터 시작하는가? rs컬럼은 1부터 시작한다!!
			for(int a=0;a<total;a++) {
				for(int i=1;i<=columnCount;i++) {
					data[a][i-1]=rs.getString(i);
				}
				rs.next();
			}
			
			showTable();
			
			System.out.println(meta.getColumnName(1));
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
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void delete() {
		String sql="delete from member3 where member3_id="+member3_id;
		System.out.println(sql);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=memberManager.con.prepareStatement(sql);
			int result=pstmt.executeUpdate();
			if(result !=0) {
				JOptionPane.showMessageDialog(memberManager, "삭제성공");
				//table.setUpdateSelectionOnSort(true);
				getList();
				table.updateUI();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//jtable에 반영하기
	public void showTable() {
		table.setModel(model = new AbstractTableModel() {
			public int getRowCount() {
				return data.length;
			}
			public int getColumnCount() {
				return columnTitle.length;
			}
			//컬럼 제목 넣기!!
			public String getColumnName(int column) {
				
				return columnTitle[column];
			}
			public boolean isCellEditable(int row, int col) {
				//System.out.println(row+","+col);
				boolean edit;
				if(col==0) {
					edit=false;
				}else {
					edit=true;
				}
				return edit;
			}
			public Object getValueAt(int row, int col) {
				return data[row][col];
			}
		});
	}
}
