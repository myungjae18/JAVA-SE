/*
 * OS : �ϳ��� OS ������ ���� ���μ����� ���ÿ� �����ų �� �ִ� ����� ������ ��Ƽ�½�ŷ�̶� �ϰ�,
 * 			�̹� OS������ �̷��� ����� �����ϱ� ������
 *  		����ڵ��� �ڽ��� ���ϴ� ���α׷��� ������ ���ÿ� �����ų �� �ִ�..
 *  JVM : �ϳ��� ���μ��� ������ ���ÿ� ���������� ����� �� �ִ� ������ �����ϴµ�,
 *  		�̸� ������(Thread)�� �ϸ� �ڹ� ������ �ٸ� ���� ���������� ��Ƽ �������� �����Ѵ�..
 * */
package p0109.thread;

public class ThreadTest {
	//Thread : �ϳ��� ���μ��� ������ ���������� ���� ������ ���� ����
	Thread thread1;
	Thread thread2;
	public ThreadTest() {
		thread1=new MyThread(); //�н� ����
		thread2=new MyThread2();
				
		/*������ ������� �����ڰ� �����ϴ� ���� �ƴ϶�
		������ �ý��ۿ� �ðܾ� �ú��ҷ� �˾Ƽ� ��������ش�.. �� ��Ƽ�½�ŷ�� �����ϴ�*/
		thread1.start();
		thread2.start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreadTest();
	}

}
