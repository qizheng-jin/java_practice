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
		System.out.println("����A���ѧϰ����");
	}

	@Override
	public void hollidayMethod() {
		System.out.println("����A����ݼٷ���");
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
		AClassStudent aStudent = new AClassStudent("Ф·", 100);
		System.out.println(aStudent.getName() + "ͬѧ��ѧ����: " + aStudent.getStudentNum());
	}
}
