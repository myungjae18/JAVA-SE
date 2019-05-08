/*
자바의 모든 GUI 컴포넌트는 크게 2가지 유형으로 나뉜다
1)Container 형
	-Frame(독립적) : BorderLayout
	, Panel(의존적) : FlowLayout
2)일반 컴포넌트 형
*/
//배치관리자 중 그리드 방식을 지원하는 GridLayout을 사용해본다
package p0102;
import javax.swing.*;
import java.awt.*;

class GridTest extends JFrame{
	JButton[] btn=new JButton[18]; //공간을 생성

	public GridTest(){
		//버튼을 부착하기 전에 레이아웃을 결정짓자
		setLayout(new GridLayout(6,3));
		for(int i=0; i<btn.length;i++){
			btn[i]=new JButton("버튼"+i);
			add(btn[i]);
		}
		setSize(500,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		new GridTest();
	}
}
