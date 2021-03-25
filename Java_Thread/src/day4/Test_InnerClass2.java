package day4;

import day4.Outer3.Inner3;

public class Test_InnerClass2 {
	public static void main(String[] args) {
		
		// Outer3.Inner3 inner = new Outer3().new Inner3();
		//静态内部类的调用
		Outer3.Inner3 inner = new Outer3.Inner3();
		inner.play();
		new Outer3.Inner3().play();
		
		//静态内部类的静态方法调用
		Outer3.Inner3.run();
		
		
		/**使用局部内部类
		 * 直接调用show方法是无法触发内部类功能的
		 * 需要在外部类中创建内部类对象并进行调用，才能出发内部类的功能
		 * */
		
		
	}
}


class Outer3{
	
	public void outMethod() {
		
		class Inner4{
			String name;
			int age;
			public void eat() {
				System.out.println("这是out类方法里面的内部类的普通方法");
			}
		}
		Inner4 inner4 = new Inner4();
		System.out.println(inner4.name);
		inner4.eat();
	}
	
	//2. 创建内部类Inner3
	static class Inner3{
		//3. 创建内部类普通成员方法
		public void play() {
			System.out.println("这是Inner的普通方法");
		}
		
		public static void run() {
			System.out.println("这是Inner的静态方法");
		}
	}
}