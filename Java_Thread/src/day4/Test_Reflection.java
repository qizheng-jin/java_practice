package day4;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

/**���Ա�������, ���Ի�ȡ˽�л���Դ*/
public class Test_Reflection {

	//1. ���嵥Ԫ���Է���getField()������ȡ����
	@Test
	public void getField() throws Exception{
		//2. ��ȡPerson����ֽ������
		Class<?> clazz = Person.class;
		//3. ��ȡ˽������ .getDeclaredField
		Field field = clazz.getDeclaredField("name");
		//4. ���ݻ�ȡ�������Զ����ȡ������
		System.out.println(field.getType());
		//5. �������Ե�ֵ
		Object obj = clazz.newInstance();
		//��������,����˽�пɼ�
		field.setAccessible(true);
		//field.set(Object o, value) -- ��value����Ϊo�����field��ֵ, ��Ա��������set�������������ͳ�Ա����ֵ
		field.set(obj, "day19");
		System.out.println(field.get(obj));
	}
	
	@Test
	public void getFunction() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		//��ȡ�ֽ������
		Class<?> clazz = Person.class;
		//3. ��ȡ˽�з��� .getDeclaredMethod(������, ����1, ����2.....)
		Method method = clazz.getDeclaredMethod("save", String.class, int.class);
		Object obj = clazz.newInstance();
		method.setAccessible(true);
		// method.invoke(Object o, parameter1, parameter2 ....) ��������invoke�����������Ͳ���
		Object o=method.invoke(obj, "ANBC", 1);
	}
}

class Person{
	//1. ����˽������
	private String name;
	private int age;
	
	
	//2. ����˽�з���
	private void run() {
		System.out.println("run ��");
	}
	
	private void save(String s, int n) {
		System.out.println(n + "save()..." + s);
	}
	
	private String getName() {
		return name;
	}
}