package day2;
/**
 * 
 * 本类用于测试单例设计模式 -- 饿汉式
 * 单例函数,对象只有一个
 * 其中单例模式最重要的是确保对象只有一个。
 * 对本类构造方法私有化,防止外部调用构造方法创建对象
 * 创建全局唯一的对象,也做私有化处理
 * 通过自定义的公共方法将创建好的对象返回(类似封装属性后的getXxx() )
 */
public class Test_SinglePattern {
	public static void main(String[] args) {
		MySingle single = MySingle.getSingle();
		MySingle single2 = MySingle.getSingle();
		System.out.println(single == single2);
	}
}

//1. 创建自己的单例程序
class MySingle{
	//1. 提供构造方法,并将构造方法私有化
	private static MySingle single = new MySingle();
	private String line;
	/**构造方法私有化的目的是为了不让外界随意实例化对象*/
	private MySingle() {}
	
	private MySingle(String line) {
		this.line = line;
	}
	public static MySingle getSingle() {
		return single;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}
}
