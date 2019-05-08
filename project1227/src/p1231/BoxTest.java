package p1231;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

//텍스트박스와 버튼이 있는 간단한 윈도우 창을 만든다..
class BoxTest extends JFrame{
	JPanel panelTop; //위쪽 패널
	JPanel panelBottom; //아랫쪽 패널
	JTextField textFieldTop; //위쪽 텍스트박스
	JTextField textFieldBottom; //아래쪽 텍스트박스
	JButton bt; //버튼
	public BoxTest(){
		panelTop=new JPanel(); //위쪽 패널 호출	
		panelBottom=new JPanel();	//아랫쪽 패널 호출
		textFieldTop=new JTextField(); //위쪽 텍스트박스 호출
		textFieldBottom=new JTextField(); //아랫쪽 텍스트박스 호출
		bt=new JButton("로그인"); //버튼 호출

		panelTop.setLayout(new BorderLayout()); //panelTop에 배치관리자 적용
		panelTop.setSize(300,80); //panelTop의 사이즈 정하기
		panelTop.add(textFieldTop); //panelTop에 textFieldTop 부착
		panelTop.add(textFieldBottom, BorderLayout.SOUTH); //panelTop에 textFieldBottom 부착
		
		panelBottom.setLayout(new BorderLayout()); //panelBottom에 배치관리자 적용
		panelBottom.setSize(300,40); //panelBottom의 사이즈 정하기
		panelBottom.add(bt); //panelBottom에 bt 부착

		
		add(panelTop, BorderLayout.NORTH); //윈도우에 panelTop 부착
		add(panelBottom, BorderLayout.SOUTH); //윈도우에 panelBottom 부착

		setVisible(true); //윈도우창 보이게 만들기
		setSize(300,120); //윈도우창의 크기 지정
	}
	public static void main(String[] args){
		new BoxTest();
	}
}
