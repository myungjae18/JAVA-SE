/*---------------------
�̺�Ʈ���α׷� �ۼ�ö��.
1. ������ ������ ����.
2. �������̵�.
 - �������̵� ��� �޼��尡 �ʹ� ���� ���, ������ �ʴ� �޼��带
   �����ڰ� ������ �ڵ��ϴ� ���� ���ո�����.
 - �ذ�å: sun�信���� ������ ��� �������̽��� ������ ��ü��
   �����Ѵ�.(Adapter Ŭ����: KeyAdapter, WindowAdapter...)
   �������� �޼��尡 3�� �̻��̸�, Adapter ���� ���θ� �ǽ�����.
-----------------------*/

package p0102;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*�������� �̺�Ʈ�� �����ϴ� Ŭ���� ����.*/
class EventFinal extends JFrame implements ActionListener,ItemListener{
	JTextField txt;
	JButton bt1,bt2;
	Choice ch;
	MyKeyAdapter mka;
	MyWindowAdapter mwa;

	public EventFinal(){
		super("Godfather Simulator");

		txt=new JTextField(25);
		bt1=new JButton("Caporegime");
		bt2=new JButton("Consigliere");
		ch=new Choice();
		mka=new MyKeyAdapter();
		mwa=new MyWindowAdapter();

		txt.addKeyListener(mka); //mka�� �͸� ���� �ִ�.
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		ch.addItemListener(this);
		this.addWindowListener(mwa);

		ch.add("Tessio");
		ch.add("Clemenza");
		ch.add("Abbandando");
		ch.add("Petangeli");
		ch.add("Hagen");

		add(txt);
		add(bt1);
		add(bt2);
		add(ch);
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(300,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent a){
		Object bt=a.getSource();
		if(bt==bt1){
			JOptionPane.showMessageDialog(this,"Tessio, Clemenza, Pentangeli �� �� ���� �����Ͻʽÿ�.");
		}else if(bt==bt2){
			JOptionPane.showMessageDialog(this,"Abbandando, Hagen �� �� ���� �����Ͻʽÿ�.");
		}
	}
	public void itemStateChanged(ItemEvent i){
		JOptionPane.showMessageDialog(this,ch.getSelectedItem()+"��(��) �����ϼ̽��ϴ�.");
	}
/*	public void windowActivated(WindowEvent w){
		System.out.println("windowActivated: Ȱ�� â.");
	}
	public void windowClosed(WindowEvent w){
		System.out.println("windowClosed: â�� ���� ����.");
	}
	public void windowClosing(WindowEvent w){
		System.out.println("windowClosing: â �ݱ�.");
	}
	public void windowDeactivated(WindowEvent w){
		System.out.println("windowDeactivated: ��Ȱ�� â.");
	}
	public void windowDeiconified(WindowEvent w){
		System.out.println("windowDeiconified: �ּ�ȭ�� â ����.");
	}
	public void windowIconified(WindowEvent w){
		System.out.println("windowIconified: â �ּ�ȭ.");
	}
	public void windowOpened(WindowEvent w){
		System.out.println("windowOpened: â ����.");
	}*/
	public static void main(String[] args){
		new EventFinal();
	}
}
