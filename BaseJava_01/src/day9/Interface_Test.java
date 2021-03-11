package day9;

/**
 * 本接口用于创建接口测试
 * 1. 我们通过interface关键字来定义接口
 * 2  接口中不能有普通方法
 * 3. 接口中只能有抽象方法
 *
 */
public interface Interface_Test {
	int i =10;
	public abstract void skillq();
	public abstract void skillw();
}

interface UserInterface{
	/**
	 * 接口中定义的变量默认为常量, 默认加上 static final,所以可以直接用类名调用
	 */
	double pi = 3.14; //必须赋值
	public abstract void abstractMethod();
	
}

/**
 * 实际案例
 * */

interface Teacher{
	void prepare();
	void teach();
}



