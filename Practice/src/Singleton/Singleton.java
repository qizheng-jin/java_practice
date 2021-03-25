package Singleton;

public class Singleton {
	public static void main(String[] args) {
		Student student = Student.getStudent("ะกร๗", 18);
		System.out.println(student.getName() + "/" +student.getAge());
	}
	
}

class Student{
	private String name;
	private int age;
	private static Student student;
	private Student() {}
	private Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public static Student getStudent() {
		if(student == null) {
			student = new Student();
		}
		return student;
	}
	
	public static Student getStudent(String name, int age) {
		if(student == null) {
			student = new Student(name, age);
		}
		return student;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
