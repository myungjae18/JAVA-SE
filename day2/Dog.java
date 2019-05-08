/*static : 수식자*/
class Dog{
	static String type="말티즈";
	int age=8;

	public void bark(){
		System.out.println("멍멍");
	}
	public void eat(){
		System.out.println("저 먹어요");
	}
	public static void main(String[] args){
		int k=3;
		//static으로 선언된 멤버 변수는 인스턴스에 딸려 올라가지 않고, 클래스 원본에 스티커처럼 고정되어 있다. 따라서 소속은 여전히 클래스 원본 소속이므로, 클래스 변수라 한다..
		System.out.println(Dog.type);
		Dog d1=new Dog();
		/*d1을 출력해 보면, 강아지가 아닌 강아지의 heap 영역의 주소값이 출력된다.. 
		여기서 알 수 있는 것은 new를 받는 변수는 사실 상 강아지 자체가 아닌 그 강아지의 메모리 상의 위치만 알 수 있는 즉 주소값을 담고 있는 변수이다.
		이러한 변수를 가리켜 강아지를 가리킨다 하여 reference 변수라 한다..*/
		System.out.println(d1);
		Dog d2=new Dog();

		//static 사용해보기
		//객체 지향 언어에서는 javascript와는 달리 클래스 밖에 변수를 선언하더라도 인정받지 못한다..하지만, 전역 변수는 없더라도 전역변수의 역할을 해주는 static을 이용할 수 있다.
		//왜? static은 모든 인스턴스가 참조 가능한 클래스 원본 소속이므로...
	}
}
