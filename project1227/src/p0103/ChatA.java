package p0103;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatA extends JFrame{
	//앞으로 개발 시 필요한 건 보유(필요 객체를 has a 관계로 갖자)
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

		//이벤트 연결
		bt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ChatB,ChatC 생성
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
