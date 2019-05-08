package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

//Ŭ���̾�Ʈ���� 1��1 �����Ǵ� ������ ����
//���� ����ڰ� �޼����� �ְ� �޾ƾ� �ϹǷ� �񵿱� ������� ó���ؾ� �ȴ�. ���� ������� �����ؾ� �Ѵ�..
public class MessageThread extends Thread{
	ServerMain serverMain;
	Socket socket;
	BufferedReader buffr;
	BufferedWriter buffw;
	boolean flag=true;
	
	public MessageThread(ServerMain serverMain, Socket socket) {
		this.serverMain=serverMain;
		this.socket=socket;
		
		try {
			buffr=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void listen() {
		String msg=null;
		try {
			msg=buffr.readLine();
			//msg �м��ϱ�
			//json�� ��üó�� ������, ��üȭ ���Ѿ��Ѵ�.. ����� �׳� ��Ʈ���� ���̴�
			//dispatcher Ŭ������ ��üȭ �д�..
			serverMain.dispatcher.dispatch(msg);
			serverMain.area.append(msg+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void send(String msg) {
		while(flag) {
			listen();
		}
	}
}