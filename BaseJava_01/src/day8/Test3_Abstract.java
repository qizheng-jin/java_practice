package day8;
/**
 * 
 * 抽象类中的构造函数
 * 1. 抽象类中可以有构造方法
 * 2. 父类的构造方法要优先于子类执行
 * 3. 抽象类不可以创建对象
 * 4. 抽象类中存在的构造方法不是为了创建本类对象时调用
 * 而是为了创建子类对象时使用
 *
 */
public class Test3_Abstract {
	public static void main(String[] args) {
		
		Animals animal = new Mouse("老鼠");
		//new Animals();//抽象类不能创建对象
		
	}
	
}


abstract class Animals{
	public Animals(String s) {
		System.out.println("我是Animal3的构造方法");
	}
}

class Mouse extends Animals{
	public Mouse(String s) {
		super(s);
		System.out.println("mouse的构造方法" + s);
	}
	
}