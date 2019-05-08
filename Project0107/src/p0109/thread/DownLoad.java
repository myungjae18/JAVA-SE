/*진행률을 시각적으로 표현해주는 컴포넌트인 JProGressbar를 사용해본다*/
package p0109.thread;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class DownLoad extends JFrame{
	JProgressBar bar;
	JButton bt;
	Thread thread;
	int n=0;
	
	public DownLoad() {
		bar=new JProgressBar();
		bt=new JButton("DOWNLOAD");
		thread=new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					up();
				}
			}
		};
		
		setLayout(new FlowLayout());
		bar.setPreferredSize(new Dimension(470,45));
		
		add(bt);
		add(bar);
		
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				thread.start();
			}
		});
		
		setSize(500,150);
		setVisible(true);
	}
	public void up() {
		//바의 진행률을 표현하는 색상을 채워넣자
		n++;
		bar.setValue(n);
	}
	
	public static void main(String[] args) {
		new DownLoad();
	}

}
