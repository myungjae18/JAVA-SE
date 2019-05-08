/*java ���� ��ü �� Rectangle Ŭ���������� intersect()��� �޼��带 �����ϸ�,
 * �� �޼���� �ٸ� �簢������ ���� ���θ� �Ǵ��Ѵ�*/
package p0109.thread;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class CollisionCheck extends JFrame{
	MyPanel p;
	
	public CollisionCheck() {
		p=new MyPanel();
		
		p.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				p.RectX=e.getX();
				p.RectY=e.getY();
				//System.out.println(p.RectX);
				setRectBounds();
				p.repaint();
			}
		});
		
		p.requestFocus();
		p.setFocusable(true);
		
		add(p);
			
		setSize(800,650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void setRectBounds() {
		boolean hit=p.r2.intersects(p.r1);
		if(hit==true) {
			System.out.println("��");
		}	
		p.r2.setBounds(p.RectX, p.RectY, p.RectWidth, p.RectHeight);
	}
		
	public static void main(String[] args) {
		new CollisionCheck();
	}

}
