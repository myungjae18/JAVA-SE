/*화면에 등장할 모든 게임관련 오브젝트들을 관리하는 객체
 * 이 객체를 이용하면, 화면에 등장하거나 사라질 객체에 대한 처리가 간결해진다!
 */
package p0110.game;

import java.util.ArrayList;

public class ObjectManager {
	ArrayList<GameObject> objectList; //배열과 같으나...
	/*틀린점은 
	 * 1) 크기를 명시할 필요가 없다
	 * 2) 오직 객체만을 담을 수 있다
	*/
	public ObjectManager() {
		objectList=new ArrayList();
	}
	
	//객체 등록
	public void addObject(GameObject obj) {
		objectList.add(obj);
	}
	//객체 제거
	public void removeObject(GameObject obj) {
		objectList.remove(obj);
	}
}
