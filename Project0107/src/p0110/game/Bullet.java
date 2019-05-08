package p0110.game;

import java.awt.Graphics;
import java.awt.Image;

public class Bullet extends GameObject{
	public Bullet(ObjectType type,ObjectManager objectManager,int x,int y,int width,int height,int velX,int velY,Image img) {
		super(type,objectManager,x,y,width,height,velX,velY,img);
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(img, x, y, width, height, null);
		showOutline(g);
				
	}
	@Override
	public void tick() {
		x+=velX;
		setRectBounds(); //���� x,y,width,height ���� ��������� ���� ������ rect�� �ݿ��Ѵ�
		//���ư��鼭 �浹�˻縦 ���� �Ѿ� : ���� = 1 : ��
		for (int i = 0; i < objectManager.objectList.size(); i++) {
			GameObject obj=objectManager.objectList.get(i);
			if(obj.type==ObjectType.Enemy) {
				//���� rect�� ������ rect�� intersects()
				boolean hit=this.rect.intersects(obj.rect);
				System.out.println(this.rect.x);
				if(hit==true) {
					System.out.println("��");
					objectManager.removeObject(obj);
					objectManager.removeObject(this);
				}
			}
		}
		
	}

}
