package p0110.game;

import java.awt.Graphics;
import java.awt.Image;

public class Enemy extends GameObject{
	public Enemy(ObjectType type,ObjectManager objectManager,int x,int y,int width,int height,int velX,int velY,Image img) {
		// TODO Auto-generated constructor stub
		super(type,objectManager,x,y,width,height,velX,velY,img);
	}
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(img, x, y, width, height, null);
		showOutline(g);
	}
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x=x+velX;
		setRectBounds();
	}
}
