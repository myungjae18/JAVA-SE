package p0102;
import java.awt.event.*;
import javax.swing.*;

public class ChatCWindowAdapter extends WindowAdapter{
	public void windowClosing(WindowEvent e){
		ChatC chatC=new ChatC(chatA,chatB);
		//���� C�� ������ϰ��, A�� B�� �� �׾�� �˸���
		chatA.area.append("���׾��");
		chatB.area.append("���׾��");
	}
}
