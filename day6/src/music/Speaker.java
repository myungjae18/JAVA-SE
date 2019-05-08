/*음향기기 중 우퍼기능이 있는 스피커 정의*/
package music;
import transport.Roller;
//부모가 추상 클래스면 상속받는 자식클래스도 추상 클래스가 된다
public class Speaker extends MusicMachine implements Roller{
	//extends도 is a로 대체가 되지만 implements도 is a로 대체할 수 있다(형변환 가능)
	String name="우퍼스피커";
	int price=500;
	
	//javascript에서는 구현 강제까지는 불가능했지만, java, C# 같은 OOP 언어에서는 컴파일 타이밍에 구현을 강제한다
	//부모의 메서드 재정의(=override)
	/**스피커의 볼륨을 올려주는 메서드 ^____^ */
	public void setVolume(){
		System.out.println("스피커의 볼륨 조절");
	}
	/**MP3 파일을 지원할건데, 아직은 비워놓았습니다 ^__^b*/
	public void support(){}
	public void roll(){
		System.out.println("이동");
	}
}
