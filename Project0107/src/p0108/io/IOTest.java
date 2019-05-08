/*
 * 메모장 안에 영문을 넣고 테스트해본다
 * 실행 중인 자바 프로그램으로 메모장의 데이터를 읽어들여 보자=입력(input)
 -------------------------------------------------------------------------
*스트림의 종류
 * 1)byte 기반 스트림
 * 2)문자 기반 스트림 ( 스트림으로 읽어들인 데이터를 문자로 이해할 수 있는 능력이 있음)
*/
package p0108.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IOTest {
	FileReader fis; //파일을 대상으로 한 입력
	public IOTest() {
		try {
			fis=new FileReader("F:/java_developer/javaSE/Project0107/res/memo.txt");
			System.out.println("스트림 생성");
			int data=-1;
			int count=0;
			while(true) {
			data=fis.read();
			if(data==1)break;
			System.out.print(count++);
			System.out.print((char)data);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
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
		}
		

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new IOTest();
	}
}
