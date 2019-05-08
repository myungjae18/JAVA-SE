/*개발자는 그 대상이 파일이건 키보드건, 특정 하드웨어건 상관없이 Stream만 얻을 수 있다면
 코드 큰 변화없이 데이터를 실행 중인 자바 프로그램으로 가져올 수 있다*/
package p0108.io;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetCSS {
	public static void main(String[] args) {
		try {
			URL url=new URL("https://pm.pstatic.net/css/main_v181114.css");
			System.out.println("url 생성!");
			HttpURLConnection http=(HttpURLConnection)url.openConnection();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("url 생성!");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
