package day4;

/**测试匿名内部类*/
public class Test_Inner3 {
	public static void main(String[] args) {
		//匿名对象， 相当于创建了一个接口的实现类，并且重写了接口中的所有抽象方法
		new Inner1() {

			@Override
			public void get() {
				// TODO Auto-generated method stub
				System.out.println("get方法");
			}

			@Override
			public void save() {
				// TODO Auto-generated method stub
				System.out.println("save方法");
			}
		}.get();//触发指定的重写后的方法, 匿名对象只能调用一个方法,且只能调用一次
		
	}
}

//创建接口 Inner
interface Inner1{
	void get();
	void save();
}