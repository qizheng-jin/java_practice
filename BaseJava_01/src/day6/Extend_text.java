package day6;

public class Extend_text {
	public static void main(String[] args) {
		Son son = new Son();
		
	}
}

class Father{
	String s;
	public Father() {
		System.out.println("父类的无参构造");
	}
	public Father(String s) {
		this.s = s;
	}
}
/**
 * 
 * 创建子类对象一定会调用父类的无参构造!
 * 子类不能重写父类的构造方法
 * 子类的构造方法中,默认存在super()调用父类的无参构造
 * 
 */
class Son extends Father{
	public Son() {
		super();//默认运行super()调用父类的无参构造
		System.out.println("子类的无参构造");
	}
}