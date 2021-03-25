package day4;

import java.io.Serializable;

/**
 * 
 * Serializable �ӿ�û�г��󷽷�,�Ǹ��սӿ�,ֻ����Ϊ��־˵���������Խ������л�
 * ���������Ҫ������л�,����ʵ�����л��ӿ�
 *
 */
public class Student implements Serializable{
	//The serializable class Student does not declare a static final serialVersionUID field of type long
	//��Ҫ��ÿ�����л��ļ�����Ψһ��UIDֵ
	private static final long serialVersionUID = 8889125286467511841L;
		
	//1. ��������
	private String name;
	private int age;
	private String gender;
	private String address;
	
	//2. �����������ɹ��췽��
	public Student(String name, int age, String gender, String address) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	public Student() {
		super();
		System.out.println("�޲ι���");
	}
	
	
}
