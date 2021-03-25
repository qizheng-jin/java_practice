package day5;

public class Test_Constructor {
	public static void main(String[] args) {
		B b = new B();
		b.run();
	}
}
class A{
	static{
		System.out.println("父类的静态代码块");
	}
	{
		System.out.println("父类的构造代码块");
	}
	public A(){
		System.out.println("父类构造函数");
	}
	
	public void run() {
		System.out.println("父类的方法");
		{
			System.out.println("父类的局部代码块");
		}
	}
}
class B extends A{
	static{
		System.out.println("子类的静态代码块");
	}
	{
		System.out.println("子类的构造代码块");
	}
	public B(){
		System.out.println("子类构造函数");
	}
	
	public void run() {
		System.out.println("子类的方法");
		{
			System.out.println("子类的局部代码块");
		}
	}
}
