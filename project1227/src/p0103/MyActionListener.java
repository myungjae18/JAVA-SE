//���߿� �ǰ����� ���������� ���� �������� ActionListener�� ������ ��ü�� ������ ����
package p0103;
import java.awt.event.*;
import javax.swing.*;

public class MyActionListener implements ActionListener{
	//JTextArea area; ->���� ���� ���� �����ϱ� ���ؼ� area���� �ƴ� ChatA��ü�� �Ѱܹ���
	ChatA chatA;
	public MyActionListener(ChatA chatA){
		this.chatA=chatA;
	}
	public void actionPerformed(ActionEvent e){
		//System.out.println("��ư ����");
		chatA.area.append("��ư ������?\n");

		//ChatB�� ChatC�� �����Ѵ�
		ChatB chatB=new ChatB(chatA);
		ChatC chatC=new ChatC();
		//��� �¾ �� ������ â�� ChatB, ChatC�� ������ ChatA�� ��� ������ ����
		chatA.chatB=chatB;
		chatA.chatC=chatC;
	}
}
