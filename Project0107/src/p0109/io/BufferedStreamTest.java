/*스트림 메서드 자체에서 지원하는 byte 배열은 효율성은 좋으나 문자열을 처리하기엔 무리가 있다..
 * 우리 인간이 생각하는 문자열 단위의 끝은 개행처리 시점인데,
 *  byte 배열로는 그 시점을 알기 위해 처리를 별도로 해줘야하는 등의 불편함이 있다..
 *  sun사에서는 좀 더 개발자가 문자열 처리를 효율적으로,
 *  편리하게 처리하도록 지원하는 Buffer 지원 스트림을 제공해준다..
 *  명명 규칙) 클래스 명 앞에 Buffered
 *  ex) Buffered
 * */

package p0109.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedStreamTest {
	BufferedReader bufread;
	InputStreamReader reader;
	FileInputStream fis;
	
	public BufferedStreamTest() {
		try {
			fis=new FileInputStream("F:/java_developer/javaSE/Project0107/res/himemo.txt");
			reader=new InputStreamReader(fis);
			bufread=new BufferedReader(reader);
			String data=null; //한 줄을 읽으므로 String...
			int count=0;
			try {
				while(true) {
				data=bufread.readLine();
				if(data==null)break;
				count++;
				System.out.println(count);
				System.out.println(data);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bufread!=null) {
				try {
					bufread.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BufferedStreamTest();
	}
}
