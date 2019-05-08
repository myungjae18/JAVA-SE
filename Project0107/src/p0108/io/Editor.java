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
	String[] item_title= {"���� �����","����","����","������"};
	JTextArea area;
	JScrollPane scroll;
	FileReader reader; //���� ��� ��Ʈ��(2byte)
	FileWriter writer; //���� ��� ��� ��Ʈ��
	JFileChooser chooser;
	File file;
	
	public Editor() {
		bar=new JMenuBar();
		menu=new JMenu("����");
		for (int i = 0; i < item.length; i++) {
			item[i]=new JMenuItem(item_title[i]);
			item[i].addActionListener(this);
		}
		area=new JTextArea();
		scroll=new JScrollPane(area);
		chooser=new JFileChooser("F:/java_developer/javaSE/Project0107/res");
		
		//�ٿ� �޴� ����
		bar.add(menu);
		menu.add(item[0]);
		menu.add(item[1]);
		menu.add(item[2]);
		menu.addSeparator(); //���м�
		menu.add(item[3]);
		
		//bar�� �����ӿ� ����
		setJMenuBar(bar);
		add(scroll);
		
		//Ȥ�� ������ ���� ��Ʈ���� ó���ϱ� ���ؼ� ������ �̺�Ʈ ó��
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
		Object obj=e.getSource();//�̺�Ʈ�� ����Ų ������Ʈ ��ȯ
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
	//������ ��Ʈ���� �ݰ� ���μ����� �����ϴ� �޼���
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
		//������ ���ϴ� ������ ������ �� �ֵ��� ���� Ž���⸦ �����
		int result=chooser.showOpenDialog(this);
		System.out.println(result);
		if(result==JFileChooser.APPROVE_OPTION) {
			//���⸦ ���� ���, ������ ������ ������ ��ȯ ����
			file=chooser.getSelectedFile();
			//System.out.println(file.getAbsolutePath());
			this.setTitle(file.getAbsolutePath());
			try {
				reader=new FileReader(file);
				//�б�
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
	
	//���� ������� 
	public void saveFile() {
		String text=area.getText();
		char[] array=text.toCharArray();
		//���� ��Ʈ�� �迭�� ��(empty) ������ �����Ѵ�
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
