/*�����ڴ� �� ����� �����̰� Ű�����, Ư�� �ϵ����� ������� Stream�� ���� �� �ִٸ�
 �ڵ� ū ��ȭ���� �����͸� ���� ���� �ڹ� ���α׷����� ������ �� �ִ�*/
package p0108.io;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetCSS {
	public static void main(String[] args) {
		try {
			URL url=new URL("https://pm.pstatic.net/css/main_v181114.css");
			System.out.println("url ����!");
			HttpURLConnection http=(HttpURLConnection)url.openConnection();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("url ����!");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
