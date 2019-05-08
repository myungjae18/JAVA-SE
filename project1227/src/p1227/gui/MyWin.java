/*
�ڹٵ� �ٸ� �������α׷��� ���ó��, ������ ����� GUI ���α׷����� �����ȴ�(AWT��� ��Ű������ ����)
*/
package p1227.gui;
import java.awt.Frame;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.TextArea;
import java.awt.Label;
import java.awt.List;
import java.awt.Color;

public class MyWin{
	public static void main(String[] args){
		//GUI ���α׷����� ��� ��ҵ��� ������ �ȿ��� ������ �� �ִ�
		//������� �⺻�� �Ⱥ��̴� �Ӽ��̱� ������ ���̰� �����ؾ� �Ѵ�..
		Frame frame=new Frame();//null ����
		frame.setVisible(true);
		//�ʺ�, ����
		frame.setSize(500,500);

		//�ڹٵ� �ٸ� �������α׷�ó�� �������� ������Ʈ(��ư,üũ�ڽ�,����,select...)�� ����
		Button bt=new Button("��ư�̴�");
		
		//��ư�� ��������
		//ȭ���� ���� �޿�� ��ư�� ������ �ʰ� �Ϸ��� �����ڰ� ���̾ƿ� �� �˸´� ��ġ�� �����ؾ� �Ѵ�. �ƹ��͵� ������� ������ ����Ʈ ��ġ�� �ǹǷ�
		frame.setLayout(new FlowLayout());
		//�Ҿƹ����� Container�� add�� �����ϰ� �ִ�
		frame.add(bt);
		TextField tf=new TextField(20);
		frame.add(tf);
		Checkbox cb1=new Checkbox();
		Checkbox cb2=new Checkbox();
		frame.add(cb1);
		frame.add(cb2);
		
		//���� �ڽ� ���� (Radiobox�� ������ �ڷ����� ����, ��� üũ�ڽ� �׷��� �̿��Ѵ�..)
		CheckboxGroup group=new CheckboxGroup();
		
		Checkbox g1=new Checkbox("��", false,group);
		Checkbox g2=new Checkbox("��", false,group);
		frame.add(g1);
		frame.add(g2);
		//html�� ��Ƽ���� �Է��� ������ textbox�� textarea�� �ڹٿ����� ������
		TextArea area=new TextArea(10,15);
		frame.add(area);
		//�۾� �ֱ�
		Label la=new Label("���׳� �۾���");
		frame.add(la);
		//list = javascript�� selectbox�� ������
		List list=new List(1);
		list.add("����");
		list.add("�ݼ�");
		list.add("����");
		list.add("ȭ��");
		list.add("��");
		list.add("�伺");
		list.add("õ�ռ�");
		list.add("�ؿռ�");
		list.add("��ռ�");

		frame.add(list);
		//API�� ���� �̼������� ������ �����ǰ� �ִ�.. ��� ���� �� ������ ���� �����Ƿ� API�� Ȱ���ϴ� ������� �ذ��Ѵ�..
		/*API Ȱ���ϴ� ���
		1)�ش� Ŭ������ ���� �� ������ �ϴ� Ŭ�����ΰ�
		2)����ϴ� ��� ����, Ŭ������ �ᱹ ����ϵ��� ������� ���̴�.
		����Ϸ��� �޸𸮿� �ø��� ����� �˾ƾ� �Ѵ�. ��� ��ü�� �� new�� �޸𸮿� �ø� �� �ִ� ���� �ƴϴ�.
		-�޸𸮿� �ø��� ���
		1.�Ϲ� Ŭ���� new
		2.�߻� Ŭ������ new �Ұ�->�ڽ��� new 
		3.�������̽��� new �Ұ�->�ڽ��� new
		*/
		/*
		Color�� ���� �����
		Red		Green	Blue
		0~255	0~255	0~255 
		*/
		Color c=new Color(0,0,0);
		bt.setBackground(c);
		//������ RGB�� �ƴ� �ΰ����� �� ģ���� ����� ����ϴ� ���
		bt.setForeground(Color.YELLOW);
		
	}
}
