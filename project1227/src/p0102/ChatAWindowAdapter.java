package p0102;
import java.awt.event.*;
import javax.swing.*;

public class MyWindowAdapter extends WindowAdapter{
	public void windowClosing(WindowEvent e){
		ChatA chatA=new ChatA();
		//���� C�� ������ϰ��, A�� B�� �� �׾�� �˸���
		chatA.area.append("���׾��");
	}
}
