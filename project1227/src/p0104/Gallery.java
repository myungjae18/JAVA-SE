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

//�����̵� ������
class Gallery extends JFrame{
	Toolkit kit=Toolkit.getDefaultToolkit();
	List<Image> list=new ArrayList(); //�̹����� ���� �� �ִ� ����Ʈ ����
	String[] labArray=new String[9]; //���� ���� �迭
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
	Canvas can; //���� �ٿ��� ��
	JPanel p_south; //��ư ����
	JButton bt_left; //���� ��ư
	JButton bt_right; //������ ��ư	
		
	int index=0; //������ labArray�� ��
	int dex=8; //������ labArray�� ��

	Image img; //���� ������ �̹���
				
	public Gallery(){
		//�̹��� ��ü�� 10�� ����� List�� ä���ֱ�
		for(int i=0;i<fileName.length;i++){
			Image img1=kit.getImage(dir+fileName[i]);
			list.add(img1);
		}		
		System.out.println(list.size());

		label=new JLabel("");
		img=list.get(index); //����Ʈ�� ������ �̹���
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
		
		//p_south�� ��ư ����
		p_south.add(bt_left);
		p_south.add(bt_right);
		
		setTitle();
		add(label, BorderLayout.NORTH); //label ���̱�
		add(can); //can ���̱�
		add(p_south, BorderLayout.SOUTH); //p_south ���̱�
				
		//System.out.println(labArray[0]);
		
		//���� ��ư�� ��� ����
		
		
		setSize(600,800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//������ ����Ѵ�
	public void setTitle(){
		label.setText(dir+fileName[index]);
	}
	public void next(){
		if(index<list.size()-1){
			index++;
			img=list.get(index);
			//paint�� �ٽ� �׸����� ����
			can.repaint();
		}else{
			JOptionPane.showMessageDialog(this, "������ �̹���");
		}
	}
	public void prev(){
		if(index>0){
			index--;
			img=list.get(index);
			//paint�� �ٽ� �׸����� ����
			can.repaint();
		}else{
			JOptionPane.showMessageDialog(this, "��");
		}
	}
	public static void main(String[] args){
		new Gallery();
	}
}
