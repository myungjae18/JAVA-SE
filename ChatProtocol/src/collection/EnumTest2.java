package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class EnumTest2 {
	public static void main(String[] args) {
		HashMap<Integer, String> map=new HashMap<Integer, String>(); //<key, value>
		
		map.put(1, "사과");
		map.put(2, "딸기");
		map.put(3, "레몬");
		
		//map은 enum이나 iterator가 모두 안먹히기 때문에 set으로 변환해주어 iterator를 사용한다..
		Set set=map.keySet(); //set형으로 변환
		Iterator<Integer> it=set.iterator();
		
		while(it.hasNext()) {
			int key=it.next(); 
			String obj=map.get(key); //key값을 이용해 value 반환
			System.out.println(obj);
		}	
	}
}
