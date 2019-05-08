package p0109.thread;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class BarTest extends JFrame{
	Thread thread1;
	Thread thread2;
	Thread thread3;
	JProgressBar bar1;
	JProgressBar bar2;
	JProgressBar bar3;
	JButton bt;
	int n=0;
	int m=0;
	int o=0;
	
	public BarTest() {
		// TODO Auto-generated constructor stub
		thread1=new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					up1();
				}
			}
		};
		thread2=new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					up2();
				}
			}
		};
		thread3=new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					up3();
				}
			}
		};
		bar1=new JProgressBar();
		bar2=new JProgressBar();
		bar3=new JProgressBar();
		bt=new JButton("DOWNLOAD");
		
		bar1.setPreferredSize(new Dimension(500,80));
		bar2.setPreferredSize(new Dimension(500,80));
		bar3.setPreferredSize(new Dimension(500,80));
		setLayout(new FlowLayout());
		
		add(bar1);
		add(bar2);
		add(bar3);
		add(bt);
		
		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				thread1.start();
				thread2.start();
				thread3.start();
			}
		});
		
		setSize(600,400);
		setVisible(true);		
	}
	public void up1() {
		n++;
		bar1.setValue(n);
		bar1.setStringPainted(true);
		bar1.setForeground(Color.GRAY);
		bar1.setFont(new Font("Arial Black",Font.BOLD,35));
		bar1.setString(n+"%");
	}
	public void up2() {
		m+=10;
		bar2.setValue(m);
		bar2.setStringPainted(true);
		bar2.setForeground(Color.BLUE);
		bar2.setFont(new Font("Arial Black",Font.BOLD,35));
		bar2.setString(m+"%");
	}
	public void up3() {
		o+=20;
		bar3.setValue(o);
		bar3.setStringPainted(true);
		bar3.setForeground(Color.YELLOW);
		bar3.setFont(new Font("Arial Black",Font.BOLD,35));
		bar3.setString(o+"%");
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BarTest();
	}

}
