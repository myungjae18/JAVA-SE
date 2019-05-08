/*
그래픽 처리와 관련된 주변지식
현실에서의 그림을 그리기 위한 요소
1) 주체(화가) --> 컴포넌트
2) 대상(캔버스) --> 컴포넌트
3) 그리는 도구(붓) -->그리는 행위이기에 컴포넌트의 paint() 메서드
4) 꾸며주는 도구(팔레트) paint(Graphics g)
*/
package p0104;
import javax.swing.*;
import java.awt.*;

//버튼이 스스로 그림을 그린다는데 그 원리를 검증해보자
//sun사에서 제공하는 GUI 컴포넌트를 개발자가 손대는 것이 과연 바람직한가? NO
/*컴포넌트 중에 개발자가 손댈 것이 있고 손대지 말아야 할 것이 있다..
컴포넌트 중에 아무런 그림이 그려져 있지 않고 개발자에게 그림 그릴 기회를 주는 컴포넌트가 제공되는데 이 컴포넌트를 Canvas라 한다*/
class GraphicsTest extends JFrame{
	MyButton bt;
	Canvas can; //도화지

	public GraphicsTest(){
		bt=new MyButton("나 버튼");
		can=new Canvas(){
			//개발자가 주도하에 그림을 그림
			public void paint(Graphics g){
				g.drawRect(50,50,100,100);
			}
		};
		can.setBackground(Color.RED);
		can.setPreferredSize(new Dimension(300,400));
		setLayout(new FlowLayout());
		
		add(bt);
		add(can);

		setSize(300,400);
		setVisible(true);

	}
	public static void main(String[] args){
		new GraphicsTest();
	}
}
