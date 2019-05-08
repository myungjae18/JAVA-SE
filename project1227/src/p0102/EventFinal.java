/*
이벤트 프로그램 작성 절차
1.적절한 Listener 선택
2.오버라이드
	-오버라이드 대상 메서드가 너무 많을 경우 사용하지도 않는 메서드를 개발자가 코드 상에 존재시켜 놓는 것은 너무 비합리적이다..
	->해결책 : sun사에서는 개발자 대신 인터페이스를 구현한 객체를 지원하는데, Adapter라는 이름을 가진 클래스이다.
	재정의할 메서드가 3개 이상 되면 Adapter 지원 여부를 확인하면 된다.
3.컴포넌트와 Listener와의 연결
*/
package p0102;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//온갖 종류의 이벤트를 감지하는 클래스를 정의한다
class EventFinal extends JFrame implements ActionListener, ItemListener{
	JTextField txt;
	JButton bt1,bt2;
	Choice ch;
	MyKeyAdapter mk;
	MyWindowAdapter mw;

	public EventFinal(){
		txt=new JTextField(25);
		bt1=new JButton("버튼1");
		bt2=new JButton("버튼2");
		ch=new Choice();
		
		ch.add("자바");
		ch.add("오라클");
		ch.add("jsp/String");

		setLayout(new FlowLayout());
		add(txt);
		add(bt1);
		add(bt2);
		add(ch);
		txt.addKeyListener(mk=new MyKeyAdapter());
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		ch.addItemListener(this);
		//윈도우 리스너 연결
		this.addWindowListener(mw=new MyWindowAdapter());

		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void itemStateChanged(ItemEvent e){}
	public void actionPerformed(ActionEvent e){
		System.out.println("눌렀군");
		/*자바스크립트와 마찬가지로, 액션이벤트는 꼭 버튼에만 줄 수 있는 것은 아니므로,
		반환되는 이벤트 소스가 언제나 버튼일 수는 없다.. 
		따라서 예측이 불가능하기 때문에 반환형을 sun사에서는 Object로 받아 버렸다..*/
		Object obj=e.getSource();
		JButton btn=(JButton)obj; //다운케스팅
		
		//bt1, bt2와 btn을 비교하자
		if(btn==bt1){
			System.out.println("bt1을 눌렀군");
		}else if(btn.equals(bt2)){
			JOptionPane.showMessageDialog(this, "버튼 2를 눌렀군");
		}
	}

	public static void main(String[] args){
		new EventFinal();
	}
}
