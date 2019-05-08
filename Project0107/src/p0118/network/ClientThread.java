package p0118.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientThread extends Thread{
	BufferedReader buffr;
	BufferedWriter buffw;
	ChatClient chatClient;
	
	public ClientThread(Socket client, ChatClient chatClient) {
		this.chatClient=chatClient;
		try {
			buffr=new BufferedReader(new InputStreamReader(client.getInputStream()));
			buffw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void send(String msg) {
		try {
			buffw.write(msg+"\n");
			buffw.flush();
			//listen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//���
	public String listen() {
		String msg=null;
		try {
			/*readLine() �����¿� ������, �Էµ����Ͱ� ���� �� ��� ���¿��� Ǯ����..
			�� �� ���� ó���� ��Ʈ���� Ư�� ��, ������ ���ڿ��� ���� �˷����� ������
			readLine()�� ��� �����¿� �����ִ�*/
			msg=buffr.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}
	public void run() {
		while(true) {
			String msg=listen();
			//�������� ����� �޼����� area�� �ݿ�����
			chatClient.area.append(msg+"\n");
		}
	}
}

