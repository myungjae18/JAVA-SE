package props;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*List, Set, Map --> 객체를 효율성 있게 모아서 처리하자
Map > Properties : 객체를 모아서 처리하되, key-value의 쌍으로 처리하자*/
public class PropTest {
	FileInputStream fis; //파일을 읽는 게 먼저이므로..
	Properties props;
	
	public PropTest(){
		try {
			fis=new FileInputStream("D:/Java_developer/javaSE/ChatProtocol/data/babo.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		props=new Properties();
		
		try {
			props.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String name=props.getProperty("name"); //key 값으로 무언가를 조회할 수 있다
		System.out.println("name의 value 값은 "+name);
	}
	public static void main(String[] args) {
		new PropTest();
	}
}
