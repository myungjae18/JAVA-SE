package p0103;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class WindowPainter extends JFrame{
	MyPanel myPanel; //내가 정의한 클래스
	public WindowPainter(){
		setLayout(new FlowLayout());
		for(int i=0;i<5000;i++){
			myPanel=new MyPanel();
			add(myPanel);
		}

		setSize(700,550);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		new WindowPainter();
	}
}
