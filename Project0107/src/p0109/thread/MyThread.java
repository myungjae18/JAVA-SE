//<�����尡 �����ϰ� �� ������ ������ �ϱ� ���� Ŭ����>
/*�����ڴ� ���������� �����ϰ� ���� �ڵ带 �������� run �޼��忡 �ۼ��ϸ� �ȴ�
 * �� run �޼��带 �������ϸ� JVM�� �˾Ƽ� ȣ�����ش�*/
package p0109.thread;

public class MyThread extends Thread{
	int count=0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			count++;
			try {
				Thread.sleep(1000); //1�ʰ� non-runnable
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			System.out.println(count);
		}
	}	
}
