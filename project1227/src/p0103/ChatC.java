package p0103;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatC extends JFrame{
	//������ ���� �� �ʿ��� �� ����(�ʿ� ��ü�� has a ����� ����)
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	
	public ChatC(){
		area=new JTextArea();
		scroll=new JScrollPane(area);
		p_south=new JPanel();
		t_input=new JTextField(12);
		
		p_south.add(t_input);
		add(scroll);
		add(p_south, BorderLayout.SOUTH);

		setBounds(400,500,300,400);
		setVisible(true);
	}
}
