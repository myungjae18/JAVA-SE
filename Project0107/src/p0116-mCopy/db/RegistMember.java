package p0116-mCopy.db;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class RegistMember extends JPanel{
	JPanel p_south, p_west, p_center;
	JButton bt_check,bt_regist;
	JPanel p_input;//입력 컴포넌트 올곳..
	
	//라벨들
	JLabel la_id, la_password1, la_password2, la_name, la_birth;
	JTextField t_id, t_password1, t_password2, t_name, t_birth;
	JPanel p_id;
	MemberManager memberManager;
	boolean idChecked=false; // id 체크여부
	public RegistMember(MemberManager memberManager) {
		this.memberManager=memberManager;
		//현재 클래스와 p_center를 BorderLayout 으로
		this.setLayout(new BorderLayout());
		p_south = new JPanel();
		p_west = new JPanel();
		p_center = new JPanel();
		bt_check = new JButton("아이디 중복확인");
		bt_regist = new JButton("회원가입");
		p_input  = new JPanel();
		la_id = new JLabel("ID");
		la_password1 = new JLabel("비밀번호 입력");
		la_password2 = new JLabel("비밀번호 확인");
		la_name = new JLabel("이름");
		la_birth = new JLabel("생년월일");
		t_id = new JTextField();
		t_password1 = new JTextField();
		t_password2 = new JTextField();
		t_name = new JTextField();
		t_birth = new JTextField();
		p_id = new JPanel();
		
		//서쪽처리
		p_west.setBackground(Color.white);
		p_west.setPreferredSize(new Dimension(150,400));
		//p_west.setLayout(new GridLayout(5,1));
		//라벨들 크기 설정
		Dimension d2 = new Dimension(120,25);
		la_id.setPreferredSize(d2);
		la_password1.setPreferredSize(d2);
		la_password2.setPreferredSize(d2);
		la_name.setPreferredSize(d2);
		la_birth.setPreferredSize(d2);
		
		//라벨들 부착
		p_west.add(la_id);
		p_west.add(la_password1);
		p_west.add(la_password2);
		p_west.add(la_name);
		p_west.add(la_birth);
		
		//센터패널에 서쪽패널 부착!!
		p_center.setLayout(new BorderLayout());
		p_center.add(p_west,BorderLayout.WEST);
		p_center.add(p_input);
		//입력컴포넌트의 크기설정
		Dimension d = new Dimension(350, 25);
		t_id.setPreferredSize(d);
		t_password1.setPreferredSize(d);
		t_password2.setPreferredSize(d);
		t_name.setPreferredSize(d);
		t_birth.setPreferredSize(d);
		//센터에 입력 컴포넌트들 부착
		p_input.add(t_id);
		p_input.add(bt_check);
		p_input.add(t_password1);
		p_input.add(t_password2);
		p_input.add(t_name);
		p_input.add(t_birth);
		//남쪽에 버튼 부착 및, 패널 부착
		p_south.add(bt_regist);
		this.add(p_center);
		this.add(p_south,BorderLayout.SOUTH);
		
		setPreferredSize(new Dimension(800, 360));
		setBackground(Color.YELLOW);
		
		//버튼과 리스너 연결
		bt_regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regist();
			}
		});
		bt_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkId();
			}
		});
		Document doc=t_id.getDocument();
		doc.addDocumentListener(new DocumentListener() {
			public void removeUpdate(DocumentEvent e) {

				idChecked=false;
			}
			public void insertUpdate(DocumentEvent e) {

				idChecked=false;
			}
			public void changedUpdate(DocumentEvent e) {
				System.out.println("changedUpdate");
			}
		});
	}
	//회원 1명 입력
	public void regist() {
		//중복확인을 하지 않으면 아래의 절차는 불가능!!
		if(idChecked==false) {
			JOptionPane.showMessageDialog(memberManager, "아이디 중복여부를 체크하세요");
			return;
		}
		String id = t_id.getText();
		String password = t_password1.getText();
		String name = t_name.getText();
		String birth = t_birth.getText();
		//유효성 체크
		
		if(id.length()==0) {
			JOptionPane.showMessageDialog(memberManager, "아이디를 넣으세요");
			t_id.requestFocus(); //커서 올리기
			return;
		}
		if(password.length()==0) {
			JOptionPane.showMessageDialog(memberManager, "비밀번호를 넣으세요");
			t_password1.requestFocus(); //커서 올리기
			return;
		}
		if(name.length()==0) {
			JOptionPane.showMessageDialog(memberManager, "이름을 넣으세요");
			t_name.requestFocus(); //커서 올리기
			return;
		}
		if(birth.length()==0) {
			JOptionPane.showMessageDialog(memberManager, "생년월일을 넣으세요");
			t_birth.requestFocus(); //커서 올리기
			return;
		}
		
		String sql="insert into member3(member3_id,id,password,name,birth)";
		sql+=" values(seq_member3.nextval,'"+id+"','"+password+"','"+name+"','"+birth+"')";
		//System.out.println(sql);
		PreparedStatement pstmt=null;
		try {
			pstmt=memberManager.con.prepareStatement(sql);
			int result=pstmt.executeUpdate(); //DML
			if(result==0) {
				JOptionPane.showMessageDialog(memberManager, "가입실패");
			}else {
				JOptionPane.showMessageDialog(memberManager, "가입성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void checkId() {
		String id=t_id.getText();
		String sql="select * from member3 where id='"+id+"'";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=memberManager.con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {//true라면 회원가입 불가
				JOptionPane.showMessageDialog(memberManager, "이미 사용중인 아이디 입니다");
			}else {
				idChecked=true;
				JOptionPane.showMessageDialog(memberManager, "사용 가능한 아이디 입니다");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs != 
					null) {
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
	}
}


