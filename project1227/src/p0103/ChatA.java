package p0103;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatA extends JFrame{
	//������ ���� �� �ʿ��� �� ����(�ʿ� ��ü�� has a ����� ����)
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	JButton bt;
	
	ChatA chatA;
	ChatB chatB;
	ChatC chatC;

	public ChatA(){
		area=new JTextArea();
		scroll=new JScrollPane(area);
		p_south=new JPanel();
		t_input=new JTextField(12);
		bt=new JButton("OPEN");
		chatA=this;

		p_south.add(t_input);
		p_south.add(bt);
		add(scroll);
		add(p_south, BorderLayout.SOUTH);

		//�̺�Ʈ ����
		bt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ChatB,ChatC ����
				chatB=new ChatB();
				chatC=new ChatC();
			}
		});
		t_input.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent k){
			
			}
		});
		
		setBounds(100,100,300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args){
		new ChatA();
	}
}
