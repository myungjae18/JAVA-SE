package p0103;
import javax.swing.*;
import java.awt.event.*;

class Test extends JFrame{
	JButton[] bt=new JButton[50];
	public Test(){
		/*
		�̺�Ʈ ���� �ڵ�� ������ �ƴ϶� �̺�Ʈ �߻� �� �����ڰ� ���ϴ� ������ ȣ�����ִ� �ܼ� ������ �ϰ� ��Ȱ�뼺�� ��������.
		�ֳ��ϸ� �� Ŭ������ �ƴ� �ٸ� Ŭ�������� ������ �� ���� �����̴�..
		�̷� ��쿡�� �����ڰ� .java�� ���� �̺�Ʈ�� ó���ؾ� �ϴ°�? no
		*/
		setLayout(new java.awt.FlowLayout());

		//final int a=8; ���� �͸� Ŭ������ ��������� ������ �� ������ ���������� final�� ����� �͸� ������ �����ϴ�(�� ���� �Ұ���)
		for(int i=0;i<bt.length;i++){
			bt[i]=new JButton(i+"��");
			//�����͸�Ŭ����(Anoymous Inner Class)
			//�����͸�Ŭ������ �ڽ��� �����ϰ� �ִ� �ش� Ŭ������ ��������� ������ �� �ִ�
			bt[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//a=2; ->�����Ϸ��� �����Ƿ� ���� �߻�
					//System.out.println(a); ->���� ����
					Object obj=e.getSource(); //�̺�Ʈ�� ����Ų ��ü�� �Ǵ� ������Ʈ�� ���۷����� ��� �޼���
					JButton btn=(JButton)obj; //�ٿ��ɽ���
					System.out.println(btn.getText());
				}
			});
			add(bt[i]);
		}
		setSize(200,400);
		setVisible(true);
	}
	public static void main(String[] args){
		new Test();
	}
}
