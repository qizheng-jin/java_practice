package day5;

public class Test_Constructor {
	public static void main(String[] args) {
		B b = new B();
		b.run();
	}
}
class A{
	static{
		System.out.println("����ľ�̬�����");
	}
	{
		System.out.println("����Ĺ�������");
	}
	public A(){
		System.out.println("���๹�캯��");
	}
	
	public void run() {
		System.out.println("����ķ���");
		{
			System.out.println("����ľֲ������");
		}
	}
}
class B extends A{
	static{
		System.out.println("����ľ�̬�����");
	}
	{
		System.out.println("����Ĺ�������");
	}
	public B(){
		System.out.println("���๹�캯��");
	}
	
	public void run() {
		System.out.println("����ķ���");
		{
			System.out.println("����ľֲ������");
		}
	}
}
