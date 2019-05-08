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
	JPanel p_input; //�Է� ������Ʈ �� �� 
	
	public RegistMember() {
		//���� Ŭ������ p_center�� BorderLayout����
		this.setLayout(new BorderLayout());
		p_south=new JPanel();
		p_west=new JPanel();
		p_center=new JPanel();
		p_input=new JPanel();
		
		la_id=new JLabel("���̵�");
		la_password1=new JLabel("��й�ȣ");
		la_password2=new JLabel("��й�ȣ Ȯ��");
		la_name=new JLabel("�̸�");
		la_birth=new JLabel("�������");
		
		t_id=new JTextField();
		t_password1=new JTextField();
		t_password2=new JTextField();
		t_name=new JTextField();
		t_birth=new JTextField();
		
		bt_check=new JButton("Ȯ��");
		bt_regist=new JButton("����");
		
		p_id=new JPanel();
		
		//���� ó��
		p_west.setPreferredSize(new Dimension(150,400));
		p_west.setBackground(Color.WHITE);
		
		//�󺧵� ũ�� ����
		Dimension d2=new Dimension(120,25);
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
				
		p_center.setLayout(new BorderLayout());
		p_center.add(p_west, BorderLayout.WEST);
		
		p_center.add(p_input);
		//�Է� ������Ʈ�� ũ�� ����
		Dimension d=new Dimension(350,25);
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
		
		//���ʿ� ��ư ���� �� �г� ����
		p_south.add(bt_regist);
		
		add(p_center);
		add(p_south, BorderLayout.SOUTH);
		
		setPreferredSize(new Dimension(800,360));
		setBackground(Color.YELLOW);
	}
}