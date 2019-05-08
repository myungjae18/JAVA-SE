package music;
import transport.Roller;

class UseMachine{
	public static void main(String[] args){
		final int x=3;

		MusicMachine m1=new Speaker();
		MusicMachine m2=new MP3Player();
		
		m1.setVolume();
		m2.setVolume();
		/*implements와 extends는 is a를 의미하므로 
		implements를 선언한 클래스는 해당 인터페이스와 같은 자료형으로 간주되어 형변환조차 가능하다*/
		Roller roller=new Speaker();
		roller.roll();
	}
}
