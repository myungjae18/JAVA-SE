//현실의 사물을 정의하기 위한 클래스가 아니라, Milk 클래스를 사용하기 위한 클래스
class UseMilk extends Milk{
	//우유의 가격을 변경하는 메서드를 호출한 후에, 그 변경된 우유의 가격을 화면에 출력
	public static void main(String[] args){
		Milk milk=new Milk(); //인스턴스
		milk.setPrice();
		System.out.print(milk.price);
	}
}
