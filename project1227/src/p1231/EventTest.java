//�ٸ� ���� ���������� �ڹ� �� �̺�Ʈ�� �����Ѵ�
package p1231;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class EventTest extends JFrame implements ActionListener{
	JButton bt;

	public EventTest(String title){
		super(title);
		bt=new JButton("Ŭ��");
		setLayout(new FlowLayout()); //�������� borderLayout���� FlowLayout���� ����
		add(bt);
		//bt�� ActionEvent ����(javascript�� ����)
		bt.addActionListener(this); //�޼����� �μ��� Listener�� �ڰ� �´� ->�ٷ� �� �ڽ�(this)
		setSize(300,400);
		setVisible(true);
	}

	//���� ������ �޼����̾�� �������̵尡 �����ȴ�..
	//����ڰ� ����Ų ActionEvent�� �ν��Ͻ��� �Ʒ� �޼����� �μ��� ���޵Ǵ� ���̴�..
	public void actionPerformed(ActionEvent e){
		System.out.println("Ȯ��");
	}
	public static void main(String[] args){
		new EventTest("�� ������");
	}
}
