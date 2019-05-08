package p0117.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//���� ������ �����Ͽ�, Ŭ���̾�Ʈ�� ������ ���� ��������
//serversocket�� �ۼ�ȭ�Ⱑ �ƴ϶�, ��ȭ ��ȣ�� �����ϴ� ���� ��������
public class EchoServer {
	int port=7777; /*��Ʈ��ũ ���α׷� �� ���μ��� ������ ���� ��ȣ
	( ~1024������ �ý��� ���� ��Ʈ�̱� ������ ������)*/
	ServerSocket server;
	Socket client; //��ȭ�� ����
	InetAddress inet;
	public EchoServer() {
		try {
			server=new ServerSocket(port);
			System.out.println("���� ��ü ����");
			while(true) {
				client=server.accept(); //�����ڰ� ���� ������ ��� ����ϸ�, ���� ���� ������� �ʴ´�
				inet=client.getInetAddress();
				String ip=inet.getHostAddress();
				System.out.println(ip+"���� ����");
				
				//���������κ��� �ǻ̱�
				InputStream is=client.getInputStream();
				InputStreamReader reader=new InputStreamReader(is);
				BufferedReader buffR=new BufferedReader(reader);
				//��Ʈ�����κ��� �����͸� �о�鿩����
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
