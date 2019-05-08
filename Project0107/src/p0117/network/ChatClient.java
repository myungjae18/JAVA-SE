package p0117.network;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame{
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	JButton bt;
	
	Socket client; /*네트워크의 기술적 부분을 숨겨놓아 추상화하여 개발자는 네트워크의 하부 지식을 모르더라도
	네트워크 프로그램이 가능하도록 지원하는 객체로써 거의 모든 프로그램에서 소켓이라는 이름을 사용한다*/
	String ip="192.168.0.17";
	int port=7777;
	
	OutputStream out;
	OutputStreamWriter writer;
	BufferedWriter buffW;
	
	public ChatClient() {
		area=new JTextArea();
		scroll=new JScrollPane(area);
		p_south=new JPanel();
		t_input=new JTextField(15);
		bt=new JButton("접속");
		
		add(scroll);
		add(p_south, BorderLayout.SOUTH);
		
		p_south.add(t_input);
		p_south.add(bt);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		
		//입력 컴포넌트와 리스너 연결
		t_input.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				int key=e.getKeyCode();
				if (key==KeyEvent.VK_ENTER) {
					//서버에 데이터를 출력( 실행 중인 프로그램에서 데이터가 나가야함 )
					String message=t_input.getText();
					try {
						buffW.write(message+"\n"); //\n을 명시를 안하면 끝난줄 모름
						//버퍼 계열의 출력 스트림은 flush()를 호출해야 버퍼에 남겨진 데이터가 완전히 출력
						buffW.flush();
						t_input.setText("");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void connect() {
		//접속 시도
		try {
			client=new Socket(ip, port);
			
			//접속이 완료되면, 스트림을 뽑아서 대화에 사용할 수 있다
			out=client.getOutputStream();
			writer=new OutputStreamWriter(out);
			buffW=new BufferedWriter(writer);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ChatClient();
	}
}
