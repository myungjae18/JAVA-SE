//우유를 정의한다(사용자 정의 자료형)
//자바에서는 우리가 알고 있었던 기본 자료형 + 내가 만든 자료형, 따라서 총 자료형이 4가지이다(객체지향 언어)
//객체지향 언어에서 개발자는 데이터를 정의할 수 있는 주체이다
class Milk{
	/*변수와 함수밖에 정의할 수 없다*/
	String color="white";
	int price=1000;
	//가격을 변경하는 메서드
	//반환형 여부를 결정지어야 한다
	public void setPrice(){
		price=500;
	}
	System.out.print(price);
}
