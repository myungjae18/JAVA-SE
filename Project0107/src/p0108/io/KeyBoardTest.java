package p0108.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class KeyBoardTest extends JFrame{
	InputStream is=System.in;
	InputStreamReader reader=new InputStreamReader(is);
	FileInputStream fis;
	JFileChooser chooser=new JFileChooser("F:/java_developer/javaSE/Project0107/res/");
	int result;
	
	public void KeyBoardTest() {
		result=chooser.showOpenDialog(this);
		int data=-1;
		try {
			while(true) {
				data=reader.read();
				char sendData=(char)data;
				System.out.println(sendData);
				sendfile();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setSize(600,600);
		setVisible(true);
	}
	public  void sendfile() {
		System.out.println(result);
		if(result==JFileChooser.APPROVE_OPTION) {
			//열기를 원할 경우, 유저가 선택할 파일을 반환 받자
			File file=chooser.getSelectedFile();
			//System.out.println(file.getAbsolutePath());
			this.setTitle(file.getAbsolutePath());
		}
	}
		
	public static void main(String[] args) {
		new KeyBoardTest();
	}
}	
	
	
	