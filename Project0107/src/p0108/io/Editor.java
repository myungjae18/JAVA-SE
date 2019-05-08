package p0108.io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Editor extends JFrame implements ActionListener{
	JMenuBar bar;
	JMenu menu;
	JMenuItem[] item=new JMenuItem[4];
	String[] item_title= {"새로 만들기","열기","저장","끝내기"};
	JTextArea area;
	JScrollPane scroll;
	FileReader reader; //문자 기반 스트림(2byte)
	FileWriter writer; //문자 기반 출력 스트림
	JFileChooser chooser;
	File file;
	
	public Editor() {
		bar=new JMenuBar();
		menu=new JMenu("파일");
		for (int i = 0; i < item.length; i++) {
			item[i]=new JMenuItem(item_title[i]);
			item[i].addActionListener(this);
		}
		area=new JTextArea();
		scroll=new JScrollPane(area);
		chooser=new JFileChooser("F:/java_developer/javaSE/Project0107/res");
		
		//바에 메뉴 장착
		bar.add(menu);
		menu.add(item[0]);
		menu.add(item[1]);
		menu.add(item[2]);
		menu.addSeparator(); //구분선
		menu.add(item[3]);
		
		//bar를 프레임에 부착
		setJMenuBar(bar);
		add(scroll);
		
		//혹시 닫히지 않은 스트림을 처리하기 위해서 윈도우 이벤트 처리
		addWindowFocusListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				terminate();
			}
		});
		setSize(600,500);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj=e.getSource();//이벤트를 일으킨 컴포넌트 반환
		if(obj==item[0]) {
			newFile();
		}else if(obj==item[1]) {
			openFile();
		}else if(obj==item[2]) {
			saveFile();
		}else if(obj==item[3]) {
			terminate();
		}
	}
	//열려진 스트림을 닫고 프로세스도 종료하는 메서드
	public void terminate() {
		if(reader!=null) {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.exit(0);
	}
	public void newFile() {
		area.setText("");
	}
	public void openFile() {
		//유저가 원하는 파일을 선택할 수 있도록 파일 탐색기를 띄우자
		int result=chooser.showOpenDialog(this);
		System.out.println(result);
		if(result==JFileChooser.APPROVE_OPTION) {
			//열기를 원할 경우, 유저가 선택할 파일을 반환 받자
			file=chooser.getSelectedFile();
			//System.out.println(file.getAbsolutePath());
			this.setTitle(file.getAbsolutePath());
			try {
				reader=new FileReader(file);
				//읽기
				int data=-1;
				while(true) {
				data=reader.read();
				if(data==-1)break;
				area.append(Character.toString((char)data));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//지금 열어놓은 
	public void saveFile() {
		String text=area.getText();
		char[] array=text.toCharArray();
		//파일 스트림 계열은 빈(empty) 파일을 생성한다
		try {
			writer=new FileWriter(file);
			for (int i = 0; i < array.length; i++) {
				writer.write(array[i]);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			if(writer!=null) {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new Editor();
	}

}
