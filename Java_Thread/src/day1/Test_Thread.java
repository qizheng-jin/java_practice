package day1;

/**
 * 
 */
public class Test_Thread extends Thread{
	private String name;
	
	public Test_Thread() {
		super();
	}

	/*
	 * 要改程序名需要重写一个含参构造,然后调用父类的name.
	 */
	public Test_Thread(String name) {
		super(name);
		this.name = name;
	}
	
	public void run() {
		super.run();//默认调用Thread类的业务
		
		int i=0;
		while(i<10) {
			System.out.println("线程启动了" + getName()); //从父类继承来的getName方法,可以直接用
			i++;
		}
	}
	
	
	public static void main(String[] args) {
		Test_Thread tt = new Test_Thread();
		Test_Thread tt2 = new Test_Thread();
		/**
		 * 想要使用多线程效果,必须使用start方法,才能加入就绪队列
		 * 所以run和start本质区别,run只是普通单线程,start才是多线程
		 * 多线程的运行顺序是随机的,由CPU调度
		 */
		Thread thread = new Thread(tt);
		thread.start();
		thread = new Thread(tt2);
		thread.start();
	}
}
