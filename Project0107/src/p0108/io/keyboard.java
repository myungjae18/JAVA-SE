package p0108.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/*���� ���� �ڹ� ���α׷����� Ű������ ���� �Է¹޾� ����Ϳ� ����غ���
->������� ����� �ϵ����� ����
-----------------------------------------------------------------------
File�� ��� ��Ʈ���� ���� ���θ� �����ڰ� ������ �� �־�����, Ű���峪 ����� ���� ǥ���Էµ�������
�츮�� OS�������� �̹� ��Ʈ���� �����Ͽ� �����ڰ� ���� ������ �� ����*/
public class keyboard {
	
	public static void main(String[] args) {
		InputStream is=System.in;
		//�ѱ��� ������ �������� ��Ʈ���� ���� ��� �̻����� ����ؾ� �Ѵ�
		InputStreamReader reader=new InputStreamReader(is);
		//Reader�� �ܵ����� ������ �� ����, byte ����� ��Ʈ���� ���ʷ� �����ȴ�
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
