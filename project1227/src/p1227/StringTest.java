package p1227;

class StringTest{
	//����, ����, ����
	char c='��';
	public static void main(String[] args){
		/*String Ŭ������ ���� ���� ����ϱ� ������ sun ���� rt.jar API �������� ��Ű���� java.lang�� ����ִ�.
		�׸��� java.lang��Ű���� �����ڰ� ������� �ʴ´�.. 
		�� ����Ʈ�� import �Ǿ� �ִ�.*/
		//String Ŭ������ new �����ڿ� ���� �ν��Ͻ��� �����ϴ� ����� explicit(����� ������)�̶� �Ѵ�. ��, new�� ����� ���� �ǹ��Ѵ�..
		String s1=new String("korea");	
		String s2=new String("korea");
		System.out.println(s1==s2);

		/*�⺻ �ڷ���ó�� String�� ��ü�� �����ϴ� ����� implicit(�Ͻ��� ������)�̶� �Ѵ�..
		��κ� �޸𸮸� ���� ��� �Դ� ����� ���������� �Ͻ��� �������� �ַ� ����Ѵ�..*/
		String x1="canada";
		String x2="canada";
		System.out.println(x1==x2);
		
		//��ó�� �ּҸ� ���ϴ� ���� �ƴ϶�, ��ü�� ������ ���ϴ� ���
		System.out.println(x1.equals(x2));
	}
}
