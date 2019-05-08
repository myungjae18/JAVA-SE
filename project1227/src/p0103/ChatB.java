package p0103;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatB extends JFrame{
	//앞으로 개발 시 필요한 건 보유(필요 객체를 has a 관계로 갖자)
	ChatA chatA;
	ChatB chatB;
	ChatC chatC;
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	MyKeyAdapter myKeyAdapter;
	
	public ChatB(ChatA chatA){
		this.chatA=chatA;
		this.chatB=this;

		area=new JTextArea();
		scroll=new JScrollPane(area);
		p_south=new JPanel();
		t_input=new JTextField(12);
						
		p_south.add(t_input);
		add(scroll);
		add(p_south, BorderLayout.SOUTH);

		//t_input과 리스너의 연결
		myKeyAdapter=new MyKeyAdapter(chatA,this,chatC);
		t_input.addKeyListener(myKeyAdapter);

		setBounds(400,100,300,400);
		setVisible(true);
	}
}
