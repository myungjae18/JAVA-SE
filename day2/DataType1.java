class DataType1{
	public static void main(String[] args){
		byte b=3;
		byte c=5;
		b=c;
		int k=10;
		//����δ� ������ ������ �� �ǿ������� �ڷ����� ���� �����ؾ���
		k=c; //�ڵ��� ��ȯ
		b=(byte)k; //������ ��ȯ
	}
}
