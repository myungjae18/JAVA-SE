package collection;

import java.util.HashSet;
import java.util.Iterator;

//���� ���� �÷��� �����ӿ��� ��ҵ��� ���� �ְ� �������ִ� ���� ������ �� ���� ��ü�� �н��Ѵ�
public class EnumTest {
	
	public static void main(String[] args) {
		HashSet<String> set=new HashSet<String>();
		//���𰡸� ���� �� ���� ���� �������
		set.add("���");
		set.add("����");
		set.add("�ٳ���");
		
		Iterator<String> it=set.iterator(); //iterator�� ���� set�� �Ϸķ� ������ �ݺ����� ����� �� �ִ�
		while(it.hasNext()) { //hasnext()�� ����� �ִ� ��Ұ� ���� ������ true�� ��ȯ
			String str=it.next(); //rs.next()�� ���
			System.out.println(str);
		}
	}
}
