//ChatB�� Ű���� �̺�Ʈ�� ������ ����� ��ü ����
/*
������ � ���α׷��� �ۼ��ϴ�, �̺�Ʈ ��� ��ü�� ��Ȱ���ϸ� �ȵȴ�
ChatA, ChatB, ChatC�� ��� MyKeyAdapter�� �������� ������ �ϰ� �ִµ� �̴� ���������⸸ �ϰ� ���� ���� ����̴�.
*/
package p0103;
import java.awt.event.*;
import javax.swing.*;

public class MyKeyAdapter extends KeyAdapter{
	ChatA chatA; //area�� �����ؼ� �� ���� �Ϳ� ������ �� �ִ�
	ChatB chatB; //area�� �����ؼ� �� ���� �Ϳ� ������ �� �ִ�
	ChatC chatC; //area�� �����ؼ� �� ���� �Ϳ� ������ �� �ִ�

	public MyKeyAdapter(ChatA chatA,ChatB chatB,ChatC chatC){
		this.chatA=chatA;
		this.chatB=chatB;
		this.chatC=chatC;
	}
	public void keyReleased(KeyEvent k){
		int key=k.getKeyCode();

		if(key==KeyEvent.VK_ENTER){
			//System.out.println("���� ����");
			//ChatA�� ChatB�� area�� ���
			if(chatB !=null){//��ü�� �ּҰ��� null�� �ƴҶ��� �����ϵ��� ó��
				String msg=chatB.t_input.getText();
				chatB.area.append(msg+"\n");
			}
			if(chatA !=null){
				String msg=chatA.t_input.getText();
				chatA.area.append(msg+"\n");
			}
			if(chatC !=null){
				String msg=chatC.t_input.getText();
				chatC.area.append(msg+"\n");
			}
		}
	}
}
