package lambda;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
Lambda : �˷��� óġ��� �����ڿ� ���� ��ȵ� ��� ǥ�����̾�����, �� ���ڰ� ���α׷��� ���� �����ߴ�
Lambda�� �͸��Լ��� �����ϴ� ǥ���Ŀ� ���
--------------------------------------------------------------------------------------------------------
�ڹٽ�ũ��Ʈ�� ���� ��Ÿ ���鿡���� �Լ� ���� ǥ������� ���ٸ� ���������,
�ڹٴ� ��ü���� ����̱� ������ �� Lambda ǥ�������� �ٷ� �͸� ��ü�� ������ �� ���ȴ�..
	-�ڹٰ� ��� ���� : �͸� ��ü ���� �� ������ �ſ� ����������, �÷��� �����ӿ����� ���� ��踦 ������ �� �����ϴ�
Lambda�� ������ : ���ٴ� ������ ��� �͸� ��ü�� ������ �� ����� �� ���� �ʴ�
	��Ģ 1) �͸� ���� ��ü�� �ڷ����� �ٷ� �������̽�
	��Ģ 2) �������̽� �߿����� �߻� �޼��尡 ���� 1���� �������̽��� ���
*/
public class LambdaTest extends JFrame{
	JButton bt;
	public LambdaTest() {
		bt=new JButton();
		
		bt.addActionListener((e)->{
			System.out.println(e);
		});
		
		add(bt);
		setVisible(true);
		setSize(300, 400);
	}
	public static void main(String[] args) {
		new LambdaTest();
	}
}
