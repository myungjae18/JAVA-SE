/*ȭ�鿡 ������ ��� ���Ӱ��� ������Ʈ���� �����ϴ� ��ü
 * �� ��ü�� �̿��ϸ�, ȭ�鿡 �����ϰų� ����� ��ü�� ���� ó���� ����������!
 */
package p0110.game;

import java.util.ArrayList;

public class ObjectManager {
	ArrayList<GameObject> objectList; //�迭�� ������...
	/*Ʋ������ 
	 * 1) ũ�⸦ ����� �ʿ䰡 ����
	 * 2) ���� ��ü���� ���� �� �ִ�
	*/
	public ObjectManager() {
		objectList=new ArrayList();
	}
	
	//��ü ���
	public void addObject(GameObject obj) {
		objectList.add(obj);
	}
	//��ü ����
	public void removeObject(GameObject obj) {
		objectList.remove(obj);
	}
}
