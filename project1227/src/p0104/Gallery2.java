package p0104;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

class Gallery extends JFrame{
	String dir="C:/Users/itbank/Desktop/이진욱_수업자료/java_developer/java/190104_day12/src/shurek/";
	String[] filename={
		"img0.jpg",
		"img1.jpg",
		"img2.jpg",
		"img3.jpg",
		"img4.jpg",
		"img5.jpg",
		"img6.jpg"
	};
	List<Image> list=new ArrayList(); // <> 안에 요소의 종류를 한정함.
	Canvas can;
	Toolkit kit;
	JLabel la_title;
	JPanel p_south;
	JButton bt_prev,bt_next;

	int index=0; //몇 번째 사진을 보여줄지를 정하는, List의 인덱스 변수.
	Image img;

	public Gallery(){
		super("화랑");

		kit=Toolkit.getDefaultToolkit();

		/*Image객체 7개를 만들어 list에 채워넣기.*/
		for(int i=0;i<filename.length;i++){
			Image img1=kit.getImage(dir+filename[i]);
			list.add(img1);
		}
		System.out.println("준비된 사진은 총 "+list.size()+"장입니다.");

		la_title=new JLabel("");
		img=list.get(index); //당장 보여질 이미지.

		bt_prev=new JButton("이전");
		bt_next=new JButton("다음");
		p_south=new JPanel();

		can=new Canvas(){
			public void paint(Graphics g){
				g.drawImage(img,0,0,500,340,can);
			}
		};
		/*--------------------【리스너 영역】-----------------------*/
		bt_prev.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				prev();
			}
		});
		bt_next.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				next();
			}
		});
		/*-----------------------------------------------------*/
		la_title.setPreferredSize(new Dimension(500,40));
		p_south.add(bt_prev);
		p_south.add(bt_next);

		setTitle();
		add(la_title,BorderLayout.NORTH);
		add(can);
		add(p_south,BorderLayout.SOUTH);
		setBounds(500,150,500,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void setTitle(){
		la_title.setText(filename[index]);
	}
	public void prev(){
		if(index>0){
			index--;
			img=list.get(index);
			setTitle();
			can.repaint(); //Canvas의 paint를 다시 그리게 해야 함.
		}else{
			JOptionPane.showMessageDialog(this,"첫 번째 사진입니다.");
		}
	}
	public void next(){
		if(index<list.size()-1){
			index++;
			img=list.get(index);
			setTitle();
			can.repaint();
		}else{
			JOptionPane.showMessageDialog(this,"마지막 사진입니다.");
		}
	}
	public static void main(String[] args){
		new Gallery();
	}
}