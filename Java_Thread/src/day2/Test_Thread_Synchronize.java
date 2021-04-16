package day2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**���ڽ�����̰߳�ȫ����*/
public class Test_Thread_Synchronize implements Runnable{
	private static int tickets = 100;
	/**��д��, �ֹ���, ��Ҫ���ڶ���д�ٵĳ���,��д�ֿ�*/
	private static ReentrantReadWriteLock rrw = new ReentrantReadWriteLock(true);
	/**
	 * ���߳��г������ݲ���ȫ��ǰ��
	 * 1. ���̳߳���
	 * 2. ��������
	 * 3. �������ͬʱ������������
	 * �������: ͬ����, synchronized(this){}
	 * �����ķ�ΧҪ����
	 * 
	 * ���һ������������Ҫͬ��,�����дͬ������
	 * ͬ������ͬһʱ��ֻ�ܱ�һ���������
	 * �﷨: synchronized public void run(){}
	 */
	
	@Override
	public void run() {
		
		while(true) {
			/**��д����д�ֿ�,���Ƕ���*/
			rrw.writeLock().lock();
			/**ͬ���������ͬһʱ��ֻ����һ���߳�����
			 * synchronizedͬ���ؼ��ֿ����������η���,��Ϊͬ������,ʹ�õ���������this
			 * synchronizedͬ���ؼ��ֿ����������δ����,��Ϊͬ�������,ʹ�õ��������������
			 * ͬ����ȱ���ǻή�ͳ����ִ��Ч�ʣ�������Ϊ�˱�֤�̵߳İ�ȫ,��Щ�����Ǳ���Ҫ������
			 * ����Ϊ������,�����ķ�Χ��Ҫ���ƺ�,�������ǲ���Ҫ�������̳�����,���¼�����Ϳ�����
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
				System.out.println(Thread.currentThread().getName() +"��Ʊ,��ʣ�� " + tickets + "��Ʊ");
			}catch(Exception e) {
			e.printStackTrace();
		}finally {
			rrw.writeLock().unlock();
		}
		//System.out.println("Ʊ������");
		}
	}
	
	
	public static void main(String[] args) {
		Test_Thread_Synchronize tts = new Test_Thread_Synchronize();
//		Thread thread1 = new Thread(tts);
//		thread1.setName("��Ʊ����1");
//		Thread thread2 = new Thread(tts);
//		thread2.setName("��Ʊ����2");
//		Thread thread3 = new Thread(tts);
//		thread3.setName("��Ʊ����3");
//		Thread thread4 = new Thread(tts);
//		thread4.setName("��Ʊ����4");
//		thread1.start();
//		thread2.start();
//		thread3.start();
//		thread4.start();
		
		/**���̳߳�ExecutorService: �����߳�*/
//		ExecutorService pool  =  Executors.newFixedThreadPool(5);
//		for(int i=0; i<5; i++) {
//			//.execute(Runnable r)ÿ�����̳߳ص�һ���߳���ִ��run()����.
//			pool.execute(tts);
//		}
//		//�ر��̳߳���,Ҫ��Ȼ�����һֱ������
//		pool.shutdown();
	}
}

