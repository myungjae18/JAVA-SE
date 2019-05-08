/*단지 그냥 실행을 위한 것이므로 현실의 사물을 반영했다고 보기 힘들다*/
class UseCat{
	int a=8;
	static int b=7; //UseCat 소속 변수

	public static void main(String[] args){ //UseCat에 소속된 실행부
		b=10; //main에서 같은 클래스 static 영역을 접근 가능
		int x=3;
		new Cat();
		Cat c=new Cat();
		int age=Cat.getAge(); //클래스에 소속된 메서드이므로 인스턴스조차 필요없다
		System.out.println(age);
	}
}
