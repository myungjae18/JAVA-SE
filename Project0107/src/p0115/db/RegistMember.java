package p0115.db;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import p0110.game.GameMain;

public class RegistMember extends JPanel{
	JPanel p_south, p_west, p_center;
	JLabel la_id, la_password1, la_password2, la_name, la_birth;
	JTextField t_id, t_password1, t_password2, t_name, t_birth;
	JButton bt_check, bt_regist;
	JPanel p_id;
	JPanel p_input; //입력 컴포넌트 올 곳 
	
	public RegistMember() {
		//현재 클래스와 p_center를 BorderLayout으로
		this.setLayout(new BorderLayout());
		p_south=new JPanel();
		p_west=new JPanel();
		p_center=new JPanel();
		p_input=new JPanel();
		
		la_id=new JLabel("아이디");
		la_password1=new JLabel("비밀번호");
		la_password2=new JLabel("비밀번호 확인");
		la_name=new JLabel("이름");
		la_birth=new JLabel("생년월일");
		
		t_id=new JTextField();
		t_password1=new JTextField();
		t_password2=new JTextField();
		t_name=new JTextField();
		t_birth=new JTextField();
		
		bt_check=new JButton("확인");
		bt_regist=new JButton("가입");
		
		p_id=new JPanel();
		
		//서쪽 처리
		p_west.setPreferredSize(new Dimension(150,400));
		p_west.setBackground(Color.WHITE);
		
		//라벨들 크기 설정
		Dimension d2=new Dimension(120,25);
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
				
		p_center.setLayout(new BorderLayout());
		p_center.add(p_west, BorderLayout.WEST);
		
		p_center.add(p_input);
		//입력 컴포넌트의 크기 설정
		Dimension d=new Dimension(350,25);
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
		
		//남쪽에 버튼 부착 및 패널 부착
		p_south.add(bt_regist);
		
		add(p_center);
		add(p_south, BorderLayout.SOUTH);
		
		setPreferredSize(new Dimension(800,360));
		setBackground(Color.YELLOW);
	}
}