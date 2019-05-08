package p0102;
import java.awt.event.*;
import javax.swing.*;

public class MyWindowAdapter extends WindowAdapter{
	public void windowClosing(WindowEvent e){
		ChatA chatA=new ChatA();
		ChatB chatB=new ChatB(chatA,chatC);
		ChatC chatC=new ChatC(chatA,chatB);
		 //내가 C의 어댑터일경우, A와 B에 나 죽어요 알리기
		 chatA.area.append("나죽어요");
		 chatB.area.append("나죽어요");
	}
}
