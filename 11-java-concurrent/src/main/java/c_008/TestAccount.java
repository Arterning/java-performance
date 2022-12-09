/**
 * 对业务写方法加锁
 * 对业务读方法不加锁
 * 容易产生脏读问题（dirtyRead）
 */

package c_008;

import java.util.concurrent.TimeUnit;

/**
 * 若加锁代码抛出异常，synchronized锁将被释放，要想不被释放，可以进行catch
 */
public class TestAccount {
	
	public static void main(String[] args) {
		Account account = new Account();
		startThread(()->account.set("zhangsan", 100.0));
		startThread(()->account.set("zhangsan", 100.0));
		startThread(()->account.set("zhangsan", 100.0));
		startThread(()->account.set("zhangsan", 100.0));
		startThread(()->account.set("zhangsan", 100.0));

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(account.getBalance());

	}

	/**
	 * 最好用线程池 然后submit传入一个lambda表达式
	 * 这里为了方便就简单这么弄
	 * @param target
	 */
	public static void startThread(Runnable target) {
		new Thread(target).start();
	}

}
