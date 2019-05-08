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

//로그인 화면을 정의한다
public class Login extends JPanel{
	//입력창 영역을 차지할 패널
	JPanel p_txt;
	JTextArea id,pw;
	//로그인 시 필요한 아이디와 패스워드 입력창 구현
	JTextField t_id, t_pw;
	//버튼 영역을 차지할 패널
	JPanel p_bt;
	//입력 확인 버튼 및 회원가입 버튼 구현
	JButton bt_accept, bt_regist;
	//-----------------------------------------------------------------
	Regist regist; //가입 화면 클래스
	ChatMain chatMain; //메인 화면 클래스
	LoginSuccess loginSuccess; //로그인 성공 시 
	
	public Login() {
		p_txt=new JPanel();
		id=new JTextArea("   ID",1,3);
		pw=new JTextArea("   PW",1,4);
		t_id=new JTextField(15);
		t_pw=new JTextField(15);
		
		p_bt=new JPanel();
		bt_accept=new JButton("확인");
		bt_regist=new JButton("가입");
		
		//p_txt 부분 디자인
		id.setEditable(false); //수정 불가능
		
		p_txt.setPreferredSize(new Dimension(250, 400));
		p_txt.setBackground(Color.WHITE);
		p_txt.add(id);
		p_txt.add(t_id);
		p_txt.add(pw);
		p_txt.add(t_pw);
		
		//p_bt 부분 디자인
		pw.setEditable(false); //수정 불가능
		
		p_bt.add(bt_accept);
		p_bt.add(bt_regist);
		
		//버튼에 이벤트 구현
		
		bt_accept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String content_id=t_id.getText();
				String content_pw=t_pw.getText();
				String sqlID="select * from users where id='"+content_id+"'";
				PreparedStatement pstmt=null;
				ResultSet rs=null;
								
				//t_id와 t_pw에 텍스트를 입력하지 않았을 경우
				if(content_id.length()==0) {
					JOptionPane.showMessageDialog(p_txt, "아이디를 입력해주세요");
					return;
				}
				if(content_pw.length()==0) {
					JOptionPane.showMessageDialog(p_txt, "비밀번호를 입력해주세요");
					return;
				}
				
				//아이디와 패스워드가 데이터베이스에 존재하지 않는 것을 입력했을 경우
				String sql="select * from users where id='"+content_id+"', password='"+content_pw+"'";
								
				try {
					chatMain=new ChatMain();
					pstmt=chatMain.con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					if(rs.next()==false) {
						JOptionPane.showMessageDialog(p_txt, "등록되지 않은 아이디나 비밀번호입니다");
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
				regist=new Regist(); //회원 가입 클래스 호출
			}
		});
		
		//패널에 부착
		add(p_txt);
		add(p_bt, BorderLayout.SOUTH);
		
		//화면 디자인
		setBackground(Color.YELLOW);
		setVisible(true);
	}
}
