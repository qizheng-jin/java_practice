package day6;

public class Dog_class {
	private String name;

	public Dog_class() {
	}
	
	public Dog_class(String name) {
		/*
		 * 含参中调用无参
		 * this用来调用无参构造函数
		 * 但是注意不能互相调用,否则会陷入死循环
		 */
		this();
		
		
		this.name = name;
	}

	
	
	public static void main(String[] args) {
		Dog_class d = new Dog_class();
		Dog_class d2 = new Dog_class("狗");
		Integer in = new Integer(15);
		System.out.println(in);
	}
}
