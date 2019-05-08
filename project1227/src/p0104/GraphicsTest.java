/*
�׷��� ó���� ���õ� �ֺ�����
���ǿ����� �׸��� �׸��� ���� ���
1) ��ü(ȭ��) --> ������Ʈ
2) ���(ĵ����) --> ������Ʈ
3) �׸��� ����(��) -->�׸��� �����̱⿡ ������Ʈ�� paint() �޼���
4) �ٸ��ִ� ����(�ȷ�Ʈ) paint(Graphics g)
*/
package p0104;
import javax.swing.*;
import java.awt.*;

//��ư�� ������ �׸��� �׸��ٴµ� �� ������ �����غ���
//sun�翡�� �����ϴ� GUI ������Ʈ�� �����ڰ� �մ�� ���� ���� �ٶ����Ѱ�? NO
/*������Ʈ �߿� �����ڰ� �մ� ���� �ְ� �մ��� ���ƾ� �� ���� �ִ�..
������Ʈ �߿� �ƹ��� �׸��� �׷��� ���� �ʰ� �����ڿ��� �׸� �׸� ��ȸ�� �ִ� ������Ʈ�� �����Ǵµ� �� ������Ʈ�� Canvas�� �Ѵ�*/
class GraphicsTest extends JFrame{
	MyButton bt;
	Canvas can; //��ȭ��

	public GraphicsTest(){
		bt=new MyButton("�� ��ư");
		can=new Canvas(){
			//�����ڰ� �ֵ��Ͽ� �׸��� �׸�
			public void paint(Graphics g){
				g.drawRect(50,50,100,100);
			}
		};
		can.setBackground(Color.RED);
		can.setPreferredSize(new Dimension(300,400));
		setLayout(new FlowLayout());
		
		add(bt);
		add(can);

		setSize(300,400);
		setVisible(true);

	}
	public static void main(String[] args){
		new GraphicsTest();
	}
}
