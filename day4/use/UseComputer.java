package use;
import machine.Computer;

class UseComputer {
	public void setColor(Computer p){ //(��)
		p.color="red";
		System.out.println(com);
	}
	public void setPrice(int price) {
		price=5; //(��)
	}
	
	public static void main(String[] args) {
		Computer com = new Computer();
		com.color = "black";
		
		UseComputer up = new UseComputer();
		System.out.println(com);
		up.setColor(com); // (��)
		up.setPrice(com.price);//(��)
		
		System.out.println(com.price);// (��)
	}
}
