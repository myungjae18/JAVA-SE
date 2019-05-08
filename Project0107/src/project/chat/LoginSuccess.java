package project.chat;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

//로그인 성공 후 나올 화면을 정의한다
public class LoginSuccess extends JPanel{
	public LoginSuccess() {
		// TODO Auto-generated constructor stub
		JOptionPane.showMessageDialog(this, "로그인 성공!");
	}
}
