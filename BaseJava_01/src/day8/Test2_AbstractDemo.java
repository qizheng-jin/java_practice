package day8;

public class Test2_AbstractDemo {
	public static void main(String[] args) {
		Animal animal = new Dog();
		animal.eat();
		animal.fly(); //多态之后调用抽象方法,运行的是子类的实现
		//Cannot instantiate the type Pig不能实例化一个抽象类,不能创建对象
		//Animal animal2 = new Pig();
	}
}

/**
 * 
 *  当子类继承抽象父类后,子类可以变成抽象子类,
 *  或者实现父类中所有抽象方法
 */
abstract class Animal{
	public void eat() {
		System.out.println("这是Animal类中的eat方法");
	}
	public void play() {
		System.out.println("这是animal类中的play方法");
	}
	public abstract void fly();
}

abstract class Pig extends Animal{
	public abstract void fly();
}

class Dog extends Animal{

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("这是dog类中的fly方法");
	}
	
}

interface Animal_interface{
	public void start();
	public void stop();
	public void eat();
	public void sleep();
}
