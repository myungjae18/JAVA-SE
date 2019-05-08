package server;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerMain extends JFrame{
	JPanel p_north;
	JTextField t_ip;
	JTextField t_port;
	JButton bt;
	JTextArea area;
	JScrollPane scroll;
	JScrollBar bar;
	ServerSocket server;
	int port=7777;
	Thread thread;
	Dispatcher dispatcher; //클라이언트의 요청 내역 분석 객체
	
	public ServerMain() {
		p_north = new JPanel();
		t_ip = new JTextField();
		t_port = new JTextField();
		bt = new JButton("서버 가동");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		bar=scroll.getVerticalScrollBar();
		bar.setValue(bar.getMaximum());
		
		area.setFont(new Font("굴림", Font.BOLD, 25));
		t_ip.setPreferredSize(new Dimension(200, 25));
		t_port.setPreferredSize(new Dimension(80, 25));
		
		p_north.add(t_ip);
		p_north.add(t_port);
		p_north.add(bt);
		
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		
		//t_ip에 ip 할당하기
		t_ip.setText(getIp());
		t_port.setText(Integer.toString(port));
		
		thread=new Thread() {
			public void run() {
				runServer(); /*accept() 메서드가 지연을 발생시키므로 메인 메서드는 UI와 이벤트를
				감지해야 되기 때문에 지연에 빠지게 하면 안된다..*/
			}
		};
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thread.start();
			}
		});
		
		dispatcher=new Dispatcher(this);
		setVisible(true);
		setSize(400,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//내 ip 주소 얻어오기
	public String getIp() {
		String ip=null;
		try {
			InetAddress inet=InetAddress.getLocalHost();
			ip=inet.getHostAddress();
			System.out.println(ip);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ip;
	}
	public void runServer() {
		String ip=t_ip.getText();
		port=Integer.parseInt(t_port.getText());
		
		try {
			server=new ServerSocket(port);
			area.append("서버 가동 및 listen 시작..\n");
			Socket socket=server.accept(); //접속이 발견될 때 까지 지연이 발생된다
			area.append("클라이언트 접속..\n");
			MessageThread messageThread=new MessageThread(this, socket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ServerMain();
	}
}











