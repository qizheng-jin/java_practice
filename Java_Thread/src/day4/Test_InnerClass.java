package day4;

/**测试内部类*/
public class Test_InnerClass {
	public static void main(String[] args) {
		/**创建内部类对象,使用内部类资源
		 * 外部类型.内部类型 变量名 = 外部类对象.内部类对象
		 * */
		Outer.Inner inner = new Outer().new Inner();
		//调用方法与一般对象一致
		inner.get();
		
		//匿名对象: new 类名(); 只能用一次,暂时的
		new Outer().find();
		
		/**
		 * 如果成员内部类被private修饰，该如何调用？
		 * 在外部类中创建私有内部类对象
		 */
		Outer out = new Outer();
		out.getInner().get();
	}

}

class Outer{
	//定义外部类属性
	String name;
	int age;
	Inner inner;
	//定义外部类成员方法
	public void find() {
		System.out.println("Outer...find()...");
		/**
		 * 外部类要使用内部类资源
		 * 必须先创建内部类的对象，通过内部类对象进行访问
		 */
		Inner in = new Inner();
		in.get();
	}

	/**
	 * 内部类 -- 可以理解为外部类的特殊成员
	 * 1. 成员内部类: 类里方法外
	 * 2. 局部内部类: 方法里
	 * */
	 class Inner{
		private int count = 10;
		//定义内部类方法
		public void get() {
			System.out.println("inner...get()...");
		}
	}
	 
	 
	 public Inner getInner() {
		 if(inner == null) {
			 inner = new Inner();
		 }
		 return inner;
	 }
}