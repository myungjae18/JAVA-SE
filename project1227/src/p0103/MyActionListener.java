//개발에 피곤함은 느껴지지만 공부 목적으로 ActionListener를 구현한 객체를 별도로 정의
package p0103;
import java.awt.event.*;
import javax.swing.*;

public class MyActionListener implements ActionListener{
	//JTextArea area; ->보다 많은 것을 접근하기 위해서 area만이 아닌 ChatA자체를 넘겨받자
	ChatA chatA;
	public MyActionListener(ChatA chatA){
		this.chatA=chatA;
	}
	public void actionPerformed(ActionEvent e){
		//System.out.println("버튼 누름");
		chatA.area.append("버튼 눌렀어?\n");

		//ChatB와 ChatC를 생성한다
		ChatB chatB=new ChatB(chatA);
		ChatC chatC=new ChatC();
		//방금 태어난 두 윈도우 창인 ChatB, ChatC의 정보를 ChatA의 멤버 변수에 대입
		chatA.chatB=chatB;
		chatA.chatC=chatC;
	}
}
