package p0109.thread;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JProgressBar;

public class MyProgressBar extends JProgressBar{
	Thread thread;
	int n;
	int velN; //결정되어 있으면 안됨
	
	public MyProgressBar(int velN) {
		this.velN=velN;
		
		thread=new Thread() {
			@Override
			public void run() {
				while(true) {
					n=n+velN;
					setValue(n);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
			}
		};
		setPreferredSize(new Dimension(470,45));
		setStringPainted(true);
		setForeground(Color.BLUE);
		setFont(new Font("Arial Black",Font.BOLD,35));
	}
}
