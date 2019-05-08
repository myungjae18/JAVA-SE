package p0110.game;

import java.awt.Graphics;
import java.awt.Image;

public class Player extends GameObject{
	public Player(ObjectType type,ObjectManager objectManager,int x,int y,int width,int height,int velX,int velY,Image img) {
		super(type,objectManager,x,y,width,height,velX,velY,img);
		//�簢���� �����Ѵ�
	}
	@Override//jdk 1.5���� �����ϱ� ������..
	//���� : �ּ��� ����ϳ� �Ϲ����� �ּ��� ���α׷� ���࿡ ������ �ʰ� ���õ�����,
	//�̳����̼� �ּ��� ���α׷� ���� �� ���ȴ�
	public void tick() {
		// TODO Auto-generated method stub
		x+=velX;
		y+=velY;
		setRectBounds();
	}
	
	//�Ʒ� �޼��忡���� g�� �г��� g��.. ���� �÷��̾ �гο� �׷�����.....
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(img, x, y, width, height, null);
		showOutline(g);
	}

}
