package p1231;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

//�ؽ�Ʈ�ڽ��� ��ư�� �ִ� ������ ������ â�� �����..
class BoxTest extends JFrame{
	JPanel panelTop; //���� �г�
	JPanel panelBottom; //�Ʒ��� �г�
	JTextField textFieldTop; //���� �ؽ�Ʈ�ڽ�
	JTextField textFieldBottom; //�Ʒ��� �ؽ�Ʈ�ڽ�
	JButton bt; //��ư
	public BoxTest(){
		panelTop=new JPanel(); //���� �г� ȣ��	
		panelBottom=new JPanel();	//�Ʒ��� �г� ȣ��
		textFieldTop=new JTextField(); //���� �ؽ�Ʈ�ڽ� ȣ��
		textFieldBottom=new JTextField(); //�Ʒ��� �ؽ�Ʈ�ڽ� ȣ��
		bt=new JButton("�α���"); //��ư ȣ��

		panelTop.setLayout(new BorderLayout()); //panelTop�� ��ġ������ ����
		panelTop.setSize(300,80); //panelTop�� ������ ���ϱ�
		panelTop.add(textFieldTop); //panelTop�� textFieldTop ����
		panelTop.add(textFieldBottom, BorderLayout.SOUTH); //panelTop�� textFieldBottom ����
		
		panelBottom.setLayout(new BorderLayout()); //panelBottom�� ��ġ������ ����
		panelBottom.setSize(300,40); //panelBottom�� ������ ���ϱ�
		panelBottom.add(bt); //panelBottom�� bt ����

		
		add(panelTop, BorderLayout.NORTH); //�����쿡 panelTop ����
		add(panelBottom, BorderLayout.SOUTH); //�����쿡 panelBottom ����

		setVisible(true); //������â ���̰� �����
		setSize(300,120); //������â�� ũ�� ����
	}
	public static void main(String[] args){
		new BoxTest();
	}
}
