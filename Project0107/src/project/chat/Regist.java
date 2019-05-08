package project.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//회원 가입 화면을 정의한다
public class Regist extends JFrame{
	//정보가 들어갈 입력 창
	JTextArea title_id, title_pw, title_name, title_birth;
	JTextField t_id, t_pw, t_name, t_birth;
	
	JButton bt_check; //아이디 중복 확인 버튼
	JButton bt_regist; //회원 가입 버튼
	
	Dimension d_name;
	Dimension d_txt;
	//---------------------------------------------------------------------
	ChatMain chatMain;
	public Regist() {
		System.out.print("나 가동중");
		title_id=new JTextArea("id");
		title_pw=new JTextArea("pw");
		title_name=new JTextArea("name");
		title_birth=new JTextArea("birth");
		
		t_id=new JTextField();
		t_pw=new JTextField();
		t_name=new JTextField();
		t_birth=new JTextField();
		
		bt_check=new JButton("중복확인");
		bt_regist=new JButton("가입");
		
		d_name=new Dimension(30,20);
		d_txt=new Dimension(120,20);
		
		title_id.setEditable(false); //setEditable() : 텍스트의 내용을 수정 불가능하게 만드는 메서드
		title_pw.setEditable(false);
		title_name.setEditable(false);
		title_birth.setEditable(false);
		
		setLayout(new FlowLayout());
		
		title_id.setPreferredSize(d_name);
		title_pw.setPreferredSize(d_name);
		title_name.setPreferredSize(d_name);
		title_birth.setPreferredSize(d_name);
		
		t_id.setPreferredSize(new Dimension(80,20));
		t_pw.setPreferredSize(d_txt);
		t_name.setPreferredSize(d_txt);
		t_birth.setPreferredSize(d_txt);
		
		bt_check.setPreferredSize(new Dimension(58,20));
		
		add(title_id);
		add(t_id);
		add(bt_check);		
		add(title_pw);
		add(t_pw);
		add(title_name);
		add(t_name);
		add(title_birth);
		add(t_birth);
		
		add(bt_regist, BorderLayout.SOUTH);
		
		bt_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//IdCheck();
			}	
		});
		
		//가입 관련 메서드를 따로 빼는 방법을 생각해보자..		
		bt_regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=t_id.getText();
				String pw=t_pw.getText();
				String name=t_name.getText();
				String birth=t_birth.getText();
				
				if(id.length()==0) {
					JOptionPane.showMessageDialog(title_id, "사용할 아이디를 입력해주세요");
					return;
				}
				if(pw.length()==0) {
					JOptionPane.showMessageDialog(title_id, "사용할 비밀번호를 입력해주세요");
					return;
				}
				if(name.length()==0) {
					JOptionPane.showMessageDialog(title_id, "이름을 입력해주세요");
					return;
				}
				if(birth.length()==0) {
					JOptionPane.showMessageDialog(title_id, "생일을 입력해주세요");
					return;
				}
				
				//'현재 사용자'의 pc의 db에 접근
				String sql="insert into users(user_id, id, password, name, birth)";
				sql+=" values(seq_user.nextval,'"+id+"','"+pw+"','"+name+"','"+birth+"')";
				PreparedStatement pstmt=null;
				try {
					chatMain=new ChatMain();
					pstmt=chatMain.con.prepareStatement(sql);
					int result=pstmt.executeUpdate(); //DML
					if(result==0) {
						JOptionPane.showMessageDialog(title_id, "가입실패");
					}else {
						JOptionPane.showMessageDialog(title_id, "가입성공");
						System.exit(0);
					}
				} catch (SQLException s) {
					s.printStackTrace();
				}finally {
					if(pstmt != null) {
						try {
							pstmt.close();
						} catch (SQLException s) {
							s.printStackTrace();
						}
					}
				}
			}	
		});
		
		setSize(200,300);
		setBackground(Color.WHITE);
		setVisible(true);
		setBackground(Color.GREEN);
	}
}
