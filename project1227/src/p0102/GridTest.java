/*
�ڹ��� ��� GUI ������Ʈ�� ũ�� 2���� �������� ������
1)Container ��
	-Frame(������) : BorderLayout
	, Panel(������) : FlowLayout
2)�Ϲ� ������Ʈ ��
*/
//��ġ������ �� �׸��� ����� �����ϴ� GridLayout�� ����غ���
package p0102;
import javax.swing.*;
import java.awt.*;

class GridTest extends JFrame{
	JButton[] btn=new JButton[18]; //������ ����

	public GridTest(){
		//��ư�� �����ϱ� ���� ���̾ƿ��� ��������
		setLayout(new GridLayout(6,3));
		for(int i=0; i<btn.length;i++){
			btn[i]=new JButton("��ư"+i);
			add(btn[i]);
		}
		setSize(500,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		new GridTest();
	}
}
