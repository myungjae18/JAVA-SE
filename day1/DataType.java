/*자바 언어도 다른 언어처럼 3가지 자료형을 피해갈 수 없다
1)문자 - char [charactor] (2byte = 전세계 모든 언어를 담을 수 있다)
2)숫자 - 정수 byte(1byte) < short(2byte) < int(4byte) < long(8byte)
         - 실수 float(4byte) < double(8byte)
3)논리값 - boolean(1byte)
*/
class DataType{
	/*자바 스크립트와 같은 스크립트 기반의 언어는 데이터의 종류를 스스로 판단하지만, 컴파일 기반의 언어는 데이터의 종류를 개발자가 결정해야 한다(메모리에 확보될 공간의 크기를 결정)
	int x=8; ->메모리에 8을 생성하되, 그 8을 담게 될 메모리의 크기를 4byte만큼 확보하라
	사실상 최소 단위는 사용이 불편하므로 기본단위를 많이 사용한다..
	전산에서 데이터의 최소 단위는 bit인데, bit로는 만들어낼 수 이쓴ㄴ 흑백논리와 관련된 수준의 프로그램만 개발할 수 있다. 즉 할 수 있는 게 별로 없다.
	따라서 bit 단위를 여러 개 묶은 단위를 기본 단위로 사용하는데, bit를 8개 모아놓은 단위를 byte라 한다.
	1)byte로 표현할 수 있는 데이터의 경우의 수는 2^8가지
	*/
	public static void main(String[] args){
		char a='앙'; //문자열이 아닌 문자를 담을 수 있다
		int k=7; //정수를 담을 수 있다
		float b=3.14f; //float일 때만 f를 붙인다
		boolean c=true;
	}
}
