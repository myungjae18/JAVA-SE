package use;
import machine.Computer;

class UseComputer {
	public void setColor(Computer p){ //(가)
		p.color="red";
		System.out.println(com);
	}
	public void setPrice(int price) {
		price=5; //(나)
	}
	
	public static void main(String[] args) {
		Computer com = new Computer();
		com.color = "black";
		
		UseComputer up = new UseComputer();
		System.out.println(com);
		up.setColor(com); // (다)
		up.setPrice(com.price);//(라)
		
		System.out.println(com.price);// (마)
	}
}
