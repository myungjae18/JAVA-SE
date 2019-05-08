package p0104;
import javax.swing.JFrame;
import java.awt.Canvas;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

//슬라이드 갤러리
class SlideGallery extends JFrame{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Image img;
	String[] labArray=new String[9]; //제목 담을 배열
	JLabel label;
	Canvas can; //사진 붙여질 곳
	JPanel p_south; //버튼 영역
	JButton bt_left; //왼쪽 버튼
	JButton bt_right; //오른쪽 버튼
	
	int index=0; //증가할 labArray의 값
	int dex=8; //감소할 labArray의 값
				
	public SlideGallery(){
		//labArray에 파일명 넣기
		labArray[0] ="F:/java_developer/javaSE/project1227/src/res/p0104_res/1.jpg";  
		labArray[1] ="F:/java_developer/javaSE/project1227/src/res/p0104_res/2.jpg";  
		labArray[2] ="F:/java_developer/javaSE/project1227/src/res/p0104_res/3.jpg";  
		labArray[3] ="F:/java_developer/javaSE/project1227/src/res/p0104_res/4.jpg";  
		labArray[4] ="F:/java_developer/javaSE/project1227/src/res/p0104_res/5.jpg";  
		labArray[5] ="F:/java_developer/javaSE/project1227/src/res/p0104_res/6.jpg";  
		labArray[6] ="F:/java_developer/javaSE/project1227/src/res/p0104_res/7.jpg";  
		labArray[7] ="F:/java_developer/javaSE/project1227/src/res/p0104_res/8.jpg";  
		labArray[8] ="F:/java_developer/javaSE/project1227/src/res/p0104_res/9.jpg";
				
		label=new JLabel(labArray[0]);
		img=kit.getImage(labArray[0]);
		can=new Canvas(){
			public void paint(Graphics g){
				g.drawImage(img,0,0,600,700,can);
			}
		};
		p_south=new JPanel();
		bt_left=new JButton("prev");
		bt_right=new JButton("next");

		label.setPreferredSize(new Dimension(600,50));
		
		//p_south에 버튼 부착
		p_south.add(bt_left);
		p_south.add(bt_right);

		add(label, BorderLayout.NORTH); //label 붙이기
		add(can); //can 붙이기
		add(p_south, BorderLayout.SOUTH); //p_south 붙이기
				
		//System.out.println(labArray[0]);
		
		//왼쪽 버튼에 기능 구현
		bt_right.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(index==8){
					JOptionPane.showMessageDialog(label,"끝");
				}else{
					img=kit.getImage(labArray[index++]);
					can.repaint(); //다시 렌더링
					label.setText(labArray[index]);
				}
			}
		});
		
		//오른쪽 버튼에 기능 구현
		bt_left.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(index==0){
					JOptionPane.showMessageDialog(label,"끝");
				}else{
					img=kit.getImage(labArray[dex--]);
					can.repaint(); //다시 렌더링
					label.setText(labArray[dex]);
				}
			}
		});
		
		setSize(600,800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		new SlideGallery();
	}
}
