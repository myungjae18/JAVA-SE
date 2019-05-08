package p1228;
import java.awt.*;

class Login{
	public static void main(String[] args){
		Frame frame=new Frame();//윈도우창 만들기
		Panel pTop=new Panel();//윗부분 영역의 패널 생성
		Panel pBottom=new Panel();//아랫 부분 영역의 패널 생성
		Label lbId=new Label("id");//pTop의 id라벨
		TextField tfId=new TextField();//pTop의 id텍스트
		Label lbPw=new Label("password");//pTop의 pw라벨
		TextField tfPw=new TextField();//pTop의 pw텍스트
		Button btLogin=new Button("로그인");//pBottom의 로그인버튼
		Button btRegist=new Button("가입");//pBottom의 가입버튼
		BorderLayout border=new BorderLayout();//BorderLayout 생성
		Dimension dTf=new Dimension(70,20);//TextField 사이즈 조정
		Dimension dLb=new Dimension(20,20);//Label 사이즈 조정
		frame.setLayout(border); //배치관리자 적용

		//tfId와 tfPw의 사이즈 조정
		lbId.setPreferredSize(dLb);
		tfId.setPreferredSize(dTf);
		lbPw.setPreferredSize(dTf);
		tfPw.setPreferredSize(dTf);

		//TextField와 Label을 pTop에 부착
		pTop.add(lbId);
		pTop.add(tfId);
		pTop.add(lbPw);
		pTop.add(tfPw);

		//버튼을 pBottom에 부착
		pBottom.add(btLogin);
		pBottom.add(btRegist);
				
		//각 패널을 프레임에 부착
		frame.add(pTop, BorderLayout.NORTH);
		frame.add(pBottom, BorderLayout.SOUTH);

		//프레임을 보이게 설정
		frame.setVisible(true);
		frame.setSize(300,120);
	}
}
