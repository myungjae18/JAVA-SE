//<쓰레드가 동작하게 될 로직을 재정의 하기 위한 클래스>
/*개발자는 독립적으로 수행하고 싶은 코드를 쓰레드의 run 메서드에 작성하면 된다
 * 이 run 메서드를 재정의하면 JVM이 알아서 호출해준다*/
package p0109.thread;

public class MyThread extends Thread{
	int count=0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			count++;
			try {
				Thread.sleep(1000); //1초간 non-runnable
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			System.out.println(count);
		}
	}	
}
