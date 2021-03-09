package day7;

/**
 * 
 * 多态的作用
 *
 */
public class Static_test3 {
	public static void main(String[] args) {
		Animal a = new Cat();
		a.eat();
		//a.jump()无法通过编译, 父类无法使用子类的特有方法
		Animal b = new Animal();
		b.eat();
		/**
		 * 父类引用， 指向子类对象
		 * 编译(保存)看左边,运行(测试)看右边
		 * 多态的出现是为了统一调用标准,向父类看齐
		 * 父类提供的功能才能用,子类特有的的功能用不了
		 *  
		 */
	}
}

class Animal{
	//创建父类的普通方法
	public void eat() {
		System.out.println("动物有吃的能力");
	}
}

//子类
class Cat extends Animal{
	public void eat() {
		System.out.println("猫吃鱼");
	}
	public void jump() {
		System.out.println("猫可以跳");
	}
}
