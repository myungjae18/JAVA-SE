package p0110.game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	public static final int WIDTH=1200;
	public static final int HEIGHT=368;
	Image img;
	ImageLoader imageLoader;
	ObjectManager objectManager;
	Player player;
	
	public GamePanel() {
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		imageLoader=new ImageLoader();
		img=imageLoader.getImage("background.jpg");
		objectManager=new ObjectManager();
		createHero();
		createEnemy();
		
		//키보드와 리스너 연결
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//System.out.println("눌럿네");
				int key=e.getKeyCode();
				switch(key) {
					case KeyEvent.VK_LEFT : player.velX=-5;break;
					case KeyEvent.VK_RIGHT : player.velX=5;break;
					case KeyEvent.VK_UP : player.velY=-5;break;
					case KeyEvent.VK_DOWN : player.velY=5;break;
					case KeyEvent.VK_SPACE : fire();break;
				}
				repaint();
			}
			public void keyReleased(KeyEvent e) {
				//System.out.println("눌럿네");
				int key=e.getKeyCode();
				switch(key) {
					case KeyEvent.VK_LEFT : player.velX=0;break;
					case KeyEvent.VK_RIGHT : player.velX=0;break;
					case KeyEvent.VK_UP : player.velY=0;break;
					case KeyEvent.VK_DOWN : player.velY=0;break;
				}
				repaint();
			}
		});
	}
	
	//주인공 생성
	public void createHero() {
		Image img=imageLoader.getImage("teemo ult.gif");
		player=new Player(ObjectType.Player,objectManager,50,100,100,65,0,0,img);
		objectManager.addObject(player);
	}
	
	//총알 생성
	public void fire() {
		Image img=imageLoader.getImage("bullet.jpg");
		Bullet bullet=new Bullet(ObjectType.Bullet,objectManager,player.x+player.width,player.y+(player.height/2),30,10,10,0,img);
		objectManager.addObject(bullet);
	}
	
	//적군 생성
	public void createEnemy() {
		String[] filename= {"GarenDance.gif", "jhin_w.jpg", "jhin_e.jpg"};
		for (int i = 0; i < filename.length; i++) {
			Image img=imageLoader.getImage(filename[i]);
			Enemy enemy=new Enemy(ObjectType.Enemy,objectManager,WIDTH, i*100, 85, 85, -2, 0, img);
			objectManager.addObject(enemy);
		}
	}
	
	//모든 객체를 대상으로 tick(), render()를 해주자
	public void tick() {
		for (int i = 0; i < objectManager.objectList.size(); i++) {
			GameObject obj=objectManager.objectList.get(i);
			obj.tick();
		}
	}
	
	public void paint(Graphics g) {
		g.drawImage(img,0, 0, this);
		for (int i = 0; i < objectManager.objectList.size(); i++) {
			GameObject obj=objectManager.objectList.get(i);
			obj.render(g);
		}
	}
	
}
