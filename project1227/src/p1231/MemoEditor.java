package p1231;
import java.awt.*;
import javax.swing.*;
//�ڹٷ� �޸��� ������ �����ϱ�

class MemoEditor extends JFrame{
	JMenuBar bar; //�޴����� ������ ��
	JMenu m_file, m_edit, m_font, m_view, m_help;
	JMenuItem item_new, item_open, item_exit;
	JTextArea area;
	JScrollPane scroll;
	
	public MemoEditor(){
		//������ ȣ��
		super("���� ����");       
		bar=new JMenuBar();
		m_file=new JMenu("����");
		m_edit=new JMenu("����");
		m_font=new JMenu("����");
		m_view=new JMenu("����");
		m_help=new JMenu("����");
		item_new=new JMenuItem("������");
		item_open=new JMenuItem("����");
		item_exit=new JMenuItem("������");
		area=new JTextArea();
		scroll=new JScrollPane(area); //��ũ���� �ް� ���� ��� ������Ʈ�� �μ��� �ִ´�.. java API �������� ����	
		
		//bar ����
		setJMenuBar(bar);
		
		//bar�� menu ����
		bar.add(m_file);
		bar.add(m_edit);
		bar.add(m_font);
		bar.add(m_view);
		bar.add(m_help);

		//m_file�� menuItem ����
		m_file.add(item_new);
		m_file.add(item_open);
		m_file.add(item_exit);

		//�����쿡 ��ũ�� ���� - CENTER ��ġ
		add(scroll);

		//setTitle("���� ����");

		setSize(600,500);
		setVisible(true);
	}
	public static void main(String[] args){
		new MemoEditor();
	}
}
