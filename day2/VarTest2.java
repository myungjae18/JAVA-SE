public class VarTest2 {
	public static void main(String[] args) {
		//c,java ��� int ��(32bit)�� �������� ������ �����ϵ��� ó��->���� int�� ���� ���� �ӵ��� ����
		//�����ڰ�  int������ ���� �ڷ���(byte, short)���� ������ �����ϸ� �ڵ����� int������ ����ȯ�� ����Ų��..
		short s1=3; //(��)
		short s2=4; //(��)
		
		int a1 = 3;//(��)
		int a2 = 4;//(��)
		
		short sum = (short)(s1+s2); //(��)
		//�����̳� �Ʒ��� ���
		int sum = (s1+s2); 
		int result = a1+a2;//(��)	
		
		//�Ǽ������� ������ �Ǵ� �ڷ����� �ִ� - double
		//ex)float k=5.6; ->float�� double�� ����ȯ
		//ex2)float k=5.6f; ->f�� �ٿ� ����ȯ���� ����
	}
} 
