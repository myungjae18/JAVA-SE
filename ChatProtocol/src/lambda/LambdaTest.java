package lambda;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
Lambda : 알론조 처치라는 수학자에 의해 고안된 계산 표현식이었으나, 그 제자가 프로그래밍 언어로 도입했다
Lambda는 익명함수를 정의하는 표현식에 사용
--------------------------------------------------------------------------------------------------------
자바스크립트와 같은 기타 언어들에서는 함수 지향 표기법으로 람다를 사용하지만,
자바는 객체지향 언어이기 때문에 이 Lambda 표현식으로 바로 익명 객체를 정의할 때 사용된다..
	-자바가 얻는 장점 : 익명 객체 정의 시 수식이 매우 간단해지며, 컬랙션 프레임웍으로 각종 통계를 추출할 때 유용하다
Lambda의 주의점 : 람다는 무조건 모든 익명 객체를 정의할 떄 사용할 수 있지 않다
	원칙 1) 익명 구현 객체의 자료형은 바로 인터페이스
	원칙 2) 인터페이스 중에서도 추상 메서드가 오직 1개인 인터페이스만 허용
*/
public class LambdaTest extends JFrame{
	JButton bt;
	public LambdaTest() {
		bt=new JButton();
		
		bt.addActionListener((e)->{
			System.out.println(e);
		});
		
		add(bt);
		setVisible(true);
		setSize(300, 400);
	}
	public static void main(String[] args) {
		new LambdaTest();
	}
}
