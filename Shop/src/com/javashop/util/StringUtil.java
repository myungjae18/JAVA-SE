/*
 * ��Ʈ�� ó�� �����Ͽ� ����� ��Ƴ��� Ŭ����
 * */
package com.javashop.util;
public class StringUtil {
	
	
	//Ȯ���� �����ϱ�
	public static String getExt(String path) {
		//���� ������ ���� index�� ���Ѵ�.
		int last=path.lastIndexOf(".");
		String ext=path.substring(last+1,path.length());
		return ext;
	}
	
	public static void main(String[] args) {
		getExt("C:/java_developer/javaSE/Preject0107/res");
	}
	
}
//getExt("C:/java_developer/javaSE/Preject0107/res");