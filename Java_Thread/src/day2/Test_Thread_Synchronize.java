package day2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**用于解决多线程安全问题*/
public class Test_Thread_Synchronize implements Runnable{
	private static int tickets = 100;
	/**读写锁, 乐观锁, 主要用于读多写少的场景,读写分开*/
	private static ReentrantReadWriteLock rrw = new ReentrantReadWriteLock(true);
	/**
	 * 多线程中出现数据不安全的前提
	 * 1. 多线程程序
	 * 2. 共享数据
	 * 3. 多条语句同时操作共享数据
	 * 解决方案: 同步锁, synchronized(this){}
	 * 加锁的范围要适中
	 * 
	 * 如果一整个方法都需要同步,则可以写同步方法
	 * 同步方法同一时刻只能被一个对象调用
	 * 语法: synchronized public void run(){}
	 */
	
	@Override
	public void run() {
		
		while(true) {
			/**读写锁读写分开,这是读锁*/
			rrw.writeLock().lock();
			/**同步代码块在同一时间只能由一个线程运行
			 * synchronized同步关键字可以用来修饰方法,称为同步方法,使用的锁对象是this
			 * synchronized同步关键字可以用来修饰代码块,称为同步代码块,使用的锁对象可以任意
			 * 同步的缺点是会降低程序的执行效率，但我们为了保证线程的安全,有些性能是必须要牺牲的
			 * 但是为了性能,加锁的范围需要控制好,比如我们不需要给整个商场加锁,试衣间加锁就可以了
			 */
			
			
			try {
//			synchronized(this) {
				try {
					
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tickets --;
				if(tickets<0) break;
				System.out.println(Thread.currentThread().getName() +"卖票,还剩下 " + tickets + "张票");
			}catch(Exception e) {
			e.printStackTrace();
		}finally {
			rrw.writeLock().unlock();
		}
		//System.out.println("票卖光了");
		}
	}
	
	
	public static void main(String[] args) {
		Test_Thread_Synchronize tts = new Test_Thread_Synchronize();
//		Thread thread1 = new Thread(tts);
//		thread1.setName("卖票窗口1");
//		Thread thread2 = new Thread(tts);
//		thread2.setName("卖票窗口2");
//		Thread thread3 = new Thread(tts);
//		thread3.setName("卖票窗口3");
//		Thread thread4 = new Thread(tts);
//		thread4.setName("卖票窗口4");
//		thread1.start();
//		thread2.start();
//		thread3.start();
//		thread4.start();
		
		/**用线程池ExecutorService: 创建线程*/
//		ExecutorService pool  =  Executors.newFixedThreadPool(5);
//		for(int i=0; i<5; i++) {
//			//.execute(Runnable r)每次找线程池的一个线程来执行run()方法.
//			pool.execute(tts);
//		}
//		//关闭线程池子,要不然程序会一直不结束
//		pool.shutdown();
	}
}

