package animal;
public class Duck extends /*=is a*/Bird{
	String name="����";

	public Duck(){
		super(10);
	}
	public void fly(){
		System.out.println("������ ����");
	}
	public static void main(String[] args){
		Bird bird=new Bird();
		Duck d=new Duck();
		Bird b=d;
		d=(Duck)bird;
	}
}
