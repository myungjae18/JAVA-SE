package p0118.network;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
	Choice ch;
	JTextField t_port,t_input;
	JButton bt;
	JPanel p_north;
	JTextArea area;
	JScrollPane scroll;
	Socket client; //new할 때 접속 발생.
	ClientThread ct;
		
	int port=9999;
	
	public ChatClient() {
		ch=new Choice();
		t_port=new JTextField(Integer.toString(port),7);
		bt=new JButton("접속");
		p_north=new JPanel();
		area=new JTextArea();
		scroll=new JScrollPane(area);
		t_input=new JTextField();
		
		ch.add("192.168.0.62");
		ch.add("192.168.0.17");
		ch.add("192.168.0.24");
		
		p_north.add(ch);
		p_north.add(t_port);
		p_north.add(bt);
		add(p_north,BorderLayout.NORTH);
		add(scroll);
		add(t_input,BorderLayout.SOUTH);
		
		//리스너.
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		
		t_input.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==KeyEvent.VK_ENTER){
					ct.send(t_input.getText());
					t_input.setText(null);
				}
			}
		});
		
		setBounds(100,100,300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);;
	}
	public void connect() {
		port=Integer.parseInt(t_port.getText());
		String ip=ch.getSelectedItem();
		try {
			client=new Socket(ip,port);
			//접속이 완료되었으니 대화용 쓰레드를 생성한다
			ct=new ClientThread(client, this);
			ct.start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ChatClient();
	}
}
