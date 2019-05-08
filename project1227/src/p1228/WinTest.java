package p1228;
import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.Button;
public class WinTest{
	/*
	컴포넌트를 사용하기에 앞서, 먼저 배치를 결정해야 원하는 화면 디자인 결과가 나온다
	윈도우 프로그래밍 시 각 응용프로그램마다 지원하는 배치방법이 있는데,
	자바에서는 LayoutMananger라는 클래스가 이 역할을 수행한다
	LayoutManager의 종류...
	1)BorderLayout : 동,서,남,북,중앙이라는 방위를 갖는 배치관리자
	
	2)FlowLayout : 수직, 수평 방향으로 컴포넌트를 배치할 수 있는 배치관리자
	
	3)GridLayout : 격자형태의 배치를 지원하는 배치관리자
	
	4)GridBagLayout : 좌표를 지원하는 배치관리자
	
	5)CardLayout : 한 화면에 한 가지의 컴포넌트만 보여주는 배치관리자
	*/
	public static void main(String[] args){
		//컴포넌트를 윈도우에 올려놓기 전에 배치 방법을 결정하자
		/*자바의 프레임을 포함한 일명 컨테이너형은 모두 배치관리자를 결정할 수 있다..
		이때 사용되는 메서드가 setLayout() 메서드이다..*/
		//Frame is a Container가 당연히 지원된다
		Frame frame=new Frame();
		BorderLayout border=new BorderLayout();
		frame.setLayout(border); //배치관리자 적용
		//버튼 5개를 생성하여 각 방위에 붙여보자
		Button bt_north=new Button("북쪽");
		Button bt_west=new Button("서쪽");
		Button bt_east=new Button("동쪽");
		Button bt_south=new Button("남쪽");
		Button bt_center=new Button("중앙");

		//각 방위에 맞게 버튼 부착
		//방위를 설정하지 않으면 디폴트가 CENTER이다
		//frame.add(bt_north,BorderLayout.NORTH);
		frame.add(bt_west,BorderLayout.WEST);
		frame.add(bt_east,BorderLayout.EAST);
		frame.add(bt_south,BorderLayout.SOUTH);
		frame.add(bt_center,BorderLayout.CENTER);
		
		//윈도우는 디폴트가 숨김 속성
		frame.setVisible(true);
		frame.setSize(500,500);

	
	}
}
