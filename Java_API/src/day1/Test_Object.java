package day1;

public class Test_Object {
	
	public static void main(String[] args) {
		Student student = new Student(45, "Liquid");
		System.out.println(student);
		/**
		 * ����hashCode()����,java������ʶ��һ������
		 */
		System.out.println(student.hashCode());
		/**
		 * ����.equals()����,�Ƚϵ��Ƕ���ĵ�ֵַ
		 */
		Student stud = new Student(45, "Liquid");
		System.out.println(student.equals(stud));
	}
}

class Student{
	int age;
	String name;
	
	public Student() {
		super();
	}

	public Student(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	/**
	 * toStringԴ�룺
	 * return getClass().getName() + "@" + Integer.toHexString(hashCode());
	 * ����+����+@+��ֵַ
	 */
	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + "]";
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + age;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		return result;
//	}

	@Override
	public boolean equals(Object obj) {
		//�ȿ�obj�ǲ�������Student��
		// a instanceof B����a�����Ƿ�����B��
		if(obj instanceof Student) {
			Student student = (Student)obj;
			if(student.age == age && student.name.equalsIgnoreCase(name)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	
}
