/*������ �䳢�� �����ϵ� �Ʒ��� ���ǿ� �°� �ۼ��Ͻÿ�
1)�̸�, ����, ����
2)�ٴ� ����
3)�Դ� ����*/
class Rabbit{
	//javascript�� ���� ����� �����͸� �ʱ�ȭ ���� ������ undefined�� ����־���. ������ java��....
	String name; //String�� Ŭ�����̴�. ��ü �ڷ����� null�� ��ü
	int age; //�����ڰ� ��������� �������� �������� ������ ����Ʈ�� �����Ϸ��� 0�� �����Ѵ�...
	String color="white";
	public void run(){
		System.out.println("�� �پ��");
	}
	public void eat(){
		System.out.println("�� �Ծ��");
	}
	public void setColor(String color){
		this.color=color;
	}
	//��ȣ�� �����ϱ�(color ����)

}
