package p0102;
import java.awt.event.*;
import javax.swing.*;

public class MyWindowAdapter extends WindowAdapter{
	public void windowClosing(WindowEvent e){
		ChatA chatA=new ChatA();
		ChatB chatB=new ChatB(chatA,chatC);
		ChatC chatC=new ChatC(chatA,chatB);
		 //���� C�� ������ϰ��, A�� B�� �� �׾�� �˸���
		 chatA.area.append("���׾��");
		 chatB.area.append("���׾��");
	}
}
