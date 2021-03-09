package day7;
/**
 * 静态资源只能调用静态资源
 * 非静态资源都可以调用
 * @author Tedu
 *
 */
public class Static_test2 {
	
	public static void main(String[] args) {
		Teacher teacher = new Teacher();
		teacher.teach();
		Teacher.eat();
		Teacher.age = 10;
	}
	
}

class Teacher{
	String name;
	
	public void teach() {
		System.out.println("非静态方法teach");
	}
	
	static int age;
	
	public static void eat() {
		System.out.println("静态方法eat");
		System.out.println(age);//静态资源可以调用静态属性
		eat();//静态资源可以调用静态方法,和静态资源自己
	}
	
}
