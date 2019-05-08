package server;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*클라이언트의 요청이 단순히 메세지에 국한되는 것이 아니므로, 요청 타입에 따라 어떤 로직을 짜야될 지를 결정
지어야 하므로, 상당히 복잡해진다.. 따라서 별도의 분석 객체를 둔다..*/
public class Dispatcher {
	ServerMain serverMain;
	JSONParser jsonParser;
	
	public Dispatcher(ServerMain serverMain) {
		this.serverMain=serverMain;
		jsonParser=new JSONParser();
	}
	public void dispatch(String msg) {
		try {
			JSONObject obj=(JSONObject)jsonParser.parse(msg); //데이터 분석
			String requestType=(String)obj.get("requestType");
			if(requestType.equals("login")) { //로그인을 원하면..
				serverMain.area.append("로그인\n");
			}else if(requestType.equals("chat")) { //채팅을 원하면
				serverMain.area.append("대화\n");
			}else if(requestType.equals("addFriend")) { //채팅을 원하면
				serverMain.area.append("친구 추가\n");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
