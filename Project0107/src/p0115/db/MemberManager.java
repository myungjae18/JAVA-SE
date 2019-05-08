package p0115.db;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class MemberManager extends JFrame{
	JMenuBar bar;
	JMenu[] menu=new JMenu[3];
	JPanel p_center; //다른 패널들이 대체될 공간
	JPanel[] pages=new JPanel[3];
	
	public MemberManager() {
		bar=new JMenuBar();
		menu[0]=new JMenu("회원가입");
		menu[1]=new JMenu("회원목록");
		menu[2]=new JMenu("일정표");
		p_center=new JPanel();
		
		//페이지 구성하기
		pages[0]=new RegistMember();
		pages[1]=new MemberList();
		pages[2]=new Diary();
		
		p_center.add(pages[0]);
		p_center.add(pages[1]);
		p_center.add(pages[2]);
		
		bar.add(menu[0]);
		bar.add(menu[1]);
		bar.add(menu[2]);
		setJMenuBar(bar);
		
		add(p_center);
		
		for (int i = 0; i < menu.length; i++) {
			menu[i].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					System.out.println("눌럿냐고");
					Object obj=e.getSource();
					if(obj==menu[0]) {
						showPage(0);
					}else if(obj==menu[1]) {
						showPage(1);
					}else if(obj==menu[2]) {
						showPage(2);
					}
				}
			});
		}
		
		setLocationRelativeTo(null); //윈도우창 화면 중앙으로
		setSize(800,450);
		setVisible(true);
	}
	public void showPage(int page) {
		System.out.println(page+1+" 페이지를 원하냐");
		for (int i = 0; i < pages.length; i++) {
			if(i==page) {
				pages[i].setVisible(true);
			}else {	
				pages[i].setVisible(false);
			}
		}

	}
	public static void main(String[] args) {
		new MemberManager();
	}
}	
