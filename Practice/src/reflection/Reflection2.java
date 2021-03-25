package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class Reflection2 {
	
	@Test
	public void getPrivateField() throws Exception {
		Class<? extends Student> clazz = new Student().getClass();
		Field name = clazz.getDeclaredField("name");
		System.out.println(name.getName());
		Object o = clazz.newInstance();
		Student s = (Student)o;
		name.setAccessible(true);
		name.set(s, "小明");
		System.out.println("student name is " + name.get(s));
	}
	
	@Test
	public void getPrivateMethod() throws Exception{
		Class<?> clazz = Student.class;
		Method method = clazz.getDeclaredMethod("method", String.class);
		Object o = clazz.newInstance();
		method.setAccessible(true);
		method.invoke(o, "私有方法");//运行方法
	}
}

class Student{
	private String name;
	private void method(String s) {
		System.out.println("private method print is :" + s);
	}
}
