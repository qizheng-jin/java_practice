package day7;
/**
 * ��̬��Դֻ�ܵ��þ�̬��Դ
 * �Ǿ�̬��Դ�����Ե���
 * @author Tedu
 *
 */
public class Static_test2 {
	
	public static void main(String[] args) {
		Teacher teacher = new Teacher();
		teacher.teach();
		Teacher.eat();
		Teacher.age = 10;
	}
	
}

class Teacher{
	String name;
	
	public void teach() {
		System.out.println("�Ǿ�̬����teach");
	}
	
	static int age;
	
	public static void eat() {
		System.out.println("��̬����eat");
		System.out.println(age);//��̬��Դ���Ե��þ�̬����
		eat();//��̬��Դ���Ե��þ�̬����,�;�̬��Դ�Լ�
	}
	
}
