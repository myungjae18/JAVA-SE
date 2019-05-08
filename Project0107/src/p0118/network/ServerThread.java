package p0118.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

//Ŭ���̾�Ʈ ���� ��ȭ�� �����尡 �����ϵ��� ���� ������ ��ȭ�� �����带 �����ؾ� �Ѵ�.(�� ��ü�� ������ ����)
//�ᱹ ä���̶� �����ڸ��� ���� ���ع��� �ʰ� ���������� �޻��� ������� �����ؾ� �ϹǷ� ������� �����ؾ� �Ѵ�

public class ServerThread extends Thread{
	EchoServer echoServer;
	Socket client;
	BufferedReader buffr;
	BufferedWriter buffw;
		
	public ServerThread(Socket client, EchoServer echoServer) {
		this.client=client;		
		this.echoServer=echoServer;
		
		//�������κ��� ��Ʈ�� �̱�.
		try {
			buffr=new BufferedReader(new InputStreamReader(client.getInputStream()));
			buffw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//�޼��� ������
	public void send(String msg) {
		try {
			buffw.write(msg+"\n");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//�޼��� �ޱ�
	public void listen() {
		try {
			String msg=buffr.readLine(); //û��
			send(msg); //����
			echoServer.area.append(msg+"\n"); //�α� �����
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run() {
		while(true) {
			listen();
		}
	}
}
