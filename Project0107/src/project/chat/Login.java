package project.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//�α��� ȭ���� �����Ѵ�
public class Login extends JPanel{
	//�Է�â ������ ������ �г�
	JPanel p_txt;
	JTextArea id,pw;
	//�α��� �� �ʿ��� ���̵�� �н����� �Է�â ����
	JTextField t_id, t_pw;
	//��ư ������ ������ �г�
	JPanel p_bt;
	//�Է� Ȯ�� ��ư �� ȸ������ ��ư ����
	JButton bt_accept, bt_regist;
	//-----------------------------------------------------------------
	Regist regist; //���� ȭ�� Ŭ����
	ChatMain chatMain; //���� ȭ�� Ŭ����
	LoginSuccess loginSuccess; //�α��� ���� �� 
	
	public Login() {
		p_txt=new JPanel();
		id=new JTextArea("   ID",1,3);
		pw=new JTextArea("   PW",1,4);
		t_id=new JTextField(15);
		t_pw=new JTextField(15);
		
		p_bt=new JPanel();
		bt_accept=new JButton("Ȯ��");
		bt_regist=new JButton("����");
		
		//p_txt �κ� ������
		id.setEditable(false); //���� �Ұ���
		
		p_txt.setPreferredSize(new Dimension(250, 400));
		p_txt.setBackground(Color.WHITE);
		p_txt.add(id);
		p_txt.add(t_id);
		p_txt.add(pw);
		p_txt.add(t_pw);
		
		//p_bt �κ� ������
		pw.setEditable(false); //���� �Ұ���
		
		p_bt.add(bt_accept);
		p_bt.add(bt_regist);
		
		//��ư�� �̺�Ʈ ����
		
		bt_accept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String content_id=t_id.getText();
				String content_pw=t_pw.getText();
				String sqlID="select * from users where id='"+content_id+"'";
				PreparedStatement pstmt=null;
				ResultSet rs=null;
								
				//t_id�� t_pw�� �ؽ�Ʈ�� �Է����� �ʾ��� ���
				if(content_id.length()==0) {
					JOptionPane.showMessageDialog(p_txt, "���̵� �Է����ּ���");
					return;
				}
				if(content_pw.length()==0) {
					JOptionPane.showMessageDialog(p_txt, "��й�ȣ�� �Է����ּ���");
					return;
				}
				
				//���̵�� �н����尡 �����ͺ��̽��� �������� �ʴ� ���� �Է����� ���
				String sql="select * from users where id='"+content_id+"', password='"+content_pw+"'";
								
				try {
					chatMain=new ChatMain();
					pstmt=chatMain.con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					if(rs.next()==false) {
						JOptionPane.showMessageDialog(p_txt, "��ϵ��� ���� ���̵� ��й�ȣ�Դϴ�");
						return;
					}else {
						loginSuccess=new LoginSuccess();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		bt_regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regist=new Regist(); //ȸ�� ���� Ŭ���� ȣ��
			}
		});
		
		//�гο� ����
		add(p_txt);
		add(p_bt, BorderLayout.SOUTH);
		
		//ȭ�� ������
		setBackground(Color.YELLOW);
		setVisible(true);
	}
}
