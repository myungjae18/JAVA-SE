/*
 * �޸��� �ȿ� ������ �ְ� �׽�Ʈ�غ���
 * ���� ���� �ڹ� ���α׷����� �޸����� �����͸� �о�鿩 ����=�Է�(input)
 -------------------------------------------------------------------------
*��Ʈ���� ����
 * 1)byte ��� ��Ʈ��
 * 2)���� ��� ��Ʈ�� ( ��Ʈ������ �о���� �����͸� ���ڷ� ������ �� �ִ� �ɷ��� ����)
*/
package p0108.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IOTest {
	FileReader fis; //������ ������� �� �Է�
	public IOTest() {
		try {
			fis=new FileReader("F:/java_developer/javaSE/Project0107/res/memo.txt");
			System.out.println("��Ʈ�� ����");
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
