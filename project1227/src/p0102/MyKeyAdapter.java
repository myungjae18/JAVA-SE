//������ �޼��尡 ���� ��� ������ ��� �������̵带 �� Adapter�� ��ӹ���. �� ����, �츮�� �ʿ��� �޼��常 ��� �������̵��ϸ�, Listener�� ������������ ��� �� �ִ�.
package p0102;
import java.awt.event.*;

public class MyKeyAdapter extends KeyAdapter{
	//3���� �޼��� �߿��� ������ �ʿ��� �͸� ���׷��̵�
	public void keyReleased(KeyEvent k){
		int key=k.getKeyCode();
		
		if(key==KeyEvent.VK_ENTER){
			System.out.println("����");
		}
	}
}
