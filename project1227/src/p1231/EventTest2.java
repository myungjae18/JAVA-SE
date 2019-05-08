/*�ڹٿ����� �̺�Ʈ ���α׷����� 3�ܰ� �۾�
1)������ �����ʸ� �����Ѵ� (ex)��ư�� click�� ��︰��)
2)�ش� �������� �߻�޼��带 �������Ѵ�(�ϰ������)
3)�̺�Ʈ�� ����Ų ������Ʈ(�̺�Ʈ �ҽ�)�� �����ʿ� ����(ex)bt.addActionListener(������ ��ü))
*/

package p1231;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//�����ʰ� �߻����� �������̽��� ����
/*�̺�Ʈ�� �߻����� ��, � ������ ���������� sun�簡 �����ϴ� �� �ƴ϶�,
������ �����ϴ� ���̱� ������... �� ������ Ȯ������ �� ����... 
���� �ҿ����� �߻�޼��带 ���������Ѵ�..*/

class EventTest2 extends JFrame implements ActionListener, KeyListener, ItemListener{//���� �� ������ �ڷ����̴�
	public static final int WIDTH=300; //���α��� ��� ����...
	public static final int HEIGHT=400;
	JTextField t_txt;
	JButton bt1,bt2;
	Choice choiceFruit;
	public EventTest2(){
		t_txt=new JTextField(20);
		bt1=new JButton("��ư1");
		bt2=new JButton("��ư2");
		choiceFruit=new Choice();
		choiceFruit.add("apple");
		choiceFruit.add("strawberry");
		choiceFruit.add("grapes");
		
		setLayout(new FlowLayout());
		add(t_txt);
		add(bt1);
		add(bt2);
		add(choiceFruit);
		
		//��ư�� �����ʿ��� ����
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		t_txt.addKeyListener(this);
		choiceFruit.addItemListener(this);

		/*����� ���α׷��� ���� ������ �� ���� ������ �ʰ� ���� �� �����Ǵ� ������ �����͸� ���ϴµ�,
		Ư�� ���� �� �����Ϳ� �ǹ̸� �ο��ϴ� ��찡 ����...
		������ �����ϱ� ���ؼ� ���� �빮�ڷ� �����Ѵ�(�����ڵ� �� ���)*/
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(WIDTH,HEIGHT);
		setVisible(true);
	}

	//�������̵�
	public void actionPerformed(ActionEvent e){
		/*�ڹٽ�ũ��Ʈ�� ����������, �׼��̺�Ʈ�� �� ��ư���� �� �� �ִ� ���� �ƴϹǷ�,
		��ȯ�Ǵ� �̺�Ʈ �ҽ��� ������ ��ư�� ���� ����.. 
		���� ������ �Ұ����ϱ� ������ ��ȯ���� sun�翡���� Object�� �޾� ���ȴ�..*/
		Object obj=e.getSource();
		JButton btn=(JButton)obj; //�ٿ��ɽ���

		//bt1, bt2�� btn�� ������
		if(btn==bt1){
			System.out.println("bt1�� ������");
		}else if(btn.equals(bt2)){
			System.out.println("bt2�� ������..");
		}
	}

	public void itemStateChanged(ItemEvent e){
		String item=choiceFruit.getSelectedItem();
		System.out.println(item);
	}

	//�������̵�
	2
	public static void main(String[] args){
		new EventTest2();
	}
}
