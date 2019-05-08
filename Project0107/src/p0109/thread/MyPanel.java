package p0109.thread;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class MyPanel extends JPanel{
	int RectX;
	int RectY;
	int RectWidth=100;
	int RectHeight=100;
	Rectangle r1=new Rectangle(50,150,100,100);;
	Rectangle r2=new Rectangle(RectX,RectY,RectWidth,RectHeight);;
	
		
	public void paint(Graphics g) {
		g.setColor(Color.YELLOW);	
		g.fillRect(0, 0, 800, 650);
		
		g.setColor(Color.GREEN);
		g.fillRect(r1.x, r1.y, r1.width, r1.height);
		
		g.setColor(Color.BLUE);				
		g.fillRect(r2.x, r2.y, r2.width, r2.height);
	}
}
