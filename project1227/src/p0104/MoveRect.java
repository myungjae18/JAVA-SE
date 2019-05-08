package p0104;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Canvas;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/*
이미지를 포함하여 그래픽 처리하는 것은 보는 사용자 입장에서는 편할 수 있으나,
개발자 입장에서는 상당히 많은 처리를 해야 하는 복잡한 프로그래밍이다..
이 복잡함에 대한 부담을 언어 벤더사가 상당 부분 해결해준다.
GUI 프로그래밍의 복잡한 부분을 쉽게 해결해 주는 역할을 하는 도구를 Toolkit이라고 한다..
java에서는 이미지를 처리하기 위해 지원되는 도구가 Toolkit 클래스로 지원한다
*/
/*
난생 처음 보는 클래스에 대한 대처법
1)클래스의 목적을 확인
2)메모리에 올리는 법을 확인
	일반클래스 - new
	추상클래스 - 자식을 new 
	(예외적으로 이미 언어 차원에서 인스턴스를 제공하는 경우가 상당히 많다)
	인터페이스 - 자식을 new
*/

class MoveRect extends JFrame{
	JButton bt_left, bt_right, bt_up, bt_down;
	JPanel p_north;
	Canvas can;
	Toolkit kit=Toolkit.getDefaultToolkit(); //추상 클래스(new 불가능)
	//->따라서 이 인스턴스를 얻기 위해서는 new 하지 않고도 접근할 수 있는 메서드인 static으로 선언된 getDefaultToolkit()을 호출해야 한다
	Image img;
	int x=0; //이미지의 x좌표
	int y=0; //이미지의 y좌표

	public MoveRect(){
		bt_left=new JButton("좌");
		bt_right=new JButton("우");
		bt_up=new JButton("상");
		bt_down=new JButton("하");
		p_north=new JPanel();
		//.java 파일로 정의할지, 내부 익명 클래스로 정의할지는 재사용성을 고려하여 판단
		//역슬래시(\)는 윈도우OS에서만 사용되는 특수문자이기 때문에 자바의 중립성을 고려했을 때 역슬래시를 사용하면 안된다
		img=kit.getImage("F:/java_developer/javaSE/project1227/src/res/block.png");
		can=new Canvas(){
			public void paint(Graphics g){
				g.drawImage(img,x,y,100,100,can);
				//System.out.println("paint() called");
				/*실험을 통해 알 수 있는 것
				paint 메서드는 개발자가 호출하는 것이 아니라 최초에 그림이 그려질 때 및, 기존 그림에 조금이라도 변화가 있을때만 호출된다*/
				//어떤 변화가 없더라도 호출하는 방법 : repaint() -> update() -> paint()
			}
		};
		can.setPreferredSize(new Dimension(600,400));
		can.setBackground(Color.YELLOW);

		p_north.add(bt_left);
		p_north.add(bt_right);
		p_north.add(bt_up);
		p_north.add(bt_down);

		add(p_north, BorderLayout.NORTH);
		add(can);

		bt_right.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//이미지를 우측으로 이동
				x+=50;
				//다시 그리기
				can.repaint();
			}	
		});
		bt_left.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				x-=50;
				//다시 그리기
				can.repaint();
			}	
		});
		bt_up.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				y-=50;
				//다시 그리기
				can.repaint();
			}	
		});
		bt_down.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				y+=50;
				//다시 그리기
				can.repaint();
			}	
		});

		can.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent k){
				int obj=k.getKeyCode();
				System.out.println(obj);
				/*
				if(obj==KeyEvent.VK_LEFT){
					x-=50;
					can.repaint();
				}
				if(obj==KeyEvent.VK_RIGHT){
					x+=50;
					can.repaint();
				}
				if(obj==KeyEvent.VK_UP){
					y-=50;
					can.repaint();
				}
				if(obj==KeyEvent.VK_DOWN){
					y+=50;
					can.repaint();
				}
				*/
				switch(obj){
					case KeyEvent.VK_LEFT:x-=50;break;
					case KeyEvent.VK_RIGHT:x+=50;break;
					case KeyEvent.VK_UP:y-=50;break;
					case KeyEvent.VK_DOWN:y+=50;break;
				}
				can.repaint();
			}
		});

		setSize(600,450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		new MoveRect();	
	}
}
