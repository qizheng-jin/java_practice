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
	 * Ҫ�ĳ�������Ҫ��дһ�����ι���,Ȼ����ø����name.
	 */
	public Test_Thread(String name) {
		super(name);
		this.name = name;
	}
	
	public void run() {
		super.run();//Ĭ�ϵ���Thread���ҵ��
		
		int i=0;
		while(i<10) {
			System.out.println("�߳�������" + getName()); //�Ӹ���̳�����getName����,����ֱ����
			i++;
		}
	}
	
	
	public static void main(String[] args) {
		Test_Thread tt = new Test_Thread();
		Test_Thread tt2 = new Test_Thread();
		/**
		 * ��Ҫʹ�ö��߳�Ч��,����ʹ��start����,���ܼ����������
		 * ����run��start��������,runֻ����ͨ���߳�,start���Ƕ��߳�
		 * ���̵߳�����˳���������,��CPU����
		 */
		Thread thread = new Thread(tt);
		thread.start();
		thread = new Thread(tt2);
		thread.start();
	}
}
