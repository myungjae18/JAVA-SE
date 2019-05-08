package p0109.thread;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

//Runnable은 Thread 자료형은 아니지만 Thread가 보유한 run 메서드만을 가지고 있다(추상 메서드)
public class XCanvas extends JPanel implements Runnable{
	Thread thread;
	
	public static final int WIDTH=800;
	public static final int HEIGHT=600;
	Toolkit kit=Toolkit.getDefaultToolkit();
	Image img;
	int x=50;
	int y=100;
	int width=100;
	int height=90;
	int velX=0;
	int velY=0;
	
	public XCanvas() {
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		img=kit.getImage("F:/java_developer/javaSE/Project0107/res/GarenDance.gif");
		
		//Runnable 구현 객체를 인수로 넣으면 그 구현 객체가 보유한 run() 메서드를 JVM이 호출한다
		//이 방법은 해당 클래스가 이미 누군가의 자식 클래스일 경우 자주 사용한다
		thread=new Thread(this);
		thread.start();
	}
	
	//paint 메서드 재정의 - 개발자가 원하는 그래픽 처리를 위해서
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.drawImage(img, x, y, width, height, this);
	}

	@Override
	public void run() {
		while(true) {
			x+=velX;
			y+=velY;
			//repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
