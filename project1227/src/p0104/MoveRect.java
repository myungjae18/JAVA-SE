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
�̹����� �����Ͽ� �׷��� ó���ϴ� ���� ���� ����� ���忡���� ���� �� ������,
������ ���忡���� ����� ���� ó���� �ؾ� �ϴ� ������ ���α׷����̴�..
�� �����Կ� ���� �δ��� ��� �����簡 ��� �κ� �ذ����ش�.
GUI ���α׷����� ������ �κ��� ���� �ذ��� �ִ� ������ �ϴ� ������ Toolkit�̶�� �Ѵ�..
java������ �̹����� ó���ϱ� ���� �����Ǵ� ������ Toolkit Ŭ������ �����Ѵ�
*/
/*
���� ó�� ���� Ŭ������ ���� ��ó��
1)Ŭ������ ������ Ȯ��
2)�޸𸮿� �ø��� ���� Ȯ��
	�Ϲ�Ŭ���� - new
	�߻�Ŭ���� - �ڽ��� new 
	(���������� �̹� ��� �������� �ν��Ͻ��� �����ϴ� ��찡 ����� ����)
	�������̽� - �ڽ��� new
*/

class MoveRect extends JFrame{
	JButton bt_left, bt_right, bt_up, bt_down;
	JPanel p_north;
	Canvas can;
	Toolkit kit=Toolkit.getDefaultToolkit(); //�߻� Ŭ����(new �Ұ���)
	//->���� �� �ν��Ͻ��� ��� ���ؼ��� new ���� �ʰ� ������ �� �ִ� �޼����� static���� ����� getDefaultToolkit()�� ȣ���ؾ� �Ѵ�
	Image img;
	int x=0; //�̹����� x��ǥ
	int y=0; //�̹����� y��ǥ

	public MoveRect(){
		bt_left=new JButton("��");
		bt_right=new JButton("��");
		bt_up=new JButton("��");
		bt_down=new JButton("��");
		p_north=new JPanel();
		//.java ���Ϸ� ��������, ���� �͸� Ŭ������ ���������� ���뼺�� ����Ͽ� �Ǵ�
		//��������(\)�� ������OS������ ���Ǵ� Ư�������̱� ������ �ڹ��� �߸����� ������� �� �������ø� ����ϸ� �ȵȴ�
		img=kit.getImage("F:/java_developer/javaSE/project1227/src/res/block.png");
		can=new Canvas(){
			public void paint(Graphics g){
				g.drawImage(img,x,y,100,100,can);
				//System.out.println("paint() called");
				/*������ ���� �� �� �ִ� ��
				paint �޼���� �����ڰ� ȣ���ϴ� ���� �ƴ϶� ���ʿ� �׸��� �׷��� �� ��, ���� �׸��� �����̶� ��ȭ�� �������� ȣ��ȴ�*/
				//� ��ȭ�� ������ ȣ���ϴ� ��� : repaint() -> update() -> paint()
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
				//�̹����� �������� �̵�
				x+=50;
				//�ٽ� �׸���
				can.repaint();
			}	
		});
		bt_left.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				x-=50;
				//�ٽ� �׸���
				can.repaint();
			}	
		});
		bt_up.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				y-=50;
				//�ٽ� �׸���
				can.repaint();
			}	
		});
		bt_down.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				y+=50;
				//�ٽ� �׸���
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
