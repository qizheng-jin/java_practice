package day5;

public class Method_test {
	/**
	 * 修饰符 返回值类型 方法名字（方法的参数）{方法体}
	 */
	public void method() {
		System.out.println("好耶!");
	}
	
	/**
	 * 	方法的重载:
	 * 在同一个类中,有多少个同名&参数列表不同的方法
	 * 
	 * */
	
	public void method(String s) {
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		Method_test test = new Method_test();
		test.method();
		test.method("阿宙斯");
	}
}
