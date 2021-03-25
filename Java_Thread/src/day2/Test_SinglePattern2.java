package day2;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * �������ģʽ2-����ʽ
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
	/**�Ͷ���ʽ������,�ӳٳ�ʼ������*/
	private static MySingle2 single2;
	private static Object o = new Object();
	private static int tickets = 100;
	private MySingle2() {}
	private ReentrantReadWriteLock rrw = new ReentrantReadWriteLock();
	/**
	 * ����: �������й�����Դsingle,�����ж����������˹�����Դ
	 * ��ʱ������Դsingle����ֶ��߳����ݰ�ȫ����
	 * �������:����-ͬ������� OR ͬ������
	 * ����λ��: �������в���������Դ�����
	 * ͬ������,���ڷ���ǰ�����synchronized,
	 */
	
	public static MySingle2 getMySingle2() {
		/**���û����ô˷���ʱ��,�ų�ʼ������*/
		/**
		 * ���ﲻ��дsynchronized(this)
		 * ��Ϊthis�Ǳ���Ķ������˼,��get�����Ǿ�̬����,������this����,���Բ�����this�ؼ���
		 * */
		synchronized(o) {
			if(single2 == null) {
				single2 = new MySingle2();
			}
			//single2����������
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
					System.out.println("Ʊ������");
					break;
				}
				System.out.println(Thread.currentThread().getName()+ "��Ʊ,��ʣ " + tickets + "��");
		
			}catch(Exception e){
			e.printStackTrace();
		}finally {
			rrw.writeLock().unlock();
		}
		}
	}
}
