package day6;

public class Dog_class {
	private String name;

	public Dog_class() {
	}
	
	public Dog_class(String name) {
		/*
		 * �����е����޲�
		 * this���������޲ι��캯��
		 * ����ע�ⲻ�ܻ������,�����������ѭ��
		 */
		this();
		
		
		this.name = name;
	}

	
	
	public static void main(String[] args) {
		Dog_class d = new Dog_class();
		Dog_class d2 = new Dog_class("��");
		Integer in = new Integer(15);
		System.out.println(in);
	}
}
