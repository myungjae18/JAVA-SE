package p0109.thread;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ProgressApp extends JFrame{
	MyProgressBar bar1, bar2, bar3;
	JButton bt;
	
	public ProgressApp() {
		bar1=new MyProgressBar(2);
		bar2=new MyProgressBar(10);
		bar3=new MyProgressBar(5);
		bt=new JButton("Ω√¿€");
		
		setLayout(new FlowLayout());
		
		add(bar1);
		add(bar2);
		add(bar3);
		add(bt);
		
		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bar1.thread.start();
				bar2.thread.start();
				bar3.thread.start();
				
			}
		});
		
		setSize(500,250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ProgressApp();
	}

}
