package p0102;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ChatC extends JFrame implements KeyListener{
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	ChatA chatA;
	ChatB chatB;
	

	public ChatC(ChatA chatA,ChatB chatB){
		this.chatA=chatA;
		this.chatB=chatB;
		area=new JTextArea();
		scroll=new JScrollPane(area);
		p_south=new JPanel();
		t_input=new JTextField(12);
		
		add(scroll);
		p_south.add(t_input);
		add(p_south, BorderLayout.SOUTH);
		setVisible(true);
		setBounds(500,500,300,400);

		t_input.addKeyListener(this);
		this.addWindowListener(new MyWindowAdapter());
	}
	public void keyReleased(KeyEvent k){
		if(k.getKeyCode()==KeyEvent.VK_ENTER){
			System.out.println("키 누름");
			String msg=t_input.getText();
			sendMsg(msg);
			//기존의 t_input의 입력값을 다시 초기화
			t_input.setText("");
		}
	}
	public void keyPressed(KeyEvent k){}
	public void keyTyped(KeyEvent k){}
	
	//대화 상대방의 textarea뿐만 아니라 나의 textarea에 메세지를 출력하자
	public void sendMsg(String msg){
		area.append(msg+"\n");
		chatA.area.append(msg+"\n");
		chatB.area.append(msg+"\n");
	}
}
