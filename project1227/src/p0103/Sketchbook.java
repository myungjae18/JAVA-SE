package p0103;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

class Sketchbook extends JFrame{
	ArrayList panelList=new ArrayList(); //패널을 담을 list 생성
	JPanel background; //뒷 배경
	
	public Sketchbook(){
		background=new JPanel();
		//패널 만들어서 list에 넣기
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

		
		add(background); //background 추가

		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}
	public static void main(String[] args){
		new Sketchbook();
	}
}
