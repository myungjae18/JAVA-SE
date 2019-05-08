//다른 언어와 마찬가지로 자바 언어도 이벤트를 지원한다
package p1231;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class EventTest extends JFrame implements ActionListener{
	JButton bt;

	public EventTest(String title){
		super(title);
		bt=new JButton("클릭");
		setLayout(new FlowLayout()); //프레임이 borderLayout에서 FlowLayout으로 변경
		add(bt);
		//bt과 ActionEvent 연결(javascript와 동일)
		bt.addActionListener(this); //메서드의 인수는 Listener인 자가 온다 ->바로 나 자신(this)
		setSize(300,400);
		setVisible(true);
	}

	//완전 동일한 메서드이어야 오버라이드가 인정된다..
	//사용자가 일으킨 ActionEvent의 인스턴스가 아래 메서드의 인수로 전달되는 것이다..
	public void actionPerformed(ActionEvent e){
		System.out.println("확인");
	}
	public static void main(String[] args){
		new EventTest("나 윈더우");
	}
}
