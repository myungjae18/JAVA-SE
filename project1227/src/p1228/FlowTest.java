//배치관리자 중 FlowLayout을 공부한다
package p1228;
import java.awt.*; //*는 클래스에만 적용

class FlowTest{
	public static void main(String[] args){
		/*개발자가 컨테이너에 아무런 배치관리자를 결정짓지 못하면 디폴트 배치관리자가 적용되는데,
		Frame의 경우엔 BorderLayout이 적용된다.*/
		Frame frame=new Frame();
		
		//배치관리자를 디폴트가 아닌, 우리가 원하는 것으로 설정하자
		FlowLayout flow=new FlowLayout();
		/*FlowLayout의 특징 : 
		1)수평, 수직 방향으로 흘러다닌다(위치가 고정되지 않음)
		2)컴포넌트 본연의 크기를 유지할 수 있다*/
		frame.setLayout(flow); //플로우 적용
		for(int i=1; i<=20;i++){
			frame.add(new Button("난"+i+"버튼"));
		}

		frame.setVisible(true);
		frame.setSize(300,400);
	}
}
