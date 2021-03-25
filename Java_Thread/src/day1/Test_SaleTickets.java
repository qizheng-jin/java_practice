package day1;

public class Test_SaleTickets implements Runnable{
	static int amount = 10;
	
	/**
	 * ��������:����ִ�з�Χ
	 * ��������:���ִ��ͬһѭ��
	 * ��Ҫͬ��,ʹ�� synchronized(this){}�����
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
			System.out.println("���պ����Ʊ, ��ʣ"+amount+"��" + Thread.currentThread().getName());
			
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

