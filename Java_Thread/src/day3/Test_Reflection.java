package day3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**���Է���*/
/** 
 * �����ǰ�����ֽ������
 * ��Ԫ���Է���: ��java���Ե���С��λ,�Ƽ�ʹ��
 * �﷨Ҫ��:��@Testע������ + û�в��� + public + voidû�з���ֵ����
 * Test��Ҫ����
 * 
*/
public class Test_Reflection {
	 
	@Test
	public void getClazz() throws Exception {
		//2. ѡ��Ҫ���Ƶ�Class���� �Ҽ�ѡ��: copy qualified name
		//�������ֵõ��ֽ���ķ���������
		Class<?> student1 = Class.forName("day3.Student");
		Class<?> student2 = Student.class;
		Class<? extends Student> student3 = new Student().getClass();
		System.out.println(student1);
		System.out.println(student2.getName()); //������
		System.out.println(student3.getSimpleName()); //��������
		System.out.println(student3.getPackage()); //�õ�����
		System.out.println(student1);
	}
	
	@Test
	public void getConstructor() {
		System.out.println("*******************");
		Class<?> clazz = Student.class;
		Constructor<?>[] cs =  clazz.getConstructors();
		for(Constructor c: cs) {
			System.out.println(c.getName());
			Class[] cps = c.getParameterTypes(); //��ù��캯���еĲ�������
			System.out.println(Arrays.toString(cps));
		}
	}
	
	//ͨ����Ԫ��������ó�Ա����
	@Test
	public void getFunction() throws ClassNotFoundException {
		System.out.println("****************");
		Class<?> clazz = Student.class;
		Class<?> clazz2 = Class.forName("day3.Student");
		Method[] methods = clazz.getMethods();
		for(Method method: methods) {
			System.out.println("������: " + method.getName());
			Parameter[] parameters = method.getParameters();
			System.out.println("���������б�" + Arrays.toString(parameters));
			System.out.println("��������ֵ����" + method.getReturnType());
		}
	}
	
	@Test
	public void getFields() throws ClassNotFoundException {
		System.out.println("******************");
		Class<?> clazz = Student.class;
		Class<?> clazz2 = Class.forName("day3.Student");
		Class<? extends Student> clazz3 = new Student().getClass();
		
		/**
		 * �����Ա���������η�����public,���޷���ȡ����Ա����
		 */
		Field[] fs = clazz.getFields();
		for(Field field: fs) {
			System.out.println(field.getName());
			System.out.println(field.getType().getName());
		}
	}
	
	//ͨ����Ԫ���� ���Է��䴴������
	@Test
	public void createObject() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Class<?> clazz = Student.class;
		//ֻ�ܵõ��޲ι���Ķ���
		Object o = clazz.newInstance();
		System.out.println(o);
		/**
		 * �õ����ι���Ķ���
		 * ���ǿ��Ի�ȡָ���Ĺ��췽��,���ݷ���������ָ��
		 * ע�⴫��Ĳ������ǲ�����ֱ������,��ʮ��Ӧ���ֽ������
		 * 
		 */
		Constructor<?> c = clazz.getConstructor(String.class, int.class);
		
		//�����õ��ĺ��ι��췽������,����Student����,��������ȫ�ι���
		Object p = c.newInstance("С��", 18);
		System.out.println(p);
		if(p instanceof Student) {
			//��̬,��������
			Student s = (Student)p;
			System.out.println("ѧ������" + s.getName());
			System.out.println("ѧ������"+s.getAge());
			s.tell();
		}
	}
}

/**���������*/
class Student{
	public String name;
	public int age;
	
	public Student() {}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public void tell() {
		System.out.println("tell ����");
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
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

