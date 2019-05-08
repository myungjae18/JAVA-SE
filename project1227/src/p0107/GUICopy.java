package p0107;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;


//복사 프로그램 만들기
public class GUICopy extends JFrame{
	JPanel p_north;
	JPanel p_south;
	JTextField txt_top;
	JTextField txt_bot;
	JButton bt_copy;
	String fileName;
	String copy_fileName;
	FileInputStream fis;
	FileOutputStream fos;

	public GUICopy(){
		p_north=new JPanel();
		p_south=new JPanel();
		txt_top=new JTextField(40);
		txt_bot=new JTextField(40);
		bt_copy=new JButton("copy");

		p_north.setLayout(new BorderLayout());
				
		p_north.add(txt_top);
		p_north.add(txt_bot, BorderLayout.SOUTH);

		p_south.add(bt_copy);

		add(p_north, BorderLayout.NORTH);
		add(p_south, BorderLayout.SOUTH);

		bt_copy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fileName=	txt_top.getText();
				copy_fileName=txt_bot.getText();
				copy();
				//System.out.println(fileName);
			}
		});
		
		setSize(700,200);
		setVisible(true);
	}
	public void copy(){
		try{
			fis=new FileInputStream(fileName);
			fos=new FileOutputStream(copy_fileName);
			while(true){
				int data;
				data=fis.read(); //1byte 읽어들임
				if(data==-1)break; //break : while문 빠져나오는 기능
				//출력하자
				fos.write(data); //data 출력
			}
			}catch(NullPointerException e){
			}catch(IOException e){
			}finally{
				try{
					fis.close();
				}catch(IOException e){}
				
			}
	}
	public static void main(String[] args){
		new GUICopy();
	}
}
