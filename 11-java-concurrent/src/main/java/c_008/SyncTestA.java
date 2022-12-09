package c_008;

/**
 * synchronized关键字
 * 对某个对象加锁
 * @author mashibing
 */

public class SyncTestA {
	
	private int count = 10;
	private static int staticCount = 100;

	private Object o = new Object();
	
	public void aa() {
		synchronized(o) { //任何线程要执行下面的代码，必须先拿到o的锁
			count--;
			System.out.println(Thread.currentThread().getName() + " count = " + count);
		}
	}

	public void bb() {
		synchronized(this) { //任何线程要执行下面的代码，必须先拿到this的锁
			count--;
			System.out.println(Thread.currentThread().getName() + " count = " + count);
		}
	}

	public synchronized void cc() { //等同于在方法的代码执行时要synchronized(this)
		count--;
		System.out.println(Thread.currentThread().getName() + " count = " + count);
	}


	public synchronized static void m() { //这里等同于synchronized(yxxy.c_004.T.class)
		staticCount--;
		System.out.println(Thread.currentThread().getName() + " count = " + staticCount);
	}

	public static void mm() {
		synchronized(SyncTestA.class) { //考虑一下这里写synchronized(this)是否可以？
			staticCount --;
		}
	}

}

