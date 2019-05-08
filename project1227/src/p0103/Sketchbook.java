package p0103;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

class Sketchbook extends JFrame{
	ArrayList panelList=new ArrayList(); //�г��� ���� list ����
	JPanel background; //�� ���
	
	public Sketchbook(){
		background=new JPanel();
		//�г� ���� list�� �ֱ�
		for(int i=0;i<1000;i++){ 
			JPanel panel=new JPanel();
			panel.setBackground(Color.GRAY);
			background.add(panel);
			panel.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent m){
				panel.setBackground(Color.YELLOW);
			}
		});
			panelList.add(panel);	
		}

		
		add(background); //background �߰�

		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}
	public static void main(String[] args){
		new Sketchbook();
	}
}
