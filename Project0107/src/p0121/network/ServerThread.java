package p0121.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/*
������ Ŭ���̾�Ʈ �� ���� ���������� �޼����� �ְ� ��������
�ϳ��� ���α׷� ������ ���������� ���� ������ ���� ������ �����尡 �ʿ��ϴ�
*/
/*
�� Ŭ������ �����ϴ� Ŭ���̾�Ʈ���� 1��1 �����Ͽ� ��ȭ�� ���� �ƹ�Ÿ�� ����.
���� ��ȭ�� �ʿ��� ����� ��Ʈ���� �����ؾ� �ϰ� �� ��Ʈ���� ���Ӱ� �Բ� �����Ǵ� �������κ��� ���;�
�ϱ� ������ ���ϵ� �����ؾ� �Ѵ�..
 */
public class ServerThread extends Thread{
	MultiServer multiServer;
	
	Socket client;
	BufferedReader buffr;
	BufferedWriter buffw;
	boolean flag=true;
	
	public ServerThread(MultiServer multiServer, Socket client) {
		this.multiServer=multiServer;
		this.client=client;
		
		try {
			buffr=new BufferedReader(new InputStreamReader(client.getInputStream()));
			buffw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//û��
	public void listen() {
		try {
			String msg=buffr.readLine();
			
			//������ ������ ��� �ƹ�Ÿ�� send�� ȣ��
			for (int i = 0; i < multiServer.list.size(); i++) {
				ServerThread st=multiServer.list.get(i);
				st.send(msg); //Ŭ���̾�Ʈ�� ����
			}
			multiServer.area.append(msg+"\n"); //��� �����
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("Ŭ���̾�Ʈ�� ����Ǿ����ϴ�...");
			//���Ϳ��� ����
			multiServer.list.remove(this);
			multiServer.area.append("���� "+multiServer.list.size()+"�� �̿� ��\n");
			multiServer.bar.setMaximum(multiServer.bar.getMaximum());
		}
	}
	//����
	public void send(String msg) {
		try {
			buffw.write(msg+"\n");
			buffw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run() {
		while(flag) {
			listen();
		}
	}
}