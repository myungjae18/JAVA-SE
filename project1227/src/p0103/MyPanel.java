//셀을 이루게 될 패널 1개를 정의한다
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
