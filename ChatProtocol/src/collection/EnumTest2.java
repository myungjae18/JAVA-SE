package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class EnumTest2 {
	public static void main(String[] args) {
		HashMap<Integer, String> map=new HashMap<Integer, String>(); //<key, value>
		
		map.put(1, "���");
		map.put(2, "����");
		map.put(3, "����");
		
		//map�� enum�̳� iterator�� ��� �ȸ����� ������ set���� ��ȯ���־� iterator�� ����Ѵ�..
		Set set=map.keySet(); //set������ ��ȯ
		Iterator<Integer> it=set.iterator();
		
		while(it.hasNext()) {
			int key=it.next(); 
			String obj=map.get(key); //key���� �̿��� value ��ȯ
			System.out.println(obj);
		}	
	}
}
