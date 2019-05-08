package p0121.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/*
클라이언트가 서버로부터 메세지를 받는 타이밍은
메세지를 보낼 때뿐만 아니라 보내지 않을 때도 메세지를 받아야 하므로,
무한 루프 및 비동기 방식으로 처리해야 한다
*/
public class ClientThread extends Thread {
	ChatClient chatClient;

	Socket client; // 대화용 소켓
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
	// 청취
	public void listen() {
		try {
			String msg = buffr.readLine();
			//send(msg); // 클라이언트에 전송
			chatClient.area.append(msg +"\n"); // 기록 남기기
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 전달
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
