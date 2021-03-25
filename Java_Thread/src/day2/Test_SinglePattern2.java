package day2;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * 单例设计模式2-懒汉式
 *
 */
public class Test_SinglePattern2 {
	public static void main(String[] args) {
		MySingle2 single2 = MySingle2.getMySingle2();
		single2.sayHi("Hi");
		ExecutorService pool = Executors.newFixedThreadPool(5);
		for(int i=0; i<5; i++) {
			pool.execute(single2);
		}
		pool.shutdown();
	}
}

class MySingle2 implements Runnable{
	/**和饿汉式的区别,延迟初始化对象*/
	private static MySingle2 single2;
	private static Object o = new Object();
	private static int tickets = 100;
	private MySingle2() {}
	private ReentrantReadWriteLock rrw = new ReentrantReadWriteLock();
	/**
	 * 问题: 程序中有共享资源single,并且有多条语句操作了共享资源
	 * 此时共享资源single会出现多线程数据安全隐患
	 * 解决方法:加锁-同步代码块 OR 同步方法
	 * 锁的位置: 包裹所有操作共享资源的语句
	 * 同步方法,就在方法前面加上synchronized,
	 */
	
	public static MySingle2 getMySingle2() {
		/**当用户调用此方法时候,才初始化对象*/
		/**
		 * 这里不能写synchronized(this)
		 * 因为this是本类的对象的意思,而get方法是静态方法,优先于this加载,所以不能用this关键字
		 * */
		synchronized(o) {
			if(single2 == null) {
				single2 = new MySingle2();
			}
			//single2叫做锁对象
			return single2;
		}
	}
	
	public void sayHi(String s) {
		System.out.println(s);
	}
	@Override
	public void run() {
		while(true) {
			rrw.writeLock().lock();
			try {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tickets --;
				if(tickets < 0) {
					System.out.println("票卖完了");
					break;
				}
				System.out.println(Thread.currentThread().getName()+ "卖票,还剩 " + tickets + "张");
		
			}catch(Exception e){
			e.printStackTrace();
		}finally {
			rrw.writeLock().unlock();
		}
		}
	}
}
