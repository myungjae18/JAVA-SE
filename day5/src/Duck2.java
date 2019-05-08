package test;

public class Duck2 extends Bird2{
	String name="난 오리";
	public void fly() {
		System.out.println("오리가 난다.");
	}
	public static void main(String[] args) {
		//Bird b1 =new Bird();//(A)
		//Duck d1 = (Duck)b1;//(B)
		
		Duck2 d2=new Duck2();//(C)
		Bird2 b2=(Bird2)d2;//(D)
		System.out.println(b2);//(E)
		System.out.println(d2);//F)
		
		System.out.println(b2.name);//(G)
		b2.fly();//(H)		
	}
}

