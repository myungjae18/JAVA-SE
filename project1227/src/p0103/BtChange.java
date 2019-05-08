package p0103;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class BtChange extends JFrame{
	JPanel p_north, p_center;
	JButton bt_create, bt_bg;

	//자바에서 배열은 객체취급
	/*
	-자바에서의 배열 선언시 주의점
	자바뿐만 아니라, C#, C, C++ 등 대부분의 컴파일 기반 언어에서는 배열의 크기가 컴파일 시점에 결정되어 있어야 한다..
	즉 선언할 때는 반드시 그 크기를 명시해야 한다(자바스크립트와는 완전 틀림)
	*/
	JButton[] btn=new JButton[10];
	int index=0;

	/*
	java util 패키지에는 객체를 모아서 처리하는데 유용한 라이브러리가 지원되는데,
	이 라이브러리를 가리켜 collection framework이라 한다.
	배열은 반복문과 함꼐 사용하기에 적당하였으나 생성 시 그 크기를 명시해야 하는 강제사항이 개발에 불편함을 초래한다.
	->해결책 : 컬렉션 프레임웍은 현실의 객체가 모여있는 모습에 따라 크게 3가지 유형으로 분리한다
	1) List : 객체가 순서있게 모여있는 모습을 처리할 수 있는 API로 배열과 거의 비슷하지만
	1.List는 크기에 대한 명시를 강제하지 않고,
	2.기본자료형까지 지원하는 배열과 달리 컬렉션 프레임웍의 대상은 오직 객체만을 대상으로 한다.
	2) Set : 객체가 순서를 가지지 않고 모여있는 모습을 처리할 수 있는 API
	3) Map : key-value의 쌍으로 객체를 모아놓고 처리할 수 있는 API
	*/
	ArrayList list=new ArrayList(); //List 계열 -> 순서를 가진다

	public BtChange(){
		p_north=new JPanel();
		p_center=new JPanel();
		bt_create=new JButton("생성");
		bt_bg=new JButton("배경");

		p_north.add(bt_bg);
		p_north.add(bt_create);
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		bt_create.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JButton bt=new JButton("나버튼");
				p_center.add(bt);
				//btn[index++ ]=bt;
				list.add(bt);
				System.out.println("담기 전 크기는 "+list.size());
				p_center.updateUI(); //다시 렌더링
			}
		});
		
		bt_bg.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//생성된 모든 버튼을 대상으로 배경 변경
				for(int i=0;i<list.size();i++){
					//넣을 때 스스로 Object형으로 Upcasting되어 들어간다
					JButton b=(JButton)list.get(i);
					b.setBackground(Color.YELLOW);
				}
			}
		});

		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		//자바에서의 배열은 곧 객체이다 (new 연산자로 데이터를 생성하면 heap에 인스턴스 생성된다. 따라서 arr 변수는 레퍼런스 변수이다)
		int[] arr=new int[5];
		//System.out.println(arr[1]);
		new BtChange();
	}
}
