/*
File 클래스 : File을 제어할 수 있도록 제공되는 클래스
주의) 자바에서는 디렉토리도 File로 간주된다
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
