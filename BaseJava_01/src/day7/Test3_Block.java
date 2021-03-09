package day7;

public class Test3_Block {
	public static void main(String[] args) {
		Person p = new Person();
		p.study();
		System.out.println("********");
		Person p2 = new Person(); //静态代码块不会再调用一次
		
	}
	
}
/**
 * 
 * 调用顺序:静态代码块>构造代码块>构造函数>普通方法>局部代码块
 * 静态代码块:
 * 类里方法外,触发节点:随着类的加载而加载,只加载一次
 * 构造代码块:
 * 类里方法外吗触发节点:创建对象时立即执行
 * 局部代码块:
 * 方法里,触发节点:调用方法时候执行
 */

class Person{
	static {
		System.out.println("静态代码块"); //静态代码块只执行一次,创建两个对象只会加载一次
	}
	{
		System.out.println("构造代码块");
	}

	public Person() {
		System.out.println("构造方法");
	}
	
	public void study() {
		System.out.println("我是普通方法");
		{
			System.out.println("局部代码块");
		}
	}
}