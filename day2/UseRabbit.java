//������ �繰�� ǥ���ϱ� ������ �ƴ϶�, ���� ������ ���� Ŭ�����̴�. ���� main ����θ� ����
class UseRabbit{
	int x=7; //��� ����
	public static void main(String[] args){
		UseRabbit ur = new UseRabbit();
		ur.x=3;
		System.out.println(ur.x);
		//�䳢�� 2���� �޸𸮿� �ø���, �Ѹ����� 3��, �ٸ� �Ѹ����� 5��� �����ϰ�, ���� ���̸� ���� ���
		//�䳢�� ��ȣ���� ������ ��, �� color�� ����Ͻÿ�
		Rabbit rabbit1=new Rabbit();
		Rabbit rabbit2=new Rabbit();
		rabbit1.age=3;
		rabbit2.age=5;
		System.out.println("ù° �䳢 ���̴� "+rabbit1.age);
		System.out.println("��° �䳢 ���̴� "+rabbit2.age);
		rabbit1.setColor("red");
		System.out.println("ù°�䳢�� ��ȣ���� "+rabbit1.color+"���� �����ߴ�");
		
	}
}
