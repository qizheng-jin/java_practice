package day4;

import java.io.Serializable;

/**
 * 
 * Serializable 接口没有抽象方法,是个空接口,只是作为标志说明这个类可以进行序列化
 * 如果本类想要完成序列化,必须实现序列化接口
 *
 */
public class Student implements Serializable{
	//The serializable class Student does not declare a static final serialVersionUID field of type long
	//需要给每个序列化文件分配唯一的UID值
	private static final long serialVersionUID = 8889125286467511841L;
		
	//1. 定义属性
	private String name;
	private int age;
	private String gender;
	private String address;
	
	//2. 根据属性生成构造方法
	public Student(String name, int age, String gender, String address) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	public Student() {
		super();
		System.out.println("无参构造");
	}
	
	
}
