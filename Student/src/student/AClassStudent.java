package student;

public class AClassStudent implements Student_Interface{
	private String name;
	private int studentNum;
	public AClassStudent(String name, int studentNum) {
		this.name = name;
		this.studentNum = studentNum;
	}
	
	@Override
	public void studyMethod() {
		System.out.println("这是A班的学习方法");
	}

	@Override
	public void hollidayMethod() {
		System.out.println("这是A班的休假方法");
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}

	public static void main(String[] args) {
		AClassStudent aStudent = new AClassStudent("肖路", 100);
		System.out.println(aStudent.getName() + "同学的学号是: " + aStudent.getStudentNum());
	}
}
