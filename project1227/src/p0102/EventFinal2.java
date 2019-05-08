/*---------------------
이벤트프로그램 작성철차.
1. 적절한 리스터 선택.
2. 오버라이드.
 - 오버라이드 대상 메서드가 너무 많을 경우, 쓰지도 않는 메서드를
   개발자가 일일이 코딩하는 것은 비합리적임.
 - 해결책: sun社에서는 개발자 대신 인터페이스를 구현한 객체를
   지원한다.(Adapter 클래스: KeyAdapter, WindowAdapter...)
   재정의할 메서드가 3개 이상이면, Adapter 지원 여부를 의심하자.
-----------------------*/

package p0102;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*오만가지 이벤트를 감지하는 클래스 정의.*/
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

		txt.addKeyListener(mka); //mka가 귀를 갖고 있다.
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
			JOptionPane.showMessageDialog(this,"Tessio, Clemenza, Pentangeli 중 한 명을 동원하십시오.");
		}else if(bt==bt2){
			JOptionPane.showMessageDialog(this,"Abbandando, Hagen 중 한 명을 동원하십시오.");
		}
	}
	public void itemStateChanged(ItemEvent i){
		JOptionPane.showMessageDialog(this,ch.getSelectedItem()+"을(를) 선택하셨습니다.");
	}
/*	public void windowActivated(WindowEvent w){
		System.out.println("windowActivated: 활성 창.");
	}
	public void windowClosed(WindowEvent w){
		System.out.println("windowClosed: 창이 닫힌 상태.");
	}
	public void windowClosing(WindowEvent w){
		System.out.println("windowClosing: 창 닫기.");
	}
	public void windowDeactivated(WindowEvent w){
		System.out.println("windowDeactivated: 비활성 창.");
	}
	public void windowDeiconified(WindowEvent w){
		System.out.println("windowDeiconified: 최소화된 창 복원.");
	}
	public void windowIconified(WindowEvent w){
		System.out.println("windowIconified: 창 최소화.");
	}
	public void windowOpened(WindowEvent w){
		System.out.println("windowOpened: 창 열림.");
	}*/
	public static void main(String[] args){
		new EventFinal();
	}
}
