package json.parse;

public class JSONParseApp {
	public JSONParseApp() {
		StringBuffer sb=new StringBuffer();

		sb.append("{");
		sb.append("\"members\" : [");
		int length=5;
		for(int i = 0; i < length; i++) {
			sb.append("{");
			sb.append("\"empno\" : 23,");
			sb.append("\"ename\" : \"scott\",");
			sb.append("\"sal\" : 4000");
			if(i<(length-1)) {
				sb.append("},");
			}else {
				sb.append("}");
			}
			sb.append("]");
			sb.append("}");
		};
		System.out.println(sb.toString());
	}
	public static void main(String[] args) {
		new JSONParseApp();
	}
}
