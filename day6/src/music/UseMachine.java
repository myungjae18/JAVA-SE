package music;
import transport.Roller;

class UseMachine{
	public static void main(String[] args){
		final int x=3;

		MusicMachine m1=new Speaker();
		MusicMachine m2=new MP3Player();
		
		m1.setVolume();
		m2.setVolume();
		/*implements�� extends�� is a�� �ǹ��ϹǷ� 
		implements�� ������ Ŭ������ �ش� �������̽��� ���� �ڷ������� ���ֵǾ� ����ȯ���� �����ϴ�*/
		Roller roller=new Speaker();
		roller.roll();
	}
}
