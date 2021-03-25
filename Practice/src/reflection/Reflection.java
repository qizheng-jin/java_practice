package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.Test;

public class Reflection {
	@Test
	public void getConstructor() throws Exception {
		Class<?> clazz = Class.forName("reflection.Card");
		Constructor<?>[] constructors = clazz.getConstructors();
		for(Constructor<?> constructor: constructors) {
			System.out.println(constructor.getName());
			System.out.println(Arrays.toString(constructor.getParameters()));
		}
	}
	
	@Test
	public void getField() throws Exception{
		Class<?> clazz = Card.class;
		Field[] fields = clazz.getFields();
		Method[] methods = clazz.getMethods();
		for(Field field: fields) {
			System.out.println("**************");
			System.out.println(field.getName() + ":" + field.getType());
		}
		for(Method method: methods) {
			System.out.println(method.getName() + ":" + method.getReturnType() + Arrays.toString(method.getParameterTypes()));
		}
	}
}

class Card{
	public String name;
	
	public Card(){}
	public Card(String name) {
		this.name = name;
	}
	
	public void run() {
		System.out.println("run·½·¨");
	}
}