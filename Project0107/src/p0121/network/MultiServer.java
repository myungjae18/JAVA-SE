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
	ServerSocket server; //������ ������ ����
	int port=8888;
	Thread serverThread; //main thread�� ��� ���¿� ������ �ʰ� �ϱ� ���� ������
	/*
	�÷��� �����ӿ� �� ������ �ִ� ó���� ���� List �迭�� ���� ��ü �� Vector�� ���(ArrayList�� ���� �����ϳ�,
	���� ������ ȯ�濡�� ����ȭ�� �����ϱ� ������ �ڵ尡 ��Ű�� �ʴ´�..
	*/
	Vector<ServerThread> list=new Vector(); //���� ���� ������ �ƹ�Ÿ���� ���� �迭
	
	public MultiServer() {
		p_north=new JPanel();
		t_port=new JTextField(Integer.toString(port),8);
		bt=new JButton("��������");
		area=new JTextArea();
		scroll=new JScrollPane(area);
		bar=scroll.getVerticalScrollBar();
				
		//������ ���� �� ������
		serverThread=new Thread() {
			public void run() {
				runServer();
			}
		};
		
		p_north.add(t_port);
		p_north.add(bt);
		
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		
		area.setFont(new Font("����", Font.BOLD, 23)); //��Ʈ ����
		
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
			area.append("���� ����");
			
			while(true){
				Socket client=server.accept(); //���� ����(�����ڸ� ��ٸ�)
				String ip=client.getInetAddress().getHostAddress();
				area.append(ip+"�� ����\n");
				
				//���Ӱ� ���ÿ� ��ȭ�� ���� �ƹ�Ÿ ����
				ServerThread st=new ServerThread(this, client);
				st.start();
				list.add(st); //Object������ upcasting
				//->�迭���� ������ ���� �ڱ� �ڽ��� �ڷ������� downcasting
				//->���ʸ� Ÿ��( <> )���� �÷��� �����ӿ� ��ü�� �����ϸ� ����ȯ�� �������� �ذ�
				area.append("����"+list.size()+"�� ���� ��\n");
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
