/*신발에 부착 시 타고 다닐 수 있는 장치를 정의한다*/
/*
인터페이스란 클래스는 아닌 객체로서 해당 자식 객체가 구현해야 할 기능 즉 메서드만을 보유한 집합이다.
인터페이스는 클래스가 아니므로, 다중 상속을 구현 할 수 있다.
따라서 현대 사회의 현실을 반영하기에 너무 좋다...
*/
package transport;

abstract public interface Roller{
	abstract public void roll();
}
