package collection;

import java.util.HashSet;
import java.util.Iterator;

//순서 없는 컬랙션 프레임웍의 요소들을 순서 있게 나열해주는 도구 역할의 두 가지 객체를 학습한다
public class EnumTest {
	
	public static void main(String[] args) {
		HashSet<String> set=new HashSet<String>();
		//무언가를 담을 때 순서 없이 담아진다
		set.add("사과");
		set.add("딸기");
		set.add("바나나");
		
		Iterator<String> it=set.iterator(); //iterator를 통해 set이 일렬로 세워져 반복문을 사용할 수 있다
		while(it.hasNext()) { //hasnext()는 담겨져 있는 요소가 있을 때까지 true를 반환
			String str=it.next(); //rs.next()와 흡사
			System.out.println(str);
		}
	}
}
