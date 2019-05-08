/*
 * GUI����� ���ڼ��� ����.
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
	ServerSocket server; //������ ������ ����.
	Thread thread;
	/* 
	thread�� ����ΰ� �ƴϴ�. �� GUI�� ���ġ �����Ƿ�,
	�󸶵��� ���ѷ����� ������ �ص� �������.
	*/
	/*while���� ���������� �����ϸ� while���� ����� ������ ������ �Ҹ��ع����� ������
	��� ��������� �������Ѿ� �ϴµ� ������ �ϳ��̰�, �����ڰ� ���� ���� ���
	���� ���� ���ο� �����ڰ� ���� ������ �� �����ڷ� ��ü�Ǿ� ������..
		�ذ�å) ������ �����ڸ� ���ؼ� ������ �����ϴ� ������ 
		�÷��� �����ӿ��� �̿��Ͽ� �������� �ø��� �ȴ�...
	*/
	Vector list=new Vector(); //���ʸ� '<>'�� �̿��Ͽ� ������ �ڷ����� ������ �� �ִ�..
	
	int port=9999;
	
	public EchoServer() {
		super("GUI ��� ���ڼ���");
		p_north=new JPanel();
		t_port=new JTextField(Integer.toString(port),7);
		bt=new JButton("���� ����");
		area=new JTextArea();
		scroll=new JScrollPane(area);
		thread=new Thread() {
			public void run() {
				runServer(); //�����尡 �����ϰ� �����ν�, ���ѷ����� ������ �������� �Ѵ�.
			}
		};
		
		p_north.add(t_port);
		p_north.add(bt);
		add(scroll);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thread.start(); //�����忡�� �ñ�.
			}
		});
		
		add(p_north,BorderLayout.NORTH);
		setBounds(400,100,300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//���� ����.
	public void runServer() {
		port=Integer.parseInt(t_port.getText());
		try {
			server=new ServerSocket(port);
			area.append("������ü ����.\n");
			/*
			�ڹٴ� Thread����� ����, �����ڰ� �˰� �־��� '�����'��
			'���� Thread'�� �����ϰ� �ȴ�.
			����Thread�� ������ �� ������̰�, �� ����δ� ���α׷��� ���� �� ��̴�.
			
			����Thread�� ���α׷��� ����ؾ� �Ѵ�.
			GUI���α׷��ֿ��� ����Thread�� �̺�Ʈ ������ �׷��� ó���� ����ϹǷ�,
			���� ���¸� �������� �Ѵ�.
			 1) ���� ����.
			 2) ������.
			*/
						
			while(true) {
				Socket client=server.accept();
				ServerThread st=new ServerThread(client, this);
				st.start(); //�񵿱� ������� ����
				//->���� �����ڰ� run()�� ���� ȣ���ϸ� �Ϲ� �޼���� �����Ͽ�
				//�񵿱� ����� ���� ������� ����Ǿ� ������
				list.add(st); //ä�� ������ 1�� �߰�				
				
				String ip=client.getInetAddress().getHostAddress();
				area.append(ip+" ����.\n");
				area.append("����"+list.size()+"�� ������ \n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new EchoServer();
	}
}
