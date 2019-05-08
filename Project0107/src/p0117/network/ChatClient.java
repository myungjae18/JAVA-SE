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
	
	Socket client; /*��Ʈ��ũ�� ����� �κ��� ���ܳ��� �߻�ȭ�Ͽ� �����ڴ� ��Ʈ��ũ�� �Ϻ� ������ �𸣴���
	��Ʈ��ũ ���α׷��� �����ϵ��� �����ϴ� ��ü�ν� ���� ��� ���α׷����� �����̶�� �̸��� ����Ѵ�*/
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
		bt=new JButton("����");
		
		add(scroll);
		add(p_south, BorderLayout.SOUTH);
		
		p_south.add(t_input);
		p_south.add(bt);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		
		//�Է� ������Ʈ�� ������ ����
		t_input.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				int key=e.getKeyCode();
				if (key==KeyEvent.VK_ENTER) {
					//������ �����͸� ���( ���� ���� ���α׷����� �����Ͱ� �������� )
					String message=t_input.getText();
					try {
						buffW.write(message+"\n"); //\n�� ��ø� ���ϸ� ������ ��
						//���� �迭�� ��� ��Ʈ���� flush()�� ȣ���ؾ� ���ۿ� ������ �����Ͱ� ������ ���
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
		//���� �õ�
		try {
			client=new Socket(ip, port);
			
			//������ �Ϸ�Ǹ�, ��Ʈ���� �̾Ƽ� ��ȭ�� ����� �� �ִ�
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
