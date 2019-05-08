/*
�̺�Ʈ ���α׷� �ۼ� ����
1.������ Listener ����
2.�������̵�
	-�������̵� ��� �޼��尡 �ʹ� ���� ��� ��������� �ʴ� �޼��带 �����ڰ� �ڵ� �� ������� ���� ���� �ʹ� ���ո����̴�..
	->�ذ�å : sun�翡���� ������ ��� �������̽��� ������ ��ü�� �����ϴµ�, Adapter��� �̸��� ���� Ŭ�����̴�.
	�������� �޼��尡 3�� �̻� �Ǹ� Adapter ���� ���θ� Ȯ���ϸ� �ȴ�.
3.������Ʈ�� Listener���� ����
*/
package p0102;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//�°� ������ �̺�Ʈ�� �����ϴ� Ŭ������ �����Ѵ�
class EventFinal extends JFrame implements ActionListener, ItemListener{
	JTextField txt;
	JButton bt1,bt2;
	Choice ch;
	MyKeyAdapter mk;
	MyWindowAdapter mw;

	public EventFinal(){
		txt=new JTextField(25);
		bt1=new JButton("��ư1");
		bt2=new JButton("��ư2");
		ch=new Choice();
		
		ch.add("�ڹ�");
		ch.add("����Ŭ");
		ch.add("jsp/String");

		setLayout(new FlowLayout());
		add(txt);
		add(bt1);
		add(bt2);
		add(ch);
		txt.addKeyListener(mk=new MyKeyAdapter());
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		ch.addItemListener(this);
		//������ ������ ����
		this.addWindowListener(mw=new MyWindowAdapter());

		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void itemStateChanged(ItemEvent e){}
	public void actionPerformed(ActionEvent e){
		System.out.println("������");
		/*�ڹٽ�ũ��Ʈ�� ����������, �׼��̺�Ʈ�� �� ��ư���� �� �� �ִ� ���� �ƴϹǷ�,
		��ȯ�Ǵ� �̺�Ʈ �ҽ��� ������ ��ư�� ���� ����.. 
		���� ������ �Ұ����ϱ� ������ ��ȯ���� sun�翡���� Object�� �޾� ���ȴ�..*/
		Object obj=e.getSource();
		JButton btn=(JButton)obj; //�ٿ��ɽ���
		
		//bt1, bt2�� btn�� ������
		if(btn==bt1){
			System.out.println("bt1�� ������");
		}else if(btn.equals(bt2)){
			JOptionPane.showMessageDialog(this, "��ư 2�� ������");
		}
	}

	public static void main(String[] args){
		new EventFinal();
	}
}
