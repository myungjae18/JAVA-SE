package json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*�ڹپ��� json ������ �ٷ���
json�� ���Ҿ� xml�� ���� �� �����͸� ��ȯ�ϴµ� �е������� ���� ���δ�
*/
public class JSONParserTest {
	public static void main(String[] args) {
		/*json�� ���α׷��� �� �ƴ϶�,
		�ܼ��� �ڹ� ��ũ��Ʈ ������ ������ ǥ����� ������ �ʴ´�.
		���� �ڹ� ���� json�� �ٷ���� ���ڿ� ����ϸ� �ȴ�.
		*/
		//�α���, �α׾ƿ�, �޼���, ������ ����, ģ�� �߰�....
		//requestType : ������ ���ϴ����� �����ϴ� ����
		//ex) requestType : "login",...
		StringBuffer sb=new StringBuffer();
		sb.append("{");
		sb.append(	"\"requestType\" : \"login\",");
		sb.append("\"id\" : \"batman\",");
		sb.append("\"pw\" : \"1234\"");
		sb.append("}");
		System.out.println(sb.toString());
		//���� ���ڿ��� ������� �׳� ���ڿ��� �������� �ؼ�(�Ľ�)�� �Ŀ��� json ��ü�� ��޵� �� �ִ�
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
