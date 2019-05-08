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
import java.util.List;

//슬라이드 갤러리
class Gallery extends JFrame{
	Toolkit kit=Toolkit.getDefaultToolkit();
	List<Image> list=new ArrayList(); //이미지만 담을 수 있는 리스트 생성
	String[] labArray=new String[9]; //제목 담을 배열
	String dir="F:/java_developer/javaSE/project1227/src/res/p0104_res/";
	String[] fileName={
		"1.jpg",
		"2.jpg",
		"3.jpg",
		"4.jpg",
		"5.jpg",
		"6.jpg",
		"7.jpg",
		"8.jpg",
		"9.jpg"
	};
	JLabel label;
	Canvas can; //사진 붙여질 곳
	JPanel p_south; //버튼 영역
	JButton bt_left; //왼쪽 버튼
	JButton bt_right; //오른쪽 버튼	
		
	int index=0; //증가할 labArray의 값
	int dex=8; //감소할 labArray의 값

	Image img; //현재 보여줄 이미지
				
	public Gallery(){
		//이미지 객체를 10개 만들어 List에 채워넣기
		for(int i=0;i<fileName.length;i++){
			Image img1=kit.getImage(dir+fileName[i]);
			list.add(img1);
		}		
		System.out.println(list.size());

		label=new JLabel("");
		img=list.get(index); //디폴트로 보여줄 이미지
		can=new Canvas(){
			public void paint(Graphics g){
				g.drawImage(img,0,0,600,700,can);
			}
		};
		p_south=new JPanel();
		bt_left=new JButton("prev");
		bt_right=new JButton("next");

		label.setPreferredSize(new Dimension(600,50));

		bt_right.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				next();
				setTitle();
			}
		});

		bt_left.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				prev();
				setTitle();
			}
		});
		
		//p_south에 버튼 부착
		p_south.add(bt_left);
		p_south.add(bt_right);
		
		setTitle();
		add(label, BorderLayout.NORTH); //label 붙이기
		add(can); //can 붙이기
		add(p_south, BorderLayout.SOUTH); //p_south 붙이기
				
		//System.out.println(labArray[0]);
		
		//왼쪽 버튼에 기능 구현
		
		
		setSize(600,800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//제목을 출력한다
	public void setTitle(){
		label.setText(dir+fileName[index]);
	}
	public void next(){
		if(index<list.size()-1){
			index++;
			img=list.get(index);
			//paint를 다시 그리도록 유도
			can.repaint();
		}else{
			JOptionPane.showMessageDialog(this, "마지막 이미지");
		}
	}
	public void prev(){
		if(index>0){
			index--;
			img=list.get(index);
			//paint를 다시 그리도록 유도
			can.repaint();
		}else{
			JOptionPane.showMessageDialog(this, "끝");
		}
	}
	public static void main(String[] args){
		new Gallery();
	}
}
