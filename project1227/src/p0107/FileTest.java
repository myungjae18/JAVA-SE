/*
File Ŭ���� : File�� ������ �� �ֵ��� �����Ǵ� Ŭ����
����) �ڹٿ����� ���丮�� File�� ���ֵȴ�
*/
package p0107;
import java.io.File;
import java.io.IOException;

class FileTest{
	public static void main(String[] args){
		String path="F:/java_developer/javaSE/project1227/src/copy/test.gif";

		File file=new File(path);
		try{
			file.createNewFile();
			String ph=file.getAbsolutePath();
			System.out.println(ph);
		}catch(IOException e){}
		
	}
}
