//현실의 사물을 표현하기 위함이 아니라, 단지 실행을 위한 클래스이다. 따라서 main 실행부를 투자
class UseRabbit{
	int x=7; //멤버 변수
	public static void main(String[] args){
		UseRabbit ur = new UseRabbit();
		ur.x=3;
		System.out.println(ur.x);
		//토끼를 2마리 메모리에 올리고, 한마리는 3살, 다른 한마리는 5살로 설정하고, 둘의 나이를 각각 출력
		//토끼의 보호색을 변경한 후, 그 color를 출력하시오
		Rabbit rabbit1=new Rabbit();
		Rabbit rabbit2=new Rabbit();
		rabbit1.age=3;
		rabbit2.age=5;
		System.out.println("첫째 토끼 나이는 "+rabbit1.age);
		System.out.println("둘째 토끼 나이는 "+rabbit2.age);
		rabbit1.setColor("red");
		System.out.println("첫째토끼가 보호색을 "+rabbit1.color+"으로 변경했다");
		
	}
}
