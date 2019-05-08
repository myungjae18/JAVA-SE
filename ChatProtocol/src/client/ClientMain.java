package client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientMain extends JFrame{
	JPanel p_north;
	JPanel p_south;
	JTextField t_ip;
	JTextField t_port;
	JTextField t_input;
	JButton bt;
	JTextArea area;
	JScrollPane scroll;
	JScrollBar bar;
	Socket socket;
	MessageThread messageThread;
		
	public ClientMain() {
		p_north = new JPanel();
		p_south = new JPanel();
		t_ip = new JTextField("192.168.0.28");
		t_port = new JTextField("7777");
		t_input = new JTextField();
		bt = new JButton("����");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		bar=scroll.getVerticalScrollBar();
		bar.setValue(bar.getMaximum());
		
		area.setFont(new Font("����", Font.BOLD, 25));
		t_ip.setPreferredSize(new Dimension(200, 25));
		t_port.setPreferredSize(new Dimension(80, 25));
		t_input.setPreferredSize(new Dimension(380, 25));
		
		p_north.add(t_ip);
		p_north.add(t_port);
		p_north.add(bt);
		p_south.add(t_input);
		
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		add(p_south, BorderLayout.SOUTH);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		
		t_input.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==KeyEvent.VK_ENTER) {
					sendData();
				}
			}
		});
		
		setVisible(true);
		setSize(400,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void connect() {
		String ip=t_ip.getText();
		int port=Integer.parseInt(t_port.getText());
		try {
			socket=new Socket(ip, port);
			messageThread=new MessageThread(this, socket);
			messageThread.start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*json �������� ������, json ��ü�� ��ü�̱� ������ ��Ʈ��ũ��  ������ �� �����Ƿ�,
	Stringȭ ���Ѽ� �����ؾ� �Ѵ�*/
	public void sendData() {
		StringBuffer sb=new StringBuffer();
		sb.append("{");
		sb.append("\"requestType\" :\"chat\",");
		sb.append("\"id\" : \"bat\",");
		sb.append("	\"msg\" : \"�� �Ծ���?\"");
		sb.append("}");
		
		String msg=sb.toString();		
		messageThread.send(msg);
	}
	
	public static void main(String[] args) {
		new ClientMain();
	}
}











