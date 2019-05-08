package p0102;
import java.awt.event.*;
import javax.swing.*;

public class ChatBWindowAdapter extends WindowAdapter{
	public ChatBWindowAdapter(ChatB chatB){
	}
	public void windowClosing(WindowEvent e){
		ChatB chatB=new ChatB(chatA,chatC);
		//내가 C의 어댑터일경우, A와 B에 나 죽어요 알리기
		chatB.area.append("나죽어요");
		chatC.area.append("나죽어요");
	}
}
