/*자바에서의 이벤트 프로그래밍의 3단계 작업
1)적절한 리스너를 선택한다 (ex)버튼은 click이 어울린다)
2)해당 리스너의 추상메서드를 재정의한다(하고싶은것)
3)이벤트를 일으킨 컴포넌트(이벤트 소스)와 리스너와 연결(ex)bt.addActionListener(리스너 객체))
*/

package p1231;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//리스너가 추상적인 인터페이스인 이유
/*이벤트가 발생했을 때, 어떤 로직을 구현할지는 sun사가 결정하는 게 아니라,
개발작 결정하는 것이기 때문에... 그 내욜을 확정지을 수 없다... 
따라서 불완전한 추상메서드를 구현강제한다..*/

class EventTest2 extends JFrame implements ActionListener, KeyListener, ItemListener{//내가 곧 리스너 자료형이다
	public static final int WIDTH=300; //가로길이 상수 선언...
	public static final int HEIGHT=400;
	JTextField t_txt;
	JButton bt1,bt2;
	Choice choiceFruit;
	public EventTest2(){
		t_txt=new JTextField(20);
		bt1=new JButton("버튼1");
		bt2=new JButton("버튼2");
		choiceFruit=new Choice();
		choiceFruit.add("apple");
		choiceFruit.add("strawberry");
		choiceFruit.add("grapes");
		
		setLayout(new FlowLayout());
		add(t_txt);
		add(bt1);
		add(bt2);
		add(choiceFruit);
		
		//버튼과 리스너와의 연결
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		t_txt.addKeyListener(this);
		choiceFruit.addItemListener(this);

		/*상수란 프로그램이 끝날 때까지 그 값이 변하지 않고 유지 및 공유되는 고정된 데이터를 말하는데,
		특히 개발 시 데이터에 의미를 부여하는 경우가 많다...
		변수와 구분하기 위해서 전문 대문자로 선언한다(개발자들 간 약속)*/
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(WIDTH,HEIGHT);
		setVisible(true);
	}

	//오버라이드
	public void actionPerformed(ActionEvent e){
		/*자바스크립트와 마찬가지로, 액션이벤트는 꼭 버튼에만 줄 수 있는 것은 아니므로,
		반환되는 이벤트 소스가 언제나 버튼일 수는 없다.. 
		따라서 예측이 불가능하기 때문에 반환형을 sun사에서는 Object로 받아 버렸다..*/
		Object obj=e.getSource();
		JButton btn=(JButton)obj; //다운케스팅

		//bt1, bt2와 btn을 비교하자
		if(btn==bt1){
			System.out.println("bt1을 눌렀군");
		}else if(btn.equals(bt2)){
			System.out.println("bt2를 눌렀군..");
		}
	}

	public void itemStateChanged(ItemEvent e){
		String item=choiceFruit.getSelectedItem();
		System.out.println(item);
	}

	//오버라이드
	2
	public static void main(String[] args){
		new EventTest2();
	}
}
