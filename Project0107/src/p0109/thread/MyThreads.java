package p0109.thread;

import java.awt.Color;
import java.awt.Font;

public class MyThreads extends Thread{
	@Override
	public void run() {
		int n=0;
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			style();
		}
		style() {
			n++;
			bar1.setValue(n);
			bar1.setStringPainted(true);
			bar1.setForeground(Color.GRAY);
			bar1.setFont(new Font("Arial Black",Font.BOLD,35));
			bar1.setString(n+"%");
		}
	}
	

}
