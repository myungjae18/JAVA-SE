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

//�����̵� ������
class SlideGallery extends JFrame{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Image img;
	String[] labArray=new String[9]; //���� ���� �迭
	JLabel label;
	Canvas can; //���� �ٿ��� ��
	JPanel p_south; //��ư ����
	JButton bt_left; //���� ��ư
	JButton bt_right; //������ ��ư
	
	int index=0; //������ labArray�� ��
	int dex=8; //������ labArray�� ��
				
	public SlideGallery(){
		//labArray�� ���ϸ� �ֱ�
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
		
		//p_south�� ��ư ����
		p_south.add(bt_left);
		p_south.add(bt_right);

		add(label, BorderLayout.NORTH); //label ���̱�
		add(can); //can ���̱�
		add(p_south, BorderLayout.SOUTH); //p_south ���̱�
				
		//System.out.println(labArray[0]);
		
		//���� ��ư�� ��� ����
		bt_right.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(index==8){
					JOptionPane.showMessageDialog(label,"��");
				}else{
					img=kit.getImage(labArray[index++]);
					can.repaint(); //�ٽ� ������
					label.setText(labArray[index]);
				}
			}
		});
		
		//������ ��ư�� ��� ����
		bt_left.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(index==0){
					JOptionPane.showMessageDialog(label,"��");
				}else{
					img=kit.getImage(labArray[dex--]);
					can.repaint(); //�ٽ� ������
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
