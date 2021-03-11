package day8;

/**
 * 
 * �������ڲ��Գ������еĳ�Ա
 *
 */
public class Test4_AbstractTest {
	public static void main(String[] args) {
		Fruit fruit = new Apple("apple");
		fruit.sayHi();
		System.out.println(fruit.getPi());
	}
}

/**
 * 
 * ���һ���඼����ͨ����ΪʲôҪ������Ϊ��������?
 * ��Ϊ�˲�����紴�������Ķ���
 *
 */
abstract class Fruit{
	private String name;
	//����һ��Ҫ��ʼ��
	private final double pi = 3.14;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPi() {
		return pi;
	}
	
	public abstract void sayHi();
}

class Apple extends Fruit{
	private String name;
	public Apple(String s) {
		super();
		name = s;
	}
	@Override
	public void sayHi() {
		// TODO Auto-generated method stub
		System.out.println(name + " says Hi");
	}
	
}