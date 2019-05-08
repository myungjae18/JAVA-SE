package p1231;
import java.awt.*;
import javax.swing.*;
//자바로 메모장 디자인 따라하기

class MemoEditor extends JFrame{
	JMenuBar bar; //메뉴들이 얹혀질 바
	JMenu m_file, m_edit, m_font, m_view, m_help;
	JMenuItem item_new, item_open, item_exit;
	JTextArea area;
	JScrollPane scroll;
	
	public MemoEditor(){
		//생성자 호출
		super("제목 없음");       
		bar=new JMenuBar();
		m_file=new JMenu("파일");
		m_edit=new JMenu("편집");
		m_font=new JMenu("서식");
		m_view=new JMenu("보기");
		m_help=new JMenu("도움말");
		item_new=new JMenuItem("새파일");
		item_open=new JMenuItem("열기");
		item_exit=new JMenuItem("나가기");
		area=new JTextArea();
		scroll=new JScrollPane(area); //스크롤을 달고 싶은 대상 컴포넌트를 인수로 넣는다.. java API 개발자의 정의	
		
		//bar 부착
		setJMenuBar(bar);
		
		//bar에 menu 부착
		bar.add(m_file);
		bar.add(m_edit);
		bar.add(m_font);
		bar.add(m_view);
		bar.add(m_help);

		//m_file에 menuItem 부착
		m_file.add(item_new);
		m_file.add(item_open);
		m_file.add(item_exit);

		//윈도우에 스크롤 부착 - CENTER 위치
		add(scroll);

		//setTitle("제목 없음");

		setSize(600,500);
		setVisible(true);
	}
	public static void main(String[] args){
		new MemoEditor();
	}
}
