//���� �̷�� �� �г� 1���� �����Ѵ�
package p0103;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyPanel extends JPanel{
	public MyPanel(){
		addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent m){
				JPanel obj=(JPanel)m.getSource();
				obj.setBackground(Color.GREEN);
			}
		});
		setPreferredSize(new Dimension(10,10));
		setBackground(Color.CYAN);
	}
}
