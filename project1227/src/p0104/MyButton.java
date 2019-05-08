//JButton은 이미 잘 그려진 컴포넌트이지만 이 실습에서는 이 버튼을 우리가 주도하여 망가뜨려보자
package p0104;
import javax.swing.JButton;
import java.awt.Graphics;

public class MyButton extends JButton{
	public MyButton(String title){
		super(title);
	}
	//버튼의 그리는 행위를 빼앗아보자 ->오버라이드
	public void paint(Graphics g){
		System.out.println("그리기");
	}
}
