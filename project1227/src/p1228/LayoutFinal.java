/*�� ��ġ�����ڸ��� Ư���� �ֱ� ������ ���� �� ������ �����ؼ� ����ؾ� ������,
�� �����̳� �� �� ������ ��ü�����ڸ� ������ �ȴ�
awt���� �����ϴ� �����̳ʵ��� ��ġ�� ������ ����� �� �ְ�,
�� �����̳ʸ��� ������ ��ġ�����ڸ� �����ڰ� ������ �� �ִµ�,
���� ��ġ�����ڸ� �������� ������ ����Ʈ ��ġ�����ڰ� ����ȴ�...
->Frame : BorderLayout
->Panel : FlowLayout
Panel�̶� ������ó�� �������� �����̳ʰ� �ƴ϶�
�ݵ�� ������ �ȿ����� �Ҽӵ� �� �ִ� ���� �Ը��� �����̳��̴�.
div�� ����� ����Ͽ� ������ �ȿ����� ���� ȭ�� ���ҿ� �ַ� ���ȴ�.
*/
package p1228;
import java.awt.*;

class LayoutFinal{
	public static void main(String[] args){
		Frame frame=new Frame();
		Panel panel=new Panel();
		Button bt1=new Button("��");
		Button bt2=new Button("��");

		frame.add(bt1, BorderLayout.NORTH);
		panel.add(bt2); //���ڿ� ��ư ����
		//�г��� �̹� FlowLayout�̹Ƿ� �ƹ��͵� �� �ʿ䰡 ����
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(600,400);
	}
}
