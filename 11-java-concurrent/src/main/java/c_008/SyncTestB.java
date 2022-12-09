package c_008; /**
 * 对比上面一个小程序，分析一下这个程序的输出
 * @author mashibing
 */

public class SyncTestB implements Runnable {

	private int count = 10;
	
	public synchronized void run() { 
		count--;
		System.out.println(Thread.currentThread().getName() + " count = " + count);
	}
	
	public static void main(String[] args) {
		
		for(int i=0; i<5; i++) {
			SyncTestB t = new SyncTestB();
			new Thread(t, "THREAD" + i).start();
		}
	}
	
}
