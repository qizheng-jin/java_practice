package day7;

public class Polymorphism_Test {
	public static void main(String[] args) {
		Dogs dog = new Dogs();
		System.out.println(dog.sum);
		dog.eat();
		dog.play();
		//创建一个多态对象
		Animals a = new Dogs();
		//多态对象的成员变量用的是父类的，即使父类成员变量没有初始化
		System.out.println(a.sum);
		
		//多态中，非静态方法都是使用父类的声明，子类的实现(使用子类的方法)
		a.eat();
		
		
		//多态中，如果父子类都有静态方法，使用的是父类的
		a.play();
		
		
	}
	
}

class Animals{
	int sum = 10;
	public void eat() {
		System.out.println("吃啥都行");
	}
	public static void play() {
		System.out.println("玩啥都行");
	}
	
}

class Dogs extends Animals{
	int sum = 20;
	public void eat() {
		System.out.println("狗吃骨头");
	}
	
	public static void play() {
		System.out.println("打滚");
	}
}
