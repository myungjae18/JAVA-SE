package animal;
public class Bird{
	String name="새";
	int age;
	public Bird(int age){
		//super(); 생략 ->부모 객체(지금은 object)가 없는 자식 객체는 없기 때문에...
	}
	public void fly(){
		System.out.println("난다");
	}
}
