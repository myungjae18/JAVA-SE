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
	JPanel p_input;//�Է� ������Ʈ �ð�..
	
	//�󺧵�
	JLabel la_id, la_password1, la_password2, la_name, la_birth;
	JTextField t_id, t_password1, t_password2, t_name, t_birth;
	JPanel p_id;
	MemberManager memberManager;
	boolean idChecked=false; // id üũ����
	public RegistMember(MemberManager memberManager) {
		this.memberManager=memberManager;
		//���� Ŭ������ p_center�� BorderLayout ����
		this.setLayout(new BorderLayout());
		p_south = new JPanel();
		p_west = new JPanel();
		p_center = new JPanel();
		bt_check = new JButton("���̵� �ߺ�Ȯ��");
		bt_regist = new JButton("ȸ������");
		p_input  = new JPanel();
		la_id = new JLabel("ID");
		la_password1 = new JLabel("��й�ȣ �Է�");
		la_password2 = new JLabel("��й�ȣ Ȯ��");
		la_name = new JLabel("�̸�");
		la_birth = new JLabel("�������");
		t_id = new JTextField();
		t_password1 = new JTextField();
		t_password2 = new JTextField();
		t_name = new JTextField();
		t_birth = new JTextField();
		p_id = new JPanel();
		
		//����ó��
		p_west.setBackground(Color.white);
		p_west.setPreferredSize(new Dimension(150,400));
		//p_west.setLayout(new GridLayout(5,1));
		//�󺧵� ũ�� ����
		Dimension d2 = new Dimension(120,25);
		la_id.setPreferredSize(d2);
		la_password1.setPreferredSize(d2);
		la_password2.setPreferredSize(d2);
		la_name.setPreferredSize(d2);
		la_birth.setPreferredSize(d2);
		
		//�󺧵� ����
		p_west.add(la_id);
		p_west.add(la_password1);
		p_west.add(la_password2);
		p_west.add(la_name);
		p_west.add(la_birth);
		
		//�����гο� �����г� ����!!
		p_center.setLayout(new BorderLayout());
		p_center.add(p_west,BorderLayout.WEST);
		p_center.add(p_input);
		//�Է�������Ʈ�� ũ�⼳��
		Dimension d = new Dimension(350, 25);
		t_id.setPreferredSize(d);
		t_password1.setPreferredSize(d);
		t_password2.setPreferredSize(d);
		t_name.setPreferredSize(d);
		t_birth.setPreferredSize(d);
		//���Ϳ� �Է� ������Ʈ�� ����
		p_input.add(t_id);
		p_input.add(bt_check);
		p_input.add(t_password1);
		p_input.add(t_password2);
		p_input.add(t_name);
		p_input.add(t_birth);
		//���ʿ� ��ư ���� ��, �г� ����
		p_south.add(bt_regist);
		this.add(p_center);
		this.add(p_south,BorderLayout.SOUTH);
		
		setPreferredSize(new Dimension(800, 360));
		setBackground(Color.YELLOW);
		
		//��ư�� ������ ����
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
	//ȸ�� 1�� �Է�
	public void regist() {
		//�ߺ�Ȯ���� ���� ������ �Ʒ��� ������ �Ұ���!!
		if(idChecked==false) {
			JOptionPane.showMessageDialog(memberManager, "���̵� �ߺ����θ� üũ�ϼ���");
			return;
		}
		String id = t_id.getText();
		String password = t_password1.getText();
		String name = t_name.getText();
		String birth = t_birth.getText();
		//��ȿ�� üũ
		
		if(id.length()==0) {
			JOptionPane.showMessageDialog(memberManager, "���̵� ��������");
			t_id.requestFocus(); //Ŀ�� �ø���
			return;
		}
		if(password.length()==0) {
			JOptionPane.showMessageDialog(memberManager, "��й�ȣ�� ��������");
			t_password1.requestFocus(); //Ŀ�� �ø���
			return;
		}
		if(name.length()==0) {
			JOptionPane.showMessageDialog(memberManager, "�̸��� ��������");
			t_name.requestFocus(); //Ŀ�� �ø���
			return;
		}
		if(birth.length()==0) {
			JOptionPane.showMessageDialog(memberManager, "��������� ��������");
			t_birth.requestFocus(); //Ŀ�� �ø���
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
				JOptionPane.showMessageDialog(memberManager, "���Խ���");
			}else {
				JOptionPane.showMessageDialog(memberManager, "���Լ���");
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
			if(rs.next()) {//true��� ȸ������ �Ұ�
				JOptionPane.showMessageDialog(memberManager, "�̹� ������� ���̵� �Դϴ�");
			}else {
				idChecked=true;
				JOptionPane.showMessageDialog(memberManager, "��� ������ ���̵� �Դϴ�");
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


