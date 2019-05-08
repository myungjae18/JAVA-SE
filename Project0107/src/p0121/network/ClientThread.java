package p0121.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/*
Ŭ���̾�Ʈ�� �����κ��� �޼����� �޴� Ÿ�̹���
�޼����� ���� ���Ӹ� �ƴ϶� ������ ���� ���� �޼����� �޾ƾ� �ϹǷ�,
���� ���� �� �񵿱� ������� ó���ؾ� �Ѵ�
*/
public class ClientThread extends Thread {
	ChatClient chatClient;

	Socket client; // ��ȭ�� ����
	BufferedReader buffr;
	BufferedWriter buffw;

	public ClientThread(ChatClient chatClient, Socket client) {
		this.chatClient = chatClient;
		this.client = client;
		
		try {
			buffr=new BufferedReader(new InputStreamReader(client.getInputStream()));
			buffw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// û��
	public void listen() {
		try {
			String msg = buffr.readLine();
			//send(msg); // Ŭ���̾�Ʈ�� ����
			chatClient.area.append(msg +"\n"); // ��� �����
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// ����
	public void send(String msg) {
		try {
			buffw.write(msg +"\n");
			buffw.flush();
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
