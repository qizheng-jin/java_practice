package day4;

public class Test_Inner4 {
	public static void main(String[] args) {
		new InnerClass() {
			//ֻ��Ҫ��д������ĳ��󷽷�,��ͨ����û��Ҫ��
			@Override
			public void eat() {
				// TODO Auto-generated method stub
				
				
			}
			
		}.eat();
	}
}

interface Inner{
	void get();
	void save();
}

abstract class InnerClass{
	abstract public void eat();
	public void play() {
		System.out.println("�������е���ͨ����");
	}
}