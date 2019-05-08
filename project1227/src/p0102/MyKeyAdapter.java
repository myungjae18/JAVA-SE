//구현할 메서드가 많을 경우 개발자 대신 오버라이드를 한 Adapter를 상속받자. 그 이후, 우리가 필요한 메서드만 골라서 오버라이드하면, Listener의 구현강제에서 벗어날 수 있다.
package p0102;
import java.awt.event.*;

public class MyKeyAdapter extends KeyAdapter{
	//3가지 메서드 중에서 나한테 필요한 것만 업그레이드
	public void keyReleased(KeyEvent k){
		int key=k.getKeyCode();
		
		if(key==KeyEvent.VK_ENTER){
			System.out.println("엔터");
		}
	}
}
