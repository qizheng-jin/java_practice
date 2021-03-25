package day1;

public class Test_SaleTickets implements Runnable{
	static int amount = 10;
	
	/**
	 * 超卖现象:超出执行范围
	 * 重卖现象:多次执行同一循环
	 * 需要同步,使用 synchronized(this){}代码块
	 */
	@Override
	public void run() {
		
		while(true) {
			synchronized(this) {
				try {
				 	Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				amount--;
				if(amount < 0) break;
			}
			System.out.println("请收好你的票, 还剩"+amount+"张" + Thread.currentThread().getName());
			
		}
	}
	
	public static void main(String[] args) {
		Test_SaleTickets ts = new Test_SaleTickets();
		Thread thread = new Thread(ts);
		Thread t2 = new Thread(ts);
		thread.start();
		t2.start();
	}
}

