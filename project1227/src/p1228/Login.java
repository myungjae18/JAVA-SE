package p1228;
import java.awt.*;

class Login{
	public static void main(String[] args){
		Frame frame=new Frame();//������â �����
		Panel pTop=new Panel();//���κ� ������ �г� ����
		Panel pBottom=new Panel();//�Ʒ� �κ� ������ �г� ����
		Label lbId=new Label("id");//pTop�� id��
		TextField tfId=new TextField();//pTop�� id�ؽ�Ʈ
		Label lbPw=new Label("password");//pTop�� pw��
		TextField tfPw=new TextField();//pTop�� pw�ؽ�Ʈ
		Button btLogin=new Button("�α���");//pBottom�� �α��ι�ư
		Button btRegist=new Button("����");//pBottom�� ���Թ�ư
		BorderLayout border=new BorderLayout();//BorderLayout ����
		Dimension dTf=new Dimension(70,20);//TextField ������ ����
		Dimension dLb=new Dimension(20,20);//Label ������ ����
		frame.setLayout(border); //��ġ������ ����

		//tfId�� tfPw�� ������ ����
		lbId.setPreferredSize(dLb);
		tfId.setPreferredSize(dTf);
		lbPw.setPreferredSize(dTf);
		tfPw.setPreferredSize(dTf);

		//TextField�� Label�� pTop�� ����
		pTop.add(lbId);
		pTop.add(tfId);
		pTop.add(lbPw);
		pTop.add(tfPw);

		//��ư�� pBottom�� ����
		pBottom.add(btLogin);
		pBottom.add(btRegist);
				
		//�� �г��� �����ӿ� ����
		frame.add(pTop, BorderLayout.NORTH);
		frame.add(pBottom, BorderLayout.SOUTH);

		//�������� ���̰� ����
		frame.setVisible(true);
		frame.setSize(300,120);
	}
}
