/*현실의 토끼를 정의하되 아래의 조건에 맞게 작성하시오
1)이름, 나이, 색상
2)뛰는 동작
3)먹는 동작*/
class Rabbit{
	//javascript는 변수 선언시 데이터를 초기화 하지 않으면 undefined가 들어있었다. 하지만 java는....
	String name; //String은 클래스이다. 객체 자료형은 null로 대체
	int age; //개발자가 멤버변수에 정수값을 대입하지 않으면 디폴트로 컴파일러가 0을 대입한다...
	String color="white";
	public void run(){
		System.out.println("저 뛰어요");
	}
	public void eat(){
		System.out.println("저 먹어요");
	}
	public void setColor(String color){
		this.color=color;
	}
	//보호색 적용하기(color 변경)

}
