package p0102;
import java.awt.event.*;
import javax.swing.*;

public class ChatBWindowAdapter extends WindowAdapter{
	public ChatBWindowAdapter(ChatB chatB){
	}
	public void windowClosing(WindowEvent e){
		ChatB chatB=new ChatB(chatA,chatC);
		//���� C�� ������ϰ��, A�� B�� �� �׾�� �˸���
		chatB.area.append("���׾��");
		chatC.area.append("���׾��");
	}
}
