/*
Stream : ���ǿ����� ��Ʈ���� ���ٱ�, ���� �� ���� �帧�� �ǹ�������, ��ǻ�� �о߿����� �帧�� ����� �������̴�..
�� �� ���� ���� ���α׷����� �귯 ���� ����� Input�̶� �ϰ�,
�귯 ������ ����� ������ Output�̶� �Ѵ�..(����� IO)
-------------------------------------------------------
6kbyte=1024*6
-------------------------------------------------------
<����(Exception)>
���� : ���α׷��� ���� ������ �Ұ����ϰ� ����� ����
������ ����
1) Error (����) - ���α׷��Ӱ� ������ �� �ִ� ���� ���� ����
2) Exception (����) - ���α׷��Ӱ� ������ �� �ִ� ������ ����
		Catched Exception : ������ Ÿ�ӿ� '����'�Ǵ� ����
		Runtime Exception : ��Ÿ�ӽ� �߻��ϴ� ����
*/
//p0104_res�� ����ִ� 1.jpg�� copy ���丮�� ����
package p0107;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;

public class FileCopy{
	String origin="F:/java_developer/javaSE/project1227/src/res/p0104_res/1.jpg";
	String dest="F:/java_developer/javaSE/project1227/src/copy/sea.jpg";
	FileInputStream fis; //������ ������� �� �Է� ��Ʈ��
	FileOutputStream fos; //������ ������� �� ��� ��Ʈ��
	public FileCopy(){
		//��Ʈ���� �����ϴ� ���� ���Ͽ� ���� ����
		
		/*Runtime Exception�� ó���� ���������� ������, �����ڰ� ���� ó���� �� ��� ���α׷��� ������ ������ ���ɼ��� ��������
		int[]arr=new int[3];
		arr[0]=5;
		arr[1]=7;
		arr[2]=3;
		arr[3]=9;
		*/
		//�� ������ ���� ������ �߻��� ���ɼ��� �����Ƿ� ���� ��ġ�� �ؾ� �Ѵ�..
		try{
			fis=new FileInputStream(origin);
			fos=new FileOutputStream(dest);
			System.out.println("���� ��Ʈ���� �����Ǿ����ϴ�.....");
			//������ ��Ʈ������ ������ �Է��� ��������
			int data;
			while(true){
				data=fis.read(); //1byte �о����
				if(data==-1)break; //break : while�� ���������� ���
				System.out.print((char)data);
				//�������
				fos.write(data); //data ���
			}
		}catch(FileNotFoundException f){
			f.printStackTrace(); //���� ������ stack ������ �����Ͽ� ���
			System.out.println("������ ã�� �� �����ϴ�......");
			/*
			try������ Ȥ���� ������ �߻��ϸ� ���α׷��� ���������ᰡ �Ǿ�����Ƿ�,
			�� ��Ȳ�� ���� ���� catch���� �غ��صθ� ����ΰ� ������ ����Ǵ� ���� �ƴ϶�, catch������ �����Ѵ�
			���� ���ܰ� �߻��ϴ��� �� ������ ������ ó���� �� �� �ִ�. �� ���� �ٷ� ����ó���� �����̴�
			*/
		}catch(IOException e){
			System.out.println("����� �� ������ �߻��߽��ϴ�.....");
		}finally{
			//finally�� ����ϸ� try���� catch���� �� ������ ���İ���
			//->�ַ� ��Ʈ��, db�� ��� �� ���� �� ����Ѵ�
			try{
				fis.close();
			}catch(IOException e){
				System.out.println("��Ʈ�� ���� �� ������ �߻��߽��ϴ�...");
			}
		}
	}
	public static void main(String[] args){
		new FileCopy();
	}
}
