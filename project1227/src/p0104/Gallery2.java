package p0104;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

class Gallery extends JFrame{
	String dir="C:/Users/itbank/Desktop/������_�����ڷ�/java_developer/java/190104_day12/src/shurek/";
	String[] filename={
		"img0.jpg",
		"img1.jpg",
		"img2.jpg",
		"img3.jpg",
		"img4.jpg",
		"img5.jpg",
		"img6.jpg"
	};
	List<Image> list=new ArrayList(); // <> �ȿ� ����� ������ ������.
	Canvas can;
	Toolkit kit;
	JLabel la_title;
	JPanel p_south;
	JButton bt_prev,bt_next;

	int index=0; //�� ��° ������ ���������� ���ϴ�, List�� �ε��� ����.
	Image img;

	public Gallery(){
		super("ȭ��");

		kit=Toolkit.getDefaultToolkit();

		/*Image��ü 7���� ����� list�� ä���ֱ�.*/
		for(int i=0;i<filename.length;i++){
			Image img1=kit.getImage(dir+filename[i]);
			list.add(img1);
		}
		System.out.println("�غ�� ������ �� "+list.size()+"���Դϴ�.");

		la_title=new JLabel("");
		img=list.get(index); //���� ������ �̹���.

		bt_prev=new JButton("����");
		bt_next=new JButton("����");
		p_south=new JPanel();

		can=new Canvas(){
			public void paint(Graphics g){
				g.drawImage(img,0,0,500,340,can);
			}
		};
		/*--------------------�������� ������-----------------------*/
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
			can.repaint(); //Canvas�� paint�� �ٽ� �׸��� �ؾ� ��.
		}else{
			JOptionPane.showMessageDialog(this,"ù ��° �����Դϴ�.");
		}
	}
	public void next(){
		if(index<list.size()-1){
			index++;
			img=list.get(index);
			setTitle();
			can.repaint();
		}else{
			JOptionPane.showMessageDialog(this,"������ �����Դϴ�.");
		}
	}
	public static void main(String[] args){
		new Gallery();
	}
}