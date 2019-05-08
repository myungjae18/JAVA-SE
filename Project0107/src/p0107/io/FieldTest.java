package p0107.io;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileSystemView;

public class FieldTest extends JFrame{
	JPanel p_north, p_center;
	JButton bt;
	JFileChooser searchTool;
	JTextArea textArea;
	File file;
	FileInputStream fis;
	File title;
	public FieldTest() {
		p_north=new JPanel();
		p_center=new JPanel();
		bt=new JButton("copy");
		textArea=new JTextArea(10,10);
		
		p_north.add(bt);
		
		p_center.add(textArea);
		
		add(p_north);
		add(p_center, BorderLayout.SOUTH);
		
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				searchTool=new JFileChooser(FileSystemView.getFileSystemView());
				JOptionPane.showInputDialog(searchTool);
				title=searchTool.getSelectedFile();
				
				System.out.println(title);
				write();
			}
		});
		
		setSize(500,700);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FieldTest();
	}
	public void write() {
		try{
			fis=new FileInputStream(title);
			int data;
			while(true){
				data=fis.read(); //1byte 읽어들임
				if(data==-1)break; //break : while문 빠져나오는 기능
				String datas=String.valueOf((char)data);
				System.out.print((char)data);
				textArea.append(datas);
			}
		}catch(FileNotFoundException f){
			f.printStackTrace(); //에러 원인을 stack 구조로 누적하여 출력
			System.out.println("파일을 찾을 수 없습니다......");
		}catch(IOException e){
			System.out.println("입출력 중 오류가 발생했습니다.....");
		}finally{
			//finally를 명시하면 try문도 catch문도 이 영역을 거쳐간다
			//->주로 스트림, db를 사용 후 닫을 때 사용한다
			try{
				fis.close();
			}catch(IOException e){
				System.out.println("스트림 종료 중 오류가 발생했습니다...");
			}
		}
	}

}
