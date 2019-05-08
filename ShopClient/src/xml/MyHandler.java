package xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler{
	StringBuffer sb=new StringBuffer();
	
	//������ ���۵Ǵ� �±׸� ������ �Ʒ��� �޼��� ȣ��
	public void startDocument() throws SAXException {
		System.out.println("startDocument() ȣ��");
	}
	public void startElement(String uri, String localName, String tag, Attributes attributes) throws SAXException {
		//System.out.println(elementName);
		//System.out.println(localName);
		//System.out.println(uri);
		System.out.print("<"+tag+">");
	}
	//�±׿� �±� ������ ����Ʈ�� ������ �˷��ִ� �޼���
	public void characters(char[] ch, int start, int length) throws SAXException {
		//System.out.println(ch);
		sb.append(ch, start, length); //���� �ϳ� �ϳ��� ���ڿ��� ������
		System.out.println(sb.toString().trim());
	}
	public void endElement(String uri, String localName, String tag) throws SAXException {
		System.out.println("</"+tag+">");
	}
	public void endDocument() throws SAXException {
		System.out.println("endDocument() ȣ��");
	}
}
