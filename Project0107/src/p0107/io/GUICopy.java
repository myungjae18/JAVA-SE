package p0107.io;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUICopy extends JFrame implements ActionListener{
	JPanel p_center,p_south;
	JTextField t_origin, t_dest;
	JButton bt;
	FileInputStream fis;
	FileOutputStream fos;
	public GUICopy() {
		// TODO Auto-generated constructor stub
		p_center=new JPanel();
		p_south=new JPanel();
		t_origin=new JTextField(50);
		t_dest=new JTextField(50);
		bt=new JButton("copy");
		
		p_center.add(t_origin);
		p_center.add(t_dest);
		
		p_south.add(bt);
		
		add(p_center);
		add(p_south, BorderLayout.SOUTH);
		
		bt.addActionListener(this);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//Ȥ���� ��Ʈ���� ���� �ʾҴٸ� ���⼭ �ݾƾ� �Ѵ�
				//���μ��� ���̱�
				System.exit(0);
			}
		});
		
		setSize(600,140);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			copy();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	//���� ����
	public void copy() throws IOException {
		//ù��° textfield�� ���� �����ϴ� ������ ������� �Է½�Ʈ�� ����
		String origin_path=t_origin.getText();
		String dest_path=t_dest.getText();
		try {
			fis=new FileInputStream(new File(origin_path));
			fos=new FileOutputStream(new File(dest_path));
			
			int data=-1;
			while(true) {
				data=fis.read(); //1byte �о����
				if(data==-1)break;
				fos.write(data);
			}
			JOptionPane.showMessageDialog(this,"����Ϸ�");
		}finally {
			if(fis!=null) {
				fis.close();
			}
			if(fos!=null) {
				fos.close();
			}
		}	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUICopy();
	}

}
