//������ �繰�� �����ϱ� ���� Ŭ������ �ƴ϶�, Milk Ŭ������ ����ϱ� ���� Ŭ����
class UseMilk extends Milk{
	//������ ������ �����ϴ� �޼��带 ȣ���� �Ŀ�, �� ����� ������ ������ ȭ�鿡 ���
	public static void main(String[] args){
		Milk milk=new Milk(); //�ν��Ͻ�
		milk.setPrice();
		System.out.print(milk.price);
	}
}
