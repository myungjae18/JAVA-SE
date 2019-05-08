/*
 * GUI기반의 에코서버 구축.
 * */
package p0118.network;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EchoServer extends JFrame{
	JPanel p_north;
	JTextField t_port;
	JButton bt;
	JTextArea area;
	JScrollPane scroll;
	ServerSocket server; //접속자 감지용 소켓.
	Thread thread;
	/* 
	thread는 실행부가 아니다. 즉 GUI를 담당치 않으므로,
	얼마든지 무한루프에 빠지게 해도 상관없다.
	*/
	/*while문의 지역변수로 선언하면 while문이 실행될 때마다 변수가 소멸해버리기 때문에
	적어도 멤버변수에 유지시켜야 하는데 변수가 하나이고, 접속자가 여러 명일 경우
	변수 값이 새로운 접속자가 들어올 때마다 그 접속자로 대체되어 버린다..
		해결책) 들어오는 접속자를 위해서 변수가 존재하는 공간을 
		컬랙션 프레임웍을 이용하여 동적으로 늘리면 된다...
	*/
	Vector list=new Vector(); //제너릭 '<>'을 이용하여 들어오는 자료형을 제한할 수 있다..
	
	int port=9999;
	
	public EchoServer() {
		super("GUI 기반 에코서버");
		p_north=new JPanel();
		t_port=new JTextField(Integer.toString(port),7);
		bt=new JButton("서버 가동");
		area=new JTextArea();
		scroll=new JScrollPane(area);
		thread=new Thread() {
			public void run() {
				runServer(); //쓰레드가 수행하게 함으로써, 무한루프에 빠져도 괜찮도록 한다.
			}
		};
		
		p_north.add(t_port);
		p_north.add(bt);
		add(scroll);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thread.start(); //쓰레드에게 맡김.
			}
		});
		
		add(p_north,BorderLayout.NORTH);
		setBounds(400,100,300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//서버 가동.
	public void runServer() {
		port=Integer.parseInt(t_port.getText());
		try {
			server=new ServerSocket(port);
			area.append("서버객체 생성.\n");
			/*
			자바는 Thread기반의 언어로, 개발자가 알고 있었던 '실행부'는
			'메인 Thread'로 존재하게 된다.
			메인Thread는 기존의 그 실행부이고, 이 실행부는 프로그램의 실행 및 운영이다.
			
			메인Thread는 프로그램을 운용해야 한다.
			GUI프로그래밍에서 메인Thread는 이벤트 감지나 그래픽 처리를 담당하므로,
			이하 상태를 방지애햐 한다.
			 1) 무한 루프.
			 2) 대기상태.
			*/
						
			while(true) {
				Socket client=server.accept();
				ServerThread st=new ServerThread(client, this);
				st.start(); //비동기 방식으로 실행
				//->만약 개발자가 run()을 직접 호출하면 일반 메서드로 간주하여
				//비동기 방식이 동기 방식으로 수행되어 버린다
				list.add(st); //채팅 참여자 1명 추가				
				
				String ip=client.getInetAddress().getHostAddress();
				area.append(ip+" 접속.\n");
				area.append("현재"+list.size()+"명 참여중 \n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new EchoServer();
	}
}
