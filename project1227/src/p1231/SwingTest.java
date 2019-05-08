/*
awt�� �ڹ��� GUI�� ����ϴ� ��Ű���ν� ���� ����� �����Ѵ�..
������ awt�� �� os���� �������� �ٸ��� ǥ���ȴ�(Look&Feel)..
���� �� ������ ������ ��Ű���� ����ϸ� �Ǵµ� �� ��Ű���� ����(swing)�̶� �Ѵ�..
swing�� awt�� ������Ʈ�� �տ� 'J'�� ���ξ�� ����.
ex) Button -> JButton (javax.swing..)
����)awt�� ������ �� ���̴°� �ƴ϶�, ��ġ�����ڿ� �̺�Ʈ ���� ������ awt���� �����Ѵ�
*/
package p1231;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;

class SwingTest extends JFrame{
	JButton bt; 
	public SwingTest(){
		bt=new JButton("����ư");
		//frame�� ������ ����Ʈ ��ġ�����ڴ� BorderLayout�̴�
		setLayout(new FlowLayout());
		add(bt);

		setVisible(true);
		setSize(300,400);
	}
	public static void main(String[] args){
		new SwingTest();
	}
}
