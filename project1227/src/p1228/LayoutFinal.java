/*각 배치관리자마다 특성이 있기 때문에 개발 시 적절히 조합해서 사용해야 하지만,
한 컨테이너 당 한 종류의 객체관리자만 지원이 된다
awt에서 지원하는 컨테이너들은 배치의 문제를 고민할 수 있고,
각 컨테이너마다 적절한 배치관리자를 개발자가 설정할 수 있는데,
만일 배치관리자를 적용하지 않으면 디폴트 배치관리자가 적용된다...
->Frame : BorderLayout
->Panel : FlowLayout
Panel이란 윈도우처럼 독립적인 컨테이너가 아니라
반드시 윈도우 안에서만 소속될 수 있는 작은 규모의 컨테이너이다.
div와 상당히 흡사하여 윈도우 안에서의 내부 화면 분할에 주로 사용된다.
*/
package p1228;
import java.awt.*;

class LayoutFinal{
	public static void main(String[] args){
		Frame frame=new Frame();
		Panel panel=new Panel();
		Button bt1=new Button("북");
		Button bt2=new Button("중");

		frame.add(bt1, BorderLayout.NORTH);
		panel.add(bt2); //판자에 버튼 부착
		//패널은 이미 FlowLayout이므로 아무것도 할 필요가 없다
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(600,400);
	}
}
