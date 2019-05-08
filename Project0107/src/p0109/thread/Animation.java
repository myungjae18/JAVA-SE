package p0109.thread;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Animation extends JFrame{
	XCanvas can;
	JButton bt;
	Thread thread;
	
	public Animation() {
		bt=new JButton("발사");
		can=new XCanvas();
		thread=new Thread() {
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					can.x+=5;
					//repaint() -> update() -> paint()
					//간접 호출만 허용
					can.repaint();
				}
			}
		};
		
		add(bt, BorderLayout.NORTH);
		add(can);
		
		pack(); //안쪽의 내용물만큼 wrapping 시킨다
		
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				can.thread.start();				
			}
		});
				
		can.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();

				switch(key) {
					case KeyEvent.VK_RIGHT:can.velX=5;break;
					case KeyEvent.VK_LEFT:can.velX=-5;break;
					case KeyEvent.VK_UP:can.velY=-5;break;
					case KeyEvent.VK_DOWN:can.velY=5;break;
				}
			}
		});
		can.requestFocus();
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Animation();
	}

}
