/*
반드시 있어야 하는 기능에 대한 구현을 강제시키기 위해 이 클래스를 상위 객체로 정의한다.
따라서 30여명의 모든 개발자들은 이 클래스를 상속받아야 한다(이전에 했던 GameObject 느낌..)
*/
package music;

abstract public class MusicMachine{
	//볼륨을 조절한다
	/*브레이스를 없앤 행위는 실수가 아님을 컴파일러에게 알려주어야 하는데, 이럴 때 사용되는 수식자를 abstract라 한다.. 
	그리고 abstract로 선언된 메서드를 불완전한 메서드라 하여 추상메서드라 한다..
	추상메서드를 하나라도 갖고 있는 클래스는 추상클래스가 되어 abstract 수식자를 선언해야 한다..*/
	abstract public void setVolume(); //몸체 없는 메서드
	abstract public void support();
}
