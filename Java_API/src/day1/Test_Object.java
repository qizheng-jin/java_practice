package day1;

public class Test_Object {
	
	public static void main(String[] args) {
		Student student = new Student(45, "Liquid");
		System.out.println(student);
		/**
		 * 测试hashCode()方法,java用它来识别一个对象
		 */
		System.out.println(student.hashCode());
		/**
		 * 测试.equals()方法,比较的是对象的地址值
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
	 * toString源码：
	 * return getClass().getName() + "@" + Integer.toHexString(hashCode());
	 * 包名+类名+@+地址值
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
		//先看obj是不是属于Student类
		// a instanceof B看看a对象是否属于B类
		if(obj instanceof Student) {
			Student student = (Student)obj;
			if(student.age == age && student.name.equalsIgnoreCase(name)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	
}
