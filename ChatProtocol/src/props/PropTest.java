package props;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*List, Set, Map --> ��ü�� ȿ���� �ְ� ��Ƽ� ó������
Map > Properties : ��ü�� ��Ƽ� ó���ϵ�, key-value�� ������ ó������*/
public class PropTest {
	FileInputStream fis; //������ �д� �� �����̹Ƿ�..
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
		String name=props.getProperty("name"); //key ������ ���𰡸� ��ȸ�� �� �ִ�
		System.out.println("name�� value ���� "+name);
	}
	public static void main(String[] args) {
		new PropTest();
	}
}
