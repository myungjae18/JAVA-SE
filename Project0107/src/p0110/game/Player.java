package p0110.game;

import java.awt.Graphics;
import java.awt.Image;

public class Player extends GameObject{
	public Player(ObjectType type,ObjectManager objectManager,int x,int y,int width,int height,int velX,int velY,Image img) {
		super(type,objectManager,x,y,width,height,velX,velY,img);
		//사각형을 생성한다
	}
	@Override//jdk 1.5부터 지원하기 시작함..
	//역할 : 주석과 비슷하나 일반적인 주석은 프로그램 실행에 사용되지 않고 무시되지만,
	//이노테이션 주석은 프로그램 실행 시 사용된다
	public void tick() {
		// TODO Auto-generated method stub
		x+=velX;
		y+=velY;
		setRectBounds();
	}
	
	//아래 메서드에서의 g는 패널의 g다.. 따라서 플레이어가 패널에 그려진다.....
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(img, x, y, width, height, null);
		showOutline(g);
	}

}
