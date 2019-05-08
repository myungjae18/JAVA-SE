package p0103;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class BtChange extends JFrame{
	JPanel p_north, p_center;
	JButton bt_create, bt_bg;

	//�ڹٿ��� �迭�� ��ü���
	/*
	-�ڹٿ����� �迭 ����� ������
	�ڹٻӸ� �ƴ϶�, C#, C, C++ �� ��κ��� ������ ��� ������ �迭�� ũ�Ⱑ ������ ������ �����Ǿ� �־�� �Ѵ�..
	�� ������ ���� �ݵ�� �� ũ�⸦ ����ؾ� �Ѵ�(�ڹٽ�ũ��Ʈ�ʹ� ���� Ʋ��)
	*/
	JButton[] btn=new JButton[10];
	int index=0;

	/*
	java util ��Ű������ ��ü�� ��Ƽ� ó���ϴµ� ������ ���̺귯���� �����Ǵµ�,
	�� ���̺귯���� ������ collection framework�̶� �Ѵ�.
	�迭�� �ݺ����� �Բ� ����ϱ⿡ �����Ͽ����� ���� �� �� ũ�⸦ ����ؾ� �ϴ� ���������� ���߿� �������� �ʷ��Ѵ�.
	->�ذ�å : �÷��� �����ӿ��� ������ ��ü�� ���ִ� ����� ���� ũ�� 3���� �������� �и��Ѵ�
	1) List : ��ü�� �����ְ� ���ִ� ����� ó���� �� �ִ� API�� �迭�� ���� ���������
	1.List�� ũ�⿡ ���� ��ø� �������� �ʰ�,
	2.�⺻�ڷ������� �����ϴ� �迭�� �޸� �÷��� �����ӿ��� ����� ���� ��ü���� ������� �Ѵ�.
	2) Set : ��ü�� ������ ������ �ʰ� ���ִ� ����� ó���� �� �ִ� API
	3) Map : key-value�� ������ ��ü�� ��Ƴ��� ó���� �� �ִ� API
	*/
	ArrayList list=new ArrayList(); //List �迭 -> ������ ������

	public BtChange(){
		p_north=new JPanel();
		p_center=new JPanel();
		bt_create=new JButton("����");
		bt_bg=new JButton("���");

		p_north.add(bt_bg);
		p_north.add(bt_create);
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		bt_create.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JButton bt=new JButton("����ư");
				p_center.add(bt);
				//btn[index++ ]=bt;
				list.add(bt);
				System.out.println("��� �� ũ��� "+list.size());
				p_center.updateUI(); //�ٽ� ������
			}
		});
		
		bt_bg.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//������ ��� ��ư�� ������� ��� ����
				for(int i=0;i<list.size();i++){
					//���� �� ������ Object������ Upcasting�Ǿ� ����
					JButton b=(JButton)list.get(i);
					b.setBackground(Color.YELLOW);
				}
			}
		});

		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		//�ڹٿ����� �迭�� �� ��ü�̴� (new �����ڷ� �����͸� �����ϸ� heap�� �ν��Ͻ� �����ȴ�. ���� arr ������ ���۷��� �����̴�)
		int[] arr=new int[5];
		//System.out.println(arr[1]);
		new BtChange();
	}
}
