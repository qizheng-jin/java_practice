package day7;

public class Static_test {
	/**
	 * 
	 * 为什么main函数中不能有this()
	 * 因为main函数是静态方法,比对象先加载到内存,所有静态方法都不能有this()
	 */
	public static void main(String[] args) {
		Student s = new Student();
		s.study();
		s.speak();
		s.name = "第一个学生名字";
		s.className = "301班";
		System.out.println(s.className);
		System.out.println(Student.className);//静态资源可以通过类名直接调用
		Student sec_s = new Student();
		sec_s.name = "第二个学生名字";
		sec_s.className = "302班";
		System.out.println(Student.className);
	}
}

class Student{
	//定义属性,成员变量,无需初始化
	int sno;
	String name;
	
	/**
	 * 静态资源可以通过类名直接调用不需要创建对象
	 * 原因是静态资源优先于对象进行加载，没对象的时候也可以直接调用
	 * 静态资源整个类里面只有一个值,无论哪个对象改变了静态值,整个类的静态资源都会改变
	 */
	static String className;
	//方法的构造：
	//修饰符, 返回值类型, 方法名, 参数列表{方法体}
	public void study() {
		System.out.println("这是study方法");
	}
	
	public void speak() {
		System.out.println("这是speak方法");
	}


	
	
}
