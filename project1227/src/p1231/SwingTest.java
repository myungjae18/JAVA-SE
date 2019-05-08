/*
awt는 자바의 GUI를 담당하는 패키지로써 많은 기능을 지원한다..
하지만 awt는 각 os별로 디자인이 다르게 표현된다(Look&Feel)..
따라서 이 문제를 개선한 패키지를 사용하면 되는데 이 패키지를 스윙(swing)이라 한다..
swing은 awt의 컴포넌트명 앞에 'J'가 접두어로 들어간다.
ex) Button -> JButton (javax.swing..)
주의)awt가 완전히 안 쓰이는게 아니라, 배치관리자와 이벤트 등을 여전히 awt에서 지원한다
*/
package p1231;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;

class SwingTest extends JFrame{
	JButton bt; 
	public SwingTest(){
		bt=new JButton("나버튼");
		//frame에 지정된 디폴트 배치관리자는 BorderLayout이다
		setLayout(new FlowLayout());
		add(bt);

		setVisible(true);
		setSize(300,400);
	}
	public static void main(String[] args){
		new SwingTest();
	}
}
