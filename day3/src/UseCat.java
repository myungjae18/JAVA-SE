/*���� �׳� ������ ���� ���̹Ƿ� ������ �繰�� �ݿ��ߴٰ� ���� �����*/
class UseCat{
	int a=8;
	static int b=7; //UseCat �Ҽ� ����

	public static void main(String[] args){ //UseCat�� �Ҽӵ� �����
		b=10; //main���� ���� Ŭ���� static ������ ���� ����
		int x=3;
		new Cat();
		Cat c=new Cat();
		int age=Cat.getAge(); //Ŭ������ �Ҽӵ� �޼����̹Ƿ� �ν��Ͻ����� �ʿ����
		System.out.println(age);
	}
}
