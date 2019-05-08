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
	Dispatcher dispatcher; //Ŭ���̾�Ʈ�� ��û ���� �м� ��ü
	
	public ServerMain() {
		p_north = new JPanel();
		t_ip = new JTextField();
		t_port = new JTextField();
		bt = new JButton("���� ����");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		bar=scroll.getVerticalScrollBar();
		bar.setValue(bar.getMaximum());
		
		area.setFont(new Font("����", Font.BOLD, 25));
		t_ip.setPreferredSize(new Dimension(200, 25));
		t_port.setPreferredSize(new Dimension(80, 25));
		
		p_north.add(t_ip);
		p_north.add(t_port);
		p_north.add(bt);
		
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		
		//t_ip�� ip �Ҵ��ϱ�
		t_ip.setText(getIp());
		t_port.setText(Integer.toString(port));
		
		thread=new Thread() {
			public void run() {
				runServer(); /*accept() �޼��尡 ������ �߻���Ű�Ƿ� ���� �޼���� UI�� �̺�Ʈ��
				�����ؾ� �Ǳ� ������ ������ ������ �ϸ� �ȵȴ�..*/
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
	//�� ip �ּ� ������
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
			area.append("���� ���� �� listen ����..\n");
			Socket socket=server.accept(); //������ �߰ߵ� �� ���� ������ �߻��ȴ�
			area.append("Ŭ���̾�Ʈ ����..\n");
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











