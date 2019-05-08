package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

//클라이언트마다 1대1 대응되는 쓰레드 생성
//다중 사용자가 메세지를 주고 받아야 하므로 비동기 방식으로 처리해야 된다. 따라서 쓰레드로 구현해야 한다..
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
			//msg 분석하기
			//json을 객체처럼 쓰려면, 객체화 시켜야한다.. 현재는 그냥 스트림일 뿐이다
			//dispatcher 클래스에 객체화 분담..
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