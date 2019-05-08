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
		setRectBounds(); //나의 x,y,width,height 값의 변경사항을 내가 보유한 rect에 반영한다
		//날아가면서 충돌검사를 하자 총알 : 적군 = 1 : 多
		for (int i = 0; i < objectManager.objectList.size(); i++) {
			GameObject obj=objectManager.objectList.get(i);
			if(obj.type==ObjectType.Enemy) {
				//나의 rect와 적군의 rect의 intersects()
				boolean hit=this.rect.intersects(obj.rect);
				System.out.println(this.rect.x);
				if(hit==true) {
					System.out.println("엌");
					objectManager.removeObject(obj);
					objectManager.removeObject(this);
				}
			}
		}
		
	}

}
