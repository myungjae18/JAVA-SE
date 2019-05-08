package server;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*Ŭ���̾�Ʈ�� ��û�� �ܼ��� �޼����� ���ѵǴ� ���� �ƴϹǷ�, ��û Ÿ�Կ� ���� � ������ ¥�ߵ� ���� ����
����� �ϹǷ�, ����� ����������.. ���� ������ �м� ��ü�� �д�..*/
public class Dispatcher {
	ServerMain serverMain;
	JSONParser jsonParser;
	
	public Dispatcher(ServerMain serverMain) {
		this.serverMain=serverMain;
		jsonParser=new JSONParser();
	}
	public void dispatch(String msg) {
		try {
			JSONObject obj=(JSONObject)jsonParser.parse(msg); //������ �м�
			String requestType=(String)obj.get("requestType");
			if(requestType.equals("login")) { //�α����� ���ϸ�..
				serverMain.area.append("�α���\n");
			}else if(requestType.equals("chat")) { //ä���� ���ϸ�
				serverMain.area.append("��ȭ\n");
			}else if(requestType.equals("addFriend")) { //ä���� ���ϸ�
				serverMain.area.append("ģ�� �߰�\n");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
