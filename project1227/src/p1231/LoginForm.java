package p1231;
import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame{
	JPanel p_center, p_south;
	JTextField t_id, t_password;
	JButton bt;
	public LoginForm(){
		p_center=new JPanel();
		p_south=new JPanel();
		t_id=new JTextField();
		t_password=new JTextField();
		bt=new JButton("로그인");

		//컴포넌트의 스타일 설정
		t_id.setPreferredSize(new Dimension(270,25));
		t_password.setPreferredSize(new Dimension(270,25));

		//panel에 컴포넌트 부착하기
		p_center.add(t_id);
		p_center.add(t_password);
		p_south.add(bt);

		//윈도우에 패널 부착하기 - 나의 센터 영역에 부착
		//this는 레퍼런스 변수인데, 이 안에 들어있는 값은 이 클래스로부터 생성된 인스턴스가 자신 스스로를 가리키는 방법을 제공한다..
		add(p_center);
		add(p_south, BorderLayout.SOUTH);

		setSize(300,160);
		setVisible(true);
	}
	public static void main(String[] args){
		new LoginForm();
	}
}
