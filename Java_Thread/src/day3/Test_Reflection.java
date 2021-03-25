package day3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**测试反射*/
/** 
 * 反射的前提是字节码对象
 * 单元测试方法: 是java测试的最小单位,推荐使用
 * 语法要求:被@Test注解修饰 + 没有参数 + public + void没有返回值类型
 * Test需要导包
 * 
*/
public class Test_Reflection {
	 
	@Test
	public void getClazz() throws Exception {
		//2. 选中要复制的Class名， 右键选择: copy qualified name
		//下面三种得到字节类的方法都可以
		Class<?> student1 = Class.forName("day3.Student");
		Class<?> student2 = Student.class;
		Class<? extends Student> student3 = new Student().getClass();
		System.out.println(student1);
		System.out.println(student2.getName()); //含包名
		System.out.println(student3.getSimpleName()); //不含包名
		System.out.println(student3.getPackage()); //得到包名
		System.out.println(student1);
	}
	
	@Test
	public void getConstructor() {
		System.out.println("*******************");
		Class<?> clazz = Student.class;
		Constructor<?>[] cs =  clazz.getConstructors();
		for(Constructor c: cs) {
			System.out.println(c.getName());
			Class[] cps = c.getParameterTypes(); //获得构造函数中的参数类型
			System.out.println(Arrays.toString(cps));
		}
	}
	
	//通过单元测试来获得成员方法
	@Test
	public void getFunction() throws ClassNotFoundException {
		System.out.println("****************");
		Class<?> clazz = Student.class;
		Class<?> clazz2 = Class.forName("day3.Student");
		Method[] methods = clazz.getMethods();
		for(Method method: methods) {
			System.out.println("方法名: " + method.getName());
			Parameter[] parameters = method.getParameters();
			System.out.println("方法参数列表" + Arrays.toString(parameters));
			System.out.println("方法返回值类型" + method.getReturnType());
		}
	}
	
	@Test
	public void getFields() throws ClassNotFoundException {
		System.out.println("******************");
		Class<?> clazz = Student.class;
		Class<?> clazz2 = Class.forName("day3.Student");
		Class<? extends Student> clazz3 = new Student().getClass();
		
		/**
		 * 如果成员变量的修饰符不是public,则无法获取到成员变量
		 */
		Field[] fs = clazz.getFields();
		for(Field field: fs) {
			System.out.println(field.getName());
			System.out.println(field.getType().getName());
		}
	}
	
	//通过单元测试 测试反射创建对象
	@Test
	public void createObject() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Class<?> clazz = Student.class;
		//只能得到无参构造的对象
		Object o = clazz.newInstance();
		System.out.println(o);
		/**
		 * 得到含参构造的对象
		 * 我们可以获取指定的构造方法,根据方法参数来指定
		 * 注意传入的参数不是参数的直接类型,二十对应的字节码对象
		 * 
		 */
		Constructor<?> c = clazz.getConstructor(String.class, int.class);
		
		//利用拿到的含参构造方法对象,创建Student对象,触发的是全参构造
		Object p = c.newInstance("小明", 18);
		System.out.println(p);
		if(p instanceof Student) {
			//多态,向下造型
			Student s = (Student)p;
			System.out.println("学生名字" + s.getName());
			System.out.println("学生年龄"+s.getAge());
			s.tell();
		}
	}
}

/**反射测试类*/
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
		System.out.println("tell 方法");
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

