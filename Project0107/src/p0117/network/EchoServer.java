package p0117.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//소켓 서버를 구축하여, 클라이언트의 접속을 먼저 감지하자
//serversocket은 송수화기가 아니라, 전화 신호를 감지하는 장비로 이해하자
public class EchoServer {
	int port=7777; /*네트워크 프로그램 간 프로세스 구분을 위한 번호
	( ~1024까지는 시스템 점유 포트이기 때문에 사용금지)*/
	ServerSocket server;
	Socket client; //대화용 소켓
	InetAddress inet;
	public EchoServer() {
		try {
			server=new ServerSocket(port);
			System.out.println("서버 객체 생성");
			while(true) {
				client=server.accept(); //접속자가 있을 때까지 계속 대기하며, 이하 행은 수행되지 않는다
				inet=client.getInetAddress();
				String ip=inet.getHostAddress();
				System.out.println(ip+"접속 감지");
				
				//종이컵으로부터 실뽑기
				InputStream is=client.getInputStream();
				InputStreamReader reader=new InputStreamReader(is);
				BufferedReader buffR=new BufferedReader(reader);
				//스트림으로부터 데이터를 읽어들여보자
				String data=null;
				while(true) {
					data=buffR.readLine();
					System.out.println(data);
				}
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new EchoServer();
	}

}
