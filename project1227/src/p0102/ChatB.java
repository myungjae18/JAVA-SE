package p0102;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ChatB extends JFrame implements KeyListener{
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	ChatA chatA;
	ChatC chatC;
	
	public ChatB(ChatA chatA,ChatC chatC){
		this.chatA=chatA;
		this.chatC=chatC;
		area=new JTextArea();
		scroll=new JScrollPane(area);
		p_south=new JPanel();
		t_input=new JTextField(12);
				
		add(scroll);
		p_south.add(t_input);
		add(p_south, BorderLayout.SOUTH);
		setVisible(true);
		setBounds(500,100,300,400);

		t_input.addKeyListener(this);
		this.addWindowListener(new MyWindowAdapter(this));
	}
	
	public void keyReleased(KeyEvent k){
		if(k.getKeyCode()==KeyEvent.VK_ENTER){
			System.out.println("키 누름");
			String msg=t_input.getText();
			sendMsg(chatA,chatC,msg);
			//기존의 t_input의 입력값을 다시 초기화
			System.out.println(t_input.getAccessibleContext());
			t_input.setText("");
		}
	}
	public void keyPressed(KeyEvent k){}
	public void keyTyped(KeyEvent k){}
	
	//대화 상대방의 textarea뿐만 아니라 나의 textarea에 메세지를 출력하자
	public void sendMsg(ChatA chatA,ChatC chatC,String msg){
		this.chatA=chatA;
		this.chatC=chatC;
		area.append(msg+"\n");
		System.out.println(msg);
		
		//this.chatC.area.append(msg+"\n");
		this.chatA.area.append(msg+"\n");
		this.chatA.chatC.area.append(msg+"\n");
	}
}