package day6;
/**
 * 
 * 继承
 * 1)super（参数）：调用基类中的某一个构造函数（应该为构造函数中的第一条语句） 

　　2)this（参数）：调用本类中另一种形成的构造函数（应该为构造函数中的第一条语句）
   super()和this()类似,区别是，super()从子类中调用父类的构造方法，this()在同一类内调用其它方法。
   this和super不能同时出现在一个构造函数里面，因为this必然会调用其它的构造函数，其它的构造函数必然也会有super语句的存在，所以在同一个构造函数里面有相同的语句，就失去了语句的意义，编译器也不会通过。
   this()和super()都指的是对象，所以，均不可以在static环境中使用。包括：static变量,static方法，static语句块。
   从本质上讲，this是一个指向本对象的指针, 然而super是一个Java关键字。
 */
public class test{
	public static void main(String[] args) {
		B b = new B("你好");
		A a = new A("我不好");
		a.p();
		b.p();
	}
	
}

class A{
	private String s;
	public A(String s) {
		this.s = s;
	}
	public void p() {
		System.out.println("A类中的输入值: " + s);
	}
	
	/**
	 * 所谓方法重载(overloading)是指在一个类中，多个方法的方法名相同，方法类型也相同,但是参数列表不同。
	 * 参数列表不同指的是参数个数、参数类型或者参数的顺序不同。
	 */
	public void p(String s) {
		
	}
}

class B extends A{
	String s;
	public B(String s) {
		super(s);
		this.s = s;
	}
	/**在Java中静态方法可以被继承，但是不能被覆盖，即不能重写。*/
	/**OCP原则,面向功能修改关闭,面向功能拓展开放,只允许拓展,不允许修改原来的代码*/
	/**重写(overriding)要和父类的方法签名(返回值类型,方法名和参数列表)保持一致*/
	/**子类的权限修饰符必须大于等于父类的权限修饰符*/
	public void p() {
		super.p();//调用父类方法
		System.out.println("B类中的输入值: " + s);
	}
}
