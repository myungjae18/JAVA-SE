/*
 * OS : 하나의 OS 내에서 여러 프로세스를 동시에 실행시킬 수 있는 기능을 가리켜 멀티태스킹이라 하고,
 * 			이미 OS에서는 이러한 기능을 지원하기 때문에
 *  		사용자들은 자신이 원하는 프로그램을 마음껏 동시에 실행시킬 수 있다..
 *  JVM : 하나의 프로세스 내에서 동시에 독립적으로 실행될 수 있는 단위를 지원하는데,
 *  		이를 쓰레드(Thread)라 하며 자바 언어에서는 다른 언어와 마찬가지로 멀티 쓰레딩을 지원한다..
 * */
package p0109.thread;

public class ThreadTest {
	//Thread : 하나의 프로세스 내에서 독립적으로 실행 가능한 수행 단위
	Thread thread1;
	Thread thread2;
	public ThreadTest() {
		thread1=new MyThread(); //분신 생성
		thread2=new MyThread2();
				
		/*생성된 쓰레드는 개발자가 관리하는 것이 아니라
		무조건 시스템에 맡겨야 시분할로 알아서 실행시켜준다.. 즉 멀티태스킹이 가능하다*/
		thread1.start();
		thread2.start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreadTest();
	}

}
