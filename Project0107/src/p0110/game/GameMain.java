package p0110.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GameMain extends JFrame implements ActionListener{
	String TAG=this.getClass().getName();
	JMenuBar bar;
	JMenu menu;
	JMenuItem item1, item2, item3;
	GamePanel gamePanel;
	Thread thread;
	boolean flag=true; //게임의 정지 및 실행 여부를 결정하는 변수
	
	public GameMain() {
		bar=new JMenuBar();
		menu=new JMenu("게임옵션");
		item1=new JMenuItem("Start");
		item2=new JMenuItem("Pause");
		item3=new JMenuItem("Exit");
		gamePanel=new GamePanel();
		thread=new Thread() {
			public void run() {
				while(true) {
					if(flag) {
						//	System.out.println(TAG+" 이지롱~");
						gamePanel.tick();
						gamePanel.repaint();
						
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}	
				}
			};
		};
		
		bar.add(menu);
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		setJMenuBar(bar);
				
		add(gamePanel);
		
		//메뉴와 리스너 연결
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		
		pack();
		
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		thread.start();
		gamePanel.requestFocus();
	}
	public static void main(String[] args) {
		new GameMain();
	}
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj==item1) {
			flag=true;
		}else if(obj==item2) {
			flag=false;
		}else if(obj==item3) {
			System.exit(0);
		}
		
		
	}
}
