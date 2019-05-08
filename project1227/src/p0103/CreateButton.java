package p0103;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


class CreateButton extends JFrame{
	//만들 것을 미리 생성
	JButton createBt; //생성 버튼
	JButton bgBt; //배경 버튼
	JButton bt; //생성되는 버튼
	JPanel topPanel; //버튼 구역의 패널
	JPanel botPanel; //생성되는 버튼 구역의 패널
	public CreateButton(){
		createBt=new JButton("생성");
		bgBt=new JButton("배경");
		topPanel=new JPanel();
		botPanel=new JPanel();

		topPanel.add(createBt); //topPanel에 createBt 추가
		topPanel.add(bgBt); //topPanel에 bgBt 추가

		add(topPanel, BorderLayout.NORTH); //topPanel 추가
		add(botPanel); //botPanel 추가

		//생성 버튼에 리스너 구현
		createBt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				bt=new JButton("버튼");
				botPanel.add(bt);
				botPanel.updateUI();
			}
		});

		//배경 버튼에 리스너 구현
		bgBt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				botPanel.setBackground(new Color (1,2,3));
			}
		});

		setSize(500,600);
		setVisible(true);
	}
	public static void main(String[] args){
		new CreateButton();
	}
}
