/*
자바도 다른 응용프로그래밍 언어처럼, 윈도우 기반의 GUI 프로그래밍이 지원된다(AWT라는 패키지에서 지원)
*/
package p1227.gui;
import java.awt.Frame;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.TextArea;
import java.awt.Label;
import java.awt.List;
import java.awt.Color;

public class MyWin{
	public static void main(String[] args){
		//GUI 프로그래밍의 모든 요소들은 윈도우 안에서 존재할 수 있다
		//윈도우는 기본이 안보이는 속성이기 때문에 보이게 설정해야 한다..
		Frame frame=new Frame();//null 상태
		frame.setVisible(true);
		//너비, 높이
		frame.setSize(500,500);

		//자바도 다른 응용프로그램처럼 보편적인 컴포넌트(버튼,체크박스,라디오,select...)를 지원
		Button bt=new Button("버튼이다");
		
		//버튼을 부착하자
		//화면을 가득 메우는 버튼이 나오지 않게 하려면 개발자가 레이아웃 즉 알맞는 배치를 결정해야 한다. 아무것도 명시하지 않으면 디폴트 배치가 되므로
		frame.setLayout(new FlowLayout());
		//할아버지인 Container가 add를 보유하고 있다
		frame.add(bt);
		TextField tf=new TextField(20);
		frame.add(tf);
		Checkbox cb1=new Checkbox();
		Checkbox cb2=new Checkbox();
		frame.add(cb1);
		frame.add(cb2);
		
		//라디오 박스 부착 (Radiobox는 별도의 자료형이 없고, 대신 체크박스 그룹을 이용한다..)
		CheckboxGroup group=new CheckboxGroup();
		
		Checkbox g1=new Checkbox("남", false,group);
		Checkbox g2=new Checkbox("여", false,group);
		frame.add(g1);
		frame.add(g2);
		//html의 멀티라인 입력이 가능한 textbox인 textarea가 자바에서도 동일함
		TextArea area=new TextArea(10,15);
		frame.add(area);
		//글씨 넣기
		Label la=new Label("난그냥 글씨여");
		frame.add(la);
		//list = javascript의 selectbox와 동일함
		List list=new List(1);
		list.add("수성");
		list.add("금성");
		list.add("지구");
		list.add("화성");
		list.add("목성");
		list.add("토성");
		list.add("천왕성");
		list.add("해왕성");
		list.add("명왕성");

		frame.add(list);
		//API는 지금 이순간에도 끝없이 생성되고 있다.. 모든 것을 다 공부할 수는 없으므로 API를 활용하는 방법으로 해결한다..
		/*API 활용하는 방법
		1)해당 클래스의 목적 즉 무엇을 하는 클래스인가
		2)사용하는 방법 조사, 클래스는 결국 사용하도록 만들어진 것이다.
		사용하려면 메모리에 올리는 방법을 알아야 한다. 모든 객체가 다 new로 메모리에 올릴 수 있는 것은 아니다.
		-메모리에 올리는 방법
		1.일반 클래스 new
		2.추상 클래스는 new 불가->자식을 new 
		3.인터페이스도 new 불가->자식을 new
		*/
		/*
		Color의 빛의 삼원색
		Red		Green	Blue
		0~255	0~255	0~255 
		*/
		Color c=new Color(0,0,0);
		bt.setBackground(c);
		//색상을 RGB가 아닌 인간에게 더 친숙한 상수로 사용하는 방법
		bt.setForeground(Color.YELLOW);
		
	}
}
