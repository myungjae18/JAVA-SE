/*������ �� ���۱���� �ִ� ����Ŀ ����*/
package music;
import transport.Roller;
//�θ� �߻� Ŭ������ ��ӹ޴� �ڽ�Ŭ������ �߻� Ŭ������ �ȴ�
public class Speaker extends MusicMachine implements Roller{
	//extends�� is a�� ��ü�� ������ implements�� is a�� ��ü�� �� �ִ�(����ȯ ����)
	String name="���۽���Ŀ";
	int price=500;
	
	//javascript������ ���� ���������� �Ұ���������, java, C# ���� OOP ������ ������ Ÿ�ֿ̹� ������ �����Ѵ�
	//�θ��� �޼��� ������(=override)
	/**����Ŀ�� ������ �÷��ִ� �޼��� ^____^ */
	public void setVolume(){
		System.out.println("����Ŀ�� ���� ����");
	}
	/**MP3 ������ �����Ұǵ�, ������ ������ҽ��ϴ� ^__^b*/
	public void support(){}
	public void roll(){
		System.out.println("�̵�");
	}
}
