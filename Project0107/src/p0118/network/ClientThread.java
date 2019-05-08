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
	//듣기
	public String listen() {
		String msg=null;
		try {
			/*readLine() 대기상태에 빠지고, 입력데이터가 들어올 때 대기 상태에서 풀린다..
			이 때 버퍼 처리된 스트림의 특성 상, 상대방이 문자열의 끝을 알려주지 않으면
			readLine()은 계속 대기상태에 빠져있다*/
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
			//서버에서 날라온 메세지를 area에 반영하자
			chatClient.area.append(msg+"\n");
		}
	}
}

