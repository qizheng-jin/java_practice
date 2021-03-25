
public class Person {
	
	public Object getPerson() {
		Person p = new Person();
		return p;
	}
}

class Student extends Person{
	
	public Student getPerson() {
		Student s = new Student();
		return s;
	}
}

class Student1 extends Person{
	public Student getPerson() {
		Student s = new Student();
		return s;
	}
}
