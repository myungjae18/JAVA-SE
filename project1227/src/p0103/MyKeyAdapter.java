//ChatB의 키보드 이벤트를 구현한 어댑터 객체 정의
/*
앞으로 어떤 프로그램을 작성하던, 이벤트 담당 객체는 재활용하면 안된다
ChatA, ChatB, ChatC가 모두 MyKeyAdapter를 공통으로 쓰고자 하고 있는데 이는 복잡해지기만 하고 좋지 않은 방법이다.
*/
package p0103;
import java.awt.event.*;
import javax.swing.*;

public class MyKeyAdapter extends KeyAdapter{
	ChatA chatA; //area를 포함해서 더 많은 것에 접근할 수 있다
	ChatB chatB; //area를 포함해서 더 많은 것에 접근할 수 있다
	ChatC chatC; //area를 포함해서 더 많은 것에 접근할 수 있다

	public MyKeyAdapter(ChatA chatA,ChatB chatB,ChatC chatC){
		this.chatA=chatA;
		this.chatB=chatB;
		this.chatC=chatC;
	}
	public void keyReleased(KeyEvent k){
		int key=k.getKeyCode();

		if(key==KeyEvent.VK_ENTER){
			//System.out.println("엔터 누름");
			//ChatA와 ChatB의 area에 출력
			if(chatB !=null){//객체의 주소값이 null이 아닐때만 수행하도록 처리
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
