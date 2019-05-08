package p0121.network;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiServer extends JFrame{
	JPanel p_north;
	JTextField t_port;
	JButton bt;
	JTextArea area;
	JScrollPane scroll;
	JScrollBar bar;
	ServerSocket server; //접속자 감지용 소켓
	int port=8888;
	Thread serverThread; //main thread가 대기 상태에 빠지지 않게 하기 위한 쓰레드
	/*
	컬렉션 프레임웍 중 순서가 있는 처리를 위한 List 계열의 하위 객체 중 Vector를 사용(ArrayList와 거의 동일하나,
	다중 쓰레드 환경에서 동기화를 지원하기 때문에 코드가 엉키지 않는다..
	*/
	Vector<ServerThread> list=new Vector(); //서버 측에 생성된 아바타들을 담을 배열
	
	public MultiServer() {
		p_north=new JPanel();
		t_port=new JTextField(Integer.toString(port),8);
		bt=new JButton("서버가동");
		area=new JTextArea();
		scroll=new JScrollPane(area);
		bar=scroll.getVerticalScrollBar();
				
		//쓰레드 생성 및 재정의
		serverThread=new Thread() {
			public void run() {
				runServer();
			}
		};
		
		p_north.add(t_port);
		p_north.add(bt);
		
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		
		area.setFont(new Font("돋움", Font.BOLD, 23)); //폰트 설정
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				serverThread.start();				
			}
		});
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void runServer() {
		port=Integer.parseInt(t_port.getText());
		try {
			server=new ServerSocket(port);
			area.append("서버 가동");
			
			while(true){
				Socket client=server.accept(); //서버 가동(접속자를 기다림)
				String ip=client.getInetAddress().getHostAddress();
				area.append(ip+"님 접속\n");
				
				//접속과 동시에 대화를 나눌 아바타 생성
				ServerThread st=new ServerThread(this, client);
				st.start();
				list.add(st); //Object형으로 upcasting
				//->배열에서 가져올 때는 자기 자신의 자료형으로 downcasting
				//->제너릭 타입( <> )으로 컬렉션 프레임웍 객체를 선언하면 형변환의 불편함이 해결
				area.append("현재"+list.size()+"명 접속 중\n");
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new MultiServer();
	}
}
