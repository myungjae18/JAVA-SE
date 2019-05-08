package p0103;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


class CreateButton extends JFrame{
	//���� ���� �̸� ����
	JButton createBt; //���� ��ư
	JButton bgBt; //��� ��ư
	JButton bt; //�����Ǵ� ��ư
	JPanel topPanel; //��ư ������ �г�
	JPanel botPanel; //�����Ǵ� ��ư ������ �г�
	public CreateButton(){
		createBt=new JButton("����");
		bgBt=new JButton("���");
		topPanel=new JPanel();
		botPanel=new JPanel();

		topPanel.add(createBt); //topPanel�� createBt �߰�
		topPanel.add(bgBt); //topPanel�� bgBt �߰�

		add(topPanel, BorderLayout.NORTH); //topPanel �߰�
		add(botPanel); //botPanel �߰�

		//���� ��ư�� ������ ����
		createBt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				bt=new JButton("��ư");
				botPanel.add(bt);
				botPanel.updateUI();
			}
		});

		//��� ��ư�� ������ ����
		bgBt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				botPanel.setBackground(new Color (1,2,3));
			}
		});

		setSize(500,600);
		setVisible(true);
	}
	public static void main(String[] args){
		new CreateButton();
	}
}
