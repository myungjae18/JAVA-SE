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
		bt=new JButton("�α���");

		//������Ʈ�� ��Ÿ�� ����
		t_id.setPreferredSize(new Dimension(270,25));
		t_password.setPreferredSize(new Dimension(270,25));

		//panel�� ������Ʈ �����ϱ�
		p_center.add(t_id);
		p_center.add(t_password);
		p_south.add(bt);

		//�����쿡 �г� �����ϱ� - ���� ���� ������ ����
		//this�� ���۷��� �����ε�, �� �ȿ� ����ִ� ���� �� Ŭ�����κ��� ������ �ν��Ͻ��� �ڽ� �����θ� ����Ű�� ����� �����Ѵ�..
		add(p_center);
		add(p_south, BorderLayout.SOUTH);

		setSize(300,160);
		setVisible(true);
	}
	public static void main(String[] args){
		new LoginForm();
	}
}
