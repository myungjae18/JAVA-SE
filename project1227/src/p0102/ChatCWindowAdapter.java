package p0102;
import java.awt.event.*;
import javax.swing.*;

public class ChatCWindowAdapter extends WindowAdapter{
	public void windowClosing(WindowEvent e){
		ChatC chatC=new ChatC(chatA,chatB);
		//내가 C의 어댑터일경우, A와 B에 나 죽어요 알리기
		chatA.area.append("나죽어요");
		chatB.area.append("나죽어요");
	}
}
