package animal;
public class Duck extends /*=is a*/Bird{
	String name="오리";

	public Duck(){
		super(10);
	}
	public void fly(){
		System.out.println("오리가 난다");
	}
	public static void main(String[] args){
		Bird bird=new Bird();
		Duck d=new Duck();
		Bird b=d;
		d=(Duck)bird;
	}
}
