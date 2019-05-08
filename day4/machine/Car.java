package machine;

public class Car{
	/*
	sun 사에서는 클래스의 메서드를 정의할 때, 메서드명을 중복 정의할 수 있도록 허용했다. 단, 아래의 조건 중 하나를 만족시켜야 한다
	1) 매개변수의 개수 차별화
	2) 매개변수의 자료형 차별화
	이렇게 메서드명을 중첩할 수 있는 메서드 정의 기법을 오버로딩(overLoading)이라 한다
	*/
	public void run(int speed){
	}
	public void run(int speed, int g){
	}
	public void run(){
	}
}
