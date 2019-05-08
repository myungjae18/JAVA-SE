package p1227;

class StringTest{
	//문자, 숫자, 논리값
	char c='대';
	public static void main(String[] args){
		/*String 클래스는 워낙 많이 사용하기 때문에 sun 사의 rt.jar API 압축파일 패키지중 java.lang에 들어있다.
		그리고 java.lang패키지는 개발자가 명시하지 않는다.. 
		즉 디폴트로 import 되어 있다.*/
		//String 클래스를 new 연산자에 의해 인스턴스를 생성하는 방법을 explicit(명시적 생성법)이라 한다. 즉, new를 명시한 것을 의미한다..
		String s1=new String("korea");	
		String s2=new String("korea");
		System.out.println(s1==s2);

		/*기본 자료형처럼 String을 객체로 생성하는 방법을 implicit(암시적 생성법)이라 한다..
		대부분 메모리를 많이 잡아 먹는 명시적 생성법보다 암시적 생성법을 주로 사용한다..*/
		String x1="canada";
		String x2="canada";
		System.out.println(x1==x2);
		
		//위처럼 주소를 비교하는 것이 아니라, 객체의 내용을 비교하는 방법
		System.out.println(x1.equals(x2));
	}
}
