package p0109.thread;

public class MyThread2 extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(1000); //1�ʰ� non-runnable
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			System.out.println("�޷�");
		}
	}	
}
