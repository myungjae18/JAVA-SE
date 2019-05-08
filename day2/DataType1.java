class DataType1{
	public static void main(String[] args){
		byte b=3;
		byte c=5;
		b=c;
		int k=10;
		//실행부는 연산을 수행할 때 피연산자의 자료형이 완전 동일해야함
		k=c; //자동형 변환
		b=(byte)k; //강제형 변환
	}
}
