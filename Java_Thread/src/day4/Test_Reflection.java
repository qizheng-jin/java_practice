package day4;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

/**测试暴力反射, 可以获取私有化资源*/
public class Test_Reflection {

	//1. 定义单元测试方法getField()用来获取属性
	@Test
	public void getField() throws Exception{
		//2. 获取Person类的字节码对象
		Class<?> clazz = Person.class;
		//3. 获取私有属性 .getDeclaredField
		Field field = clazz.getDeclaredField("name");
		//4. 根据获取到的属性对象获取其类型
		System.out.println(field.getType());
		//5. 设置属性的值
		Object obj = clazz.newInstance();
		//暴力反射,设置私有可见
		field.setAccessible(true);
		//field.set(Object o, value) -- 将value设置为o对象的field的值, 成员变量呼叫set方法，传入对象和成员变量值
		field.set(obj, "day19");
		System.out.println(field.get(obj));
	}
	
	@Test
	public void getFunction() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		//获取字节码对象
		Class<?> clazz = Person.class;
		//3. 获取私有方法 .getDeclaredMethod(方法名, 参数1, 参数2.....)
		Method method = clazz.getDeclaredMethod("save", String.class, int.class);
		Object obj = clazz.newInstance();
		method.setAccessible(true);
		// method.invoke(Object o, parameter1, parameter2 ....) 方法呼叫invoke方法传入对象和参数
		Object o=method.invoke(obj, "ANBC", 1);
	}
}

class Person{
	//1. 定义私有属性
	private String name;
	private int age;
	
	
	//2. 定义私有方法
	private void run() {
		System.out.println("run 了");
	}
	
	private void save(String s, int n) {
		System.out.println(n + "save()..." + s);
	}
	
	private String getName() {
		return name;
	}
}