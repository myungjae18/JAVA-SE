package xml;

import java.io.File;
import java.io.StringReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLSAXParser extends DefaultHandler {
	// SAXParserFactory
	private SAXParserFactory parserFactory;
	// SAXParser
	private SAXParser parser;
	// ���� �±׸�
	private String startTagName;
	// �� �±׸�
	private String endTagName;
	// String buffer
	private StringBuffer buffer = new StringBuffer();
	// �±׸� 
	private String name;
	private String brand;
	private String price;
	// ������
	public XMLSAXParser() {
		super();
		try {
			parserFactory = SAXParserFactory.newInstance();
			parser = parserFactory.newSAXParser();
		} catch (Exception e) {
			System.out.println("Exception >> " + e.toString());
		}
	}
	// ������ ����
	public void startDocument() {
		// System.out.println("start document!!");
	}
	// ������ ����
	public void endDocument() {
		// System.out.println("end document!!");
	}
	// ���� �±� �ν����� �� ó��
	public void startElement(String url, String name, String elementName, Attributes attrs) throws SAXException {
		startTagName = elementName;
		// reset
		buffer.setLength(0);

		System.out.print("<" + startTagName + ">");
	}
	// �����±׿� ���±� ������ ������ �ν� ���� �� ó��
	public void characters(char[] str, int start, int len) throws SAXException {
		buffer.append(str, start, len);
		// �±׸� �� 'mxCprc'�� �����ؼ� ������ ��´�.
		if (this.startTagName.equals("name")) {
			this.name = buffer.toString().trim();
			System.out.print(this.name);
		}
		// �±׸� �� 'totalCount'�� �����ؼ� ������ ��´�.

		if (this.startTagName.equals("brand")) {
			this.brand = buffer.toString().trim();
			System.out.print(this.brand);
		}
		if (this.startTagName.equals("price")) {
			this.price = buffer.toString().trim();
			System.out.print(this.price);
		}
	}
	// ���±׸� �ν� ���� �� ó��
	public void endElement(String url, String localName, String name) {
		endTagName = name;
		System.out.println("</" + endTagName + ">");
	}
	// parse
	public void parse(File xml) {
		System.out.println("�Ѱܹ��� xml " + xml);
		try {
			parser.parse(xml, this);
		} catch (Exception e) {
			System.out.println("XMLSAXParser Exception " + e.toString());
		}
	}
	// ���� �� ��������
	public String getName() {
		return name;
	}
	public String getBrand() {
		return brand;
	}
	public String getPrice() {
		return price;
	}
	/*
	 * 
	 * public static void main(String[] args) {
	 * 
	 * XMLSAXParser parser = new XMLSAXParser("D:\\test.xml");
	 * 
	 * try {
	 * 
	 * parser.parse();
	 * 
	 * System.out.println("x = " + parser.getX());
	 * 
	 * System.out.println("y = " + parser.getY());
	 * 
	 * } catch (Exception e) {
	 * 
	 * System.out.println("parser.parse() Exception >> " + e.toString());
	 * 
	 * }
	 * 
	 * }
	 * 
	 */
}