package p1227;

class StringTest2{
	public static void main(String[] args){
		/*String 클래스의 특징
			-불변성(immutable) : 수정 불가능

		*/
		String s="";
		for(int i=1; i<10000;i++){
			s=("줄넘기"+i);
		}
		/*위의 코드는 s 문자열이 10000번 수정되는 것이 아니라 10000번 생성되어 버린다(constant pool)..
		이런 일이 자주 일어나므로, 수정가능한 문자열 처리를 하기 위한 방법은
		StringBuffer, StringBulider를 사용하면 된다..*/
	}
}
