package day8;

/**
 * 
 * 本类用于测试抽象类中的成员
 *
 */
public class Test4_AbstractTest {
	public static void main(String[] args) {
		Fruit fruit = new Apple("apple");
		fruit.sayHi();
		System.out.println(fruit.getPi());
	}
}

/**
 * 
 * 如果一个类都是普通方法为什么要被声明为抽象类呢?
 * 是为了不让外界创建这个类的对象
 *
 */
abstract class Fruit{
	private String name;
	//常量一定要初始化
	private final double pi = 3.14;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPi() {
		return pi;
	}
	
	public abstract void sayHi();
}

class Apple extends Fruit{
	private String name;
	public Apple(String s) {
		super();
		name = s;
	}
	@Override
	public void sayHi() {
		// TODO Auto-generated method stub
		System.out.println(name + " says Hi");
	}
	
}