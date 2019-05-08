package json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*자바언어에서 json 형식을 다루어본다
json과 더불어 xml이 기종 간 데이터를 교환하는데 압도적으로 많이 쓰인다
*/
public class JSONParserTest {
	public static void main(String[] args) {
		/*json은 프로그래밍 언어가 아니라,
		단순한 자바 스크립트 형식을 따르는 표기법에 지나지 않는다.
		따라서 자바 언어에서 json을 다루려면 문자열 취급하면 된다.
		*/
		//로그인, 로그아웃, 메세지, 아이템 구매, 친구 추가....
		//requestType : 무엇을 원하는지를 결정하는 변수
		//ex) requestType : "login",...
		StringBuffer sb=new StringBuffer();
		sb.append("{");
		sb.append(	"\"requestType\" : \"login\",");
		sb.append("\"id\" : \"batman\",");
		sb.append("\"pw\" : \"1234\"");
		sb.append("}");
		System.out.println(sb.toString());
		//위의 문자열은 현재까지 그냥 문자열일 뿐이지만 해석(파싱)한 후에는 json 객체로 취급될 수 있다
		JSONParser parser=new JSONParser();
		try {
			JSONObject obj=(JSONObject)parser.parse(sb.toString());
			System.out.println(obj.get("requestType"));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	
