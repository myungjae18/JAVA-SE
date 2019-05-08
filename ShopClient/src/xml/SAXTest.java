package xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SAXTest {
	//���� ������ �����ؾ� �Ѵ�...FileInputStream
	FileInputStream fis;
	String path="E:/java_developer/javaSE/ShopClient/data/Product.xml";
	File file;
	SAXParserFactory factory;
	SAXParser parser;
	MyHandler handler;
		
	public SAXTest() {
		
		factory=SAXParserFactory.newInstance();
		try {
			parser=factory.newSAXParser();
			fis=new FileInputStream(path);
			file=new File(path);
			//SAX ����� �±׸��� ������ �̺�Ʈ�� �߻����� �˷��ִ� �ڵ鷯�� �̿��ؾ� �Ѵ�..
			//handler=new MyHandler();
			try {
				parser.parse(fis, handler);
				XMLSAXParser xmls=new XMLSAXParser();
				xmls.parse(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new SAXTest();
	}
}
