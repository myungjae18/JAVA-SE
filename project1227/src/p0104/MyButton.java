//JButton�� �̹� �� �׷��� ������Ʈ������ �� �ǽ������� �� ��ư�� �츮�� �ֵ��Ͽ� �����߷�����
package p0104;
import javax.swing.JButton;
import java.awt.Graphics;

public class MyButton extends JButton{
	public MyButton(String title){
		super(title);
	}
	//��ư�� �׸��� ������ ���Ѿƺ��� ->�������̵�
	public void paint(Graphics g){
		System.out.println("�׸���");
	}
}
