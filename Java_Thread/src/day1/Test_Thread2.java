package day1;

public class Test_Thread2 implements Runnable{
	
	/**
	 * Runnable��û���ṩ����ķ���,ֻ��run()
	 * Thread.currentThread()--��ȡ��ǰ����ִ��ҵ����̶߳���
	 * getName()--��ȡ���̶߳��������
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++) {
			System.out.println(i+"="+Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
		//�����̶߳���
		Test_Thread2 tt = new Test_Thread2();
		//��Thread����ӿڵ�ʵ�������
		Thread thread = new Thread(tt);
		Thread thread2 = new Thread(tt);
		thread.start();
		//thread.start();
		thread2.start();
	}
}
