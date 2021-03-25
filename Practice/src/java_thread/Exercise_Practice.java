package java_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Exercise_Practice{	
	public static void main(String[] args) {
		Count count = Count.getCount();
		ExecutorService es = Executors.newFixedThreadPool(4);
		for(int i=0; i<4; i++) {
			es.execute(count);
		}
		es.shutdown();
	}
}

class Count implements Runnable{
	private Count() {}
	private static Count count;
	private ReentrantReadWriteLock rrwl = new ReentrantReadWriteLock();
	private static int tickets = 100;
	synchronized public static Count getCount() {
		if(count == null) count = new Count();
		return count;
	}
	@Override
	public void run() {
		while(true) {
			rrwl.writeLock().lock();
			try {
				Thread.sleep(100);
				tickets --;
				if(tickets < 0) {
					System.out.println("tickets have sold out");
					break;
				}
				System.out.println(Thread.currentThread().getName() + ", »¹Ê££º " + tickets + "ÕÅÆ±");
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				rrwl.writeLock().unlock();
			}
		}
	}
}
