/**
 * 有N张火车票，每张票都有一个编号
 * 同时有10个窗口对外售票
 * 请写一个模拟程序
 * 
 * 分析下面的程序可能会产生哪些问题？
 *  
 * 使用Vector或者Collections.synchronizedXXX
 * 分析一下，这样能解决问题吗？
 * 
 * @author 马士兵
 */
package c_024_ticket_seller;

import java.util.Vector;
import java.util.concurrent.TimeUnit;
/**
 * 换了一个容器Vector,Vector加了synchronized锁。
 * 但是还是有问题，因为判断和操作分离了
 * ticket.size()是原子性的，ticket.remove是原子性的
 * 但是两个原子性的中间是有可能被打断的。。
 */
public class TicketSeller2 {
	static Vector<String> tickets = new Vector<>();
	
	
	static {
		for(int i=0; i<1000; i++) tickets.add("票 编号：" + i);
	}
	
	public static void main(String[] args) {
		
		for(int i=0; i<10; i++) {
			new Thread(()->{
				while(tickets.size() > 0) {
					
					try {
						TimeUnit.MILLISECONDS.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					
					System.out.println("销售了--" + tickets.remove(0));
				}
			}).start();
		}
	}
}
