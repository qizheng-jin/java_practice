package day4;

public class Test_Inner4 {
	public static void main(String[] args) {
		new InnerClass() {
			//只需要重写抽象父类的抽象方法,普通方法没有要求
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
		System.out.println("抽象类中的普通方法");
	}
}