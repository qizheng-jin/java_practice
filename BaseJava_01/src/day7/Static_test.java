package day7;

public class Static_test {
	/**
	 * 
	 * Ϊʲômain�����в�����this()
	 * ��Ϊmain�����Ǿ�̬����,�ȶ����ȼ��ص��ڴ�,���о�̬������������this()
	 */
	public static void main(String[] args) {
		Student s = new Student();
		s.study();
		s.speak();
		s.name = "��һ��ѧ������";
		s.className = "301��";
		System.out.println(s.className);
		System.out.println(Student.className);//��̬��Դ����ͨ������ֱ�ӵ���
		Student sec_s = new Student();
		sec_s.name = "�ڶ���ѧ������";
		sec_s.className = "302��";
		System.out.println(Student.className);
	}
}

class Student{
	//��������,��Ա����,�����ʼ��
	int sno;
	String name;
	
	/**
	 * ��̬��Դ����ͨ������ֱ�ӵ��ò���Ҫ��������
	 * ԭ���Ǿ�̬��Դ�����ڶ�����м��أ�û�����ʱ��Ҳ����ֱ�ӵ���
	 * ��̬��Դ����������ֻ��һ��ֵ,�����ĸ�����ı��˾�ֵ̬,������ľ�̬��Դ����ı�
	 */
	static String className;
	//�����Ĺ��죺
	//���η�, ����ֵ����, ������, �����б�{������}
	public void study() {
		System.out.println("����study����");
	}
	
	public void speak() {
		System.out.println("����speak����");
	}


	
	
}
