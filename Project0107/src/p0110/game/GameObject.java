//게임에 등장하는 모든 객체들이 공통적으로 가질 보편적인 변수 및 기능을 정의한다
package p0110.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public abstract class GameObject {
	//오브젝트의 타입
	ObjectType type; //상수만을 모아놓은 집합
	ObjectManager objectManager;
	int x;
	int y;
	int width;
	int height;
	int velX;
	int velY;
	Image img;
	Rectangle rect;
	public GameObject(ObjectType type,ObjectManager objectManager,int x,int y,int width,int height,int velX,int velY,Image img) {
		this.objectManager=objectManager;
		this.type=type;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.velX=velX;
		this.velY=velY;
		this.img=img;
		rect=new Rectangle(x, y, width, height);
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	//모든 객체는 자신이 보유한 사각형을 실시간으로 x,y,width,height 값으로 갱신시켜야 한다
	public void setRectBounds() {
		rect.setBounds(x, y, width, height);
	}
	public void showOutline(Graphics g) {
		g.setColor(Color.RED);		
		g.drawRect(x, y, width, height);
	}
}
