package xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler{
	StringBuffer sb=new StringBuffer();
	
	//문서가 시작되는 태그를 만나면 아래의 메서드 호출
	public void startDocument() throws SAXException {
		System.out.println("startDocument() 호출");
	}
	public void startElement(String uri, String localName, String tag, Attributes attributes) throws SAXException {
		//System.out.println(elementName);
		//System.out.println(localName);
		//System.out.println(uri);
		System.out.print("<"+tag+">");
	}
	//태그와 태그 사이의 컨텐트를 만나면 알려주는 메서드
	public void characters(char[] ch, int start, int length) throws SAXException {
		//System.out.println(ch);
		sb.append(ch, start, length); //문자 하나 하나를 문자열로 모으자
		System.out.println(sb.toString().trim());
	}
	public void endElement(String uri, String localName, String tag) throws SAXException {
		System.out.println("</"+tag+">");
	}
	public void endDocument() throws SAXException {
		System.out.println("endDocument() 호출");
	}
}
