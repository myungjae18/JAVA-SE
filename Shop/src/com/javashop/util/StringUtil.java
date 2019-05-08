/*
 * 스트링 처리 관련하여 기능을 모아놓을 클래스
 * */
package com.javashop.util;
public class StringUtil {
	
	
	//확장자 추출하기
	public static String getExt(String path) {
		//가장 마지막 점의 index를 구한다.
		int last=path.lastIndexOf(".");
		String ext=path.substring(last+1,path.length());
		return ext;
	}
	
	public static void main(String[] args) {
		getExt("C:/java_developer/javaSE/Preject0107/res");
	}
	
}
//getExt("C:/java_developer/javaSE/Preject0107/res");