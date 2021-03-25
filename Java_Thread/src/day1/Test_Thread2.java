package day1;

public class Test_Thread2 implements Runnable{
	
	/**
	 * Runnable中没有提供多余的方法,只有run()
	 * Thread.currentThread()--获取当前正在执行业务的线程对象
	 * getName()--获取此线程对象的名称
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++) {
			System.out.println(i+"="+Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
		//创建线程对象
		Test_Thread2 tt = new Test_Thread2();
		//将Thread类与接口的实现类相绑定
		Thread thread = new Thread(tt);
		Thread thread2 = new Thread(tt);
		thread.start();
		//thread.start();
		thread2.start();
	}
}
