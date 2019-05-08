/*��Ʈ�� �޼��� ��ü���� �����ϴ� byte �迭�� ȿ������ ������ ���ڿ��� ó���ϱ⿣ ������ �ִ�..
 * �츮 �ΰ��� �����ϴ� ���ڿ� ������ ���� ����ó�� �����ε�,
 *  byte �迭�δ� �� ������ �˱� ���� ó���� ������ ������ϴ� ���� �������� �ִ�..
 *  sun�翡���� �� �� �����ڰ� ���ڿ� ó���� ȿ��������,
 *  ���ϰ� ó���ϵ��� �����ϴ� Buffer ���� ��Ʈ���� �������ش�..
 *  ��� ��Ģ) Ŭ���� �� �տ� Buffered
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
			String data=null; //�� ���� �����Ƿ� String...
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
