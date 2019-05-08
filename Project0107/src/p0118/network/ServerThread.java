package p0118.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

//클라이언트 측에 대화용 쓰레드가 존재하듯이 서버 측에도 대화용 쓰레드를 정의해야 한다.(두 객체의 목적은 동일)
//결국 채팅이란 접속자마다 서로 방해받지 않고 독립적으로 메새지 입출력을 수행해야 하므로 쓰레드로 구현해야 한다

public class ServerThread extends Thread{
	EchoServer echoServer;
	Socket client;
	BufferedReader buffr;
	BufferedWriter buffw;
		
	public ServerThread(Socket client, EchoServer echoServer) {
		this.client=client;		
		this.echoServer=echoServer;
		
		//소켓으로부터 스트림 뽑기.
		try {
			buffr=new BufferedReader(new InputStreamReader(client.getInputStream()));
			buffw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//메세지 보내기
	public void send(String msg) {
		try {
			buffw.write(msg+"\n");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//메세지 받기
	public void listen() {
		try {
			String msg=buffr.readLine(); //청취
			send(msg); //전달
			echoServer.area.append(msg+"\n"); //로그 남기기
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
