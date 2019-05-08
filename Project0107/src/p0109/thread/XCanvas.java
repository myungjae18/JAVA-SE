package p0109.thread;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

//Runnable�� Thread �ڷ����� �ƴ����� Thread�� ������ run �޼��常�� ������ �ִ�(�߻� �޼���)
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
		
		//Runnable ���� ��ü�� �μ��� ������ �� ���� ��ü�� ������ run() �޼��带 JVM�� ȣ���Ѵ�
		//�� ����� �ش� Ŭ������ �̹� �������� �ڽ� Ŭ������ ��� ���� ����Ѵ�
		thread=new Thread(this);
		thread.start();
	}
	
	//paint �޼��� ������ - �����ڰ� ���ϴ� �׷��� ó���� ���ؼ�
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
