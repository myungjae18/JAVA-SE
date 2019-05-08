package use;
import student.Boy;
/*나와는 전혀 다른 곳에 사는 클래스를 써보자
시스템에 의존적인 경로는 피해야 한다
*/
public class UseBoy{
	public static void main(String[] args){
		new Boy();	
	}
}
