package p0103;
import javax.swing.*;
import java.awt.event.*;

class Test extends JFrame{
	JButton[] bt=new JButton[50];
	public Test(){
		/*
		이벤트 연결 코드는 로직이 아니라 이벤트 발생 시 개발자가 원하는 로직을 호출해주는 단순 역할을 하고 재활용성도 떨어진다.
		왜냐하면 이 클래스가 아닌 다른 클래스에서 재사용할 수 없기 때문이다..
		이런 경우에도 개발자가 .java를 만들어서 이벤트를 처리해야 하는가? no
		*/
		setLayout(new java.awt.FlowLayout());

		//final int a=8; 내부 익명 클래스는 멤버변수는 접근할 수 있지만 지역변수는 final로 선언된 것만 접근이 가능하다(즉 변경 불가능)
		for(int i=0;i<bt.length;i++){
			bt[i]=new JButton(i+"번");
			//내부익명클래스(Anoymous Inner Class)
			//내부익명클래스는 자신을 보유하고 있는 해당 클래스의 멤버변수에 접근할 수 있다
			bt[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//a=2; ->변경하려고 했으므로 오류 발생
					//System.out.println(a); ->접근 가능
					Object obj=e.getSource(); //이벤트를 일으킨 주체가 되는 컴포넌트의 레퍼런스를 얻는 메서드
					JButton btn=(JButton)obj; //다운케스팅
					System.out.println(btn.getText());
				}
			});
			add(bt[i]);
		}
		setSize(200,400);
		setVisible(true);
	}
	public static void main(String[] args){
		new Test();
	}
}
