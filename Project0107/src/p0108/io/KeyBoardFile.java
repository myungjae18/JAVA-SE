package p0108.io;

import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KeyBoardFile {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriter writer=null;
		InputStream is=System.in;
		InputStreamReader reader=new InputStreamReader(is);
		try {
			writer=new FileWriter("F:/java_developer/javaSE/Project0107/res/memo3.txt");
			int data=-1;
			while(true) {
				data=reader.read();
				if(data==KeyEvent.VK_0) {
					if(writer!=null) {
						writer.close();
					}
					System.out.print("bye");
					System.exit(0);
				}else {
					System.out.print((char)data);
					writer.write((char)data);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
