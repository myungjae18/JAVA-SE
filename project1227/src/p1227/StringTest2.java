package p1227;

class StringTest2{
	public static void main(String[] args){
		/*String Ŭ������ Ư¡
			-�Һ���(immutable) : ���� �Ұ���

		*/
		String s="";
		for(int i=1; i<10000;i++){
			s=("�ٳѱ�"+i);
		}
		/*���� �ڵ�� s ���ڿ��� 10000�� �����Ǵ� ���� �ƴ϶� 10000�� �����Ǿ� ������(constant pool)..
		�̷� ���� ���� �Ͼ�Ƿ�, ���������� ���ڿ� ó���� �ϱ� ���� �����
		StringBuffer, StringBulider�� ����ϸ� �ȴ�..*/
	}
}
