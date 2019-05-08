public class VarTest2 {
	public static void main(String[] args) {
		//c,java 등에서 int 형(32bit)을 기준으로 연산을 수행하도록 처리->따라서 int가 가장 연산 속도가 빠름
		//개발자가  int형보다 작은 자료형(byte, short)으로 연산을 수행하면 자동으로 int형으로 형변환을 일으킨다..
		short s1=3; //(가)
		short s2=4; //(나)
		
		int a1 = 3;//(다)
		int a2 = 4;//(라)
		
		short sum = (short)(s1+s2); //(마)
		//윗줄이나 아랫줄 사용
		int sum = (s1+s2); 
		int result = a1+a2;//(바)	
		
		//실수에서도 기준이 되는 자료형이 있다 - double
		//ex)float k=5.6; ->float이 double로 형변환
		//ex2)float k=5.6f; ->f를 붙여 형변환하지 않음
	}
} 
