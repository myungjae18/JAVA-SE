package p0108.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/*실행 중인 자바 프로그램으로 키보드의 값을 입력받아 모니터에 출력해보자
->입출력의 대상이 하드웨어로 변경
-----------------------------------------------------------------------
File의 경우 스트림의 생성 여부를 개발자가 결정할 수 있었지만, 키보드나 모니터 같은 표준입력도구들은
우리의 OS차원에서 이미 스트림이 존재하여 개발자가 따로 생성할 수 없다*/
public class keyboard {
	
	public static void main(String[] args) {
		InputStream is=System.in;
		//한글이 깨지지 않으려면 스트림을 문자 기반 이상으로 사용해야 한다
		InputStreamReader reader=new InputStreamReader(is);
		//Reader는 단독으로 존재할 수 없고, byte 기반의 스트림을 기초로 생성된다
		int data=-1;
		try {
			while(true) {
				data=reader.read();
				System.out.print((char)data);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
