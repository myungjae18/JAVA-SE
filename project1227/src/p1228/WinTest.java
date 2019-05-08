package p1228;
import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.Button;
public class WinTest{
	/*
	������Ʈ�� ����ϱ⿡ �ռ�, ���� ��ġ�� �����ؾ� ���ϴ� ȭ�� ������ ����� ���´�
	������ ���α׷��� �� �� �������α׷����� �����ϴ� ��ġ����� �ִµ�,
	�ڹٿ����� LayoutMananger��� Ŭ������ �� ������ �����Ѵ�
	LayoutManager�� ����...
	1)BorderLayout : ��,��,��,��,�߾��̶�� ������ ���� ��ġ������
	
	2)FlowLayout : ����, ���� �������� ������Ʈ�� ��ġ�� �� �ִ� ��ġ������
	
	3)GridLayout : ���������� ��ġ�� �����ϴ� ��ġ������
	
	4)GridBagLayout : ��ǥ�� �����ϴ� ��ġ������
	
	5)CardLayout : �� ȭ�鿡 �� ������ ������Ʈ�� �����ִ� ��ġ������
	*/
	public static void main(String[] args){
		//������Ʈ�� �����쿡 �÷����� ���� ��ġ ����� ��������
		/*�ڹ��� �������� ������ �ϸ� �����̳����� ��� ��ġ�����ڸ� ������ �� �ִ�..
		�̶� ���Ǵ� �޼��尡 setLayout() �޼����̴�..*/
		//Frame is a Container�� �翬�� �����ȴ�
		Frame frame=new Frame();
		BorderLayout border=new BorderLayout();
		frame.setLayout(border); //��ġ������ ����
		//��ư 5���� �����Ͽ� �� ������ �ٿ�����
		Button bt_north=new Button("����");
		Button bt_west=new Button("����");
		Button bt_east=new Button("����");
		Button bt_south=new Button("����");
		Button bt_center=new Button("�߾�");

		//�� ������ �°� ��ư ����
		//������ �������� ������ ����Ʈ�� CENTER�̴�
		//frame.add(bt_north,BorderLayout.NORTH);
		frame.add(bt_west,BorderLayout.WEST);
		frame.add(bt_east,BorderLayout.EAST);
		frame.add(bt_south,BorderLayout.SOUTH);
		frame.add(bt_center,BorderLayout.CENTER);
		
		//������� ����Ʈ�� ���� �Ӽ�
		frame.setVisible(true);
		frame.setSize(500,500);

	
	}
}
