//��ġ������ �� FlowLayout�� �����Ѵ�
package p1228;
import java.awt.*; //*�� Ŭ�������� ����

class FlowTest{
	public static void main(String[] args){
		/*�����ڰ� �����̳ʿ� �ƹ��� ��ġ�����ڸ� �������� ���ϸ� ����Ʈ ��ġ�����ڰ� ����Ǵµ�,
		Frame�� ��쿣 BorderLayout�� ����ȴ�.*/
		Frame frame=new Frame();
		
		//��ġ�����ڸ� ����Ʈ�� �ƴ�, �츮�� ���ϴ� ������ ��������
		FlowLayout flow=new FlowLayout();
		/*FlowLayout�� Ư¡ : 
		1)����, ���� �������� �귯�ٴѴ�(��ġ�� �������� ����)
		2)������Ʈ ������ ũ�⸦ ������ �� �ִ�*/
		frame.setLayout(flow); //�÷ο� ����
		for(int i=1; i<=20;i++){
			frame.add(new Button("��"+i+"��ư"));
		}

		frame.setVisible(true);
		frame.setSize(300,400);
	}
}
