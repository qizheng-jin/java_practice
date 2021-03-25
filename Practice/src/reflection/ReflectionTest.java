package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

import org.junit.Test;

public class ReflectionTest {
	@Test
	public void getClazz() throws ClassNotFoundException {
		Class<?> clazz = YGOCard.class;
		Class<?> clazz2 = Class.forName("reflection.YGOCard");
		Class<? extends YGOCard> clazz3 = new YGOCard().getClass(); 
		System.out.println(clazz.getName());
		System.out.println(clazz.getSimpleName());
	}
	
	@Test
	public void getConstructors() {
		Class<?> clazz = YGOCard.class;
		Constructor<?>[] constructors = clazz.getConstructors();
		for(Constructor<?> c: constructors) {
			System.out.println("构造函数名: " + c.getName());
			Parameter[] paraList   =  c.getParameters();
			System.out.println("构造参数列表: " + Arrays.toString(paraList));
		}
	}
	
	@Test
	public void getMethods() {
		Class<?> clazz = new YGOCard().getClass();
		Method[] methods = clazz.getMethods();
		for(Method m : methods) {
			System.out.println("方法名: " + m.getName());
			Parameter[] paraList = m.getParameters();
			System.out.println("参数列表: " + Arrays.toString(paraList));
			System.out.println("返回类型: " + m.getReturnType());
		}
	}
	
	@Test
	public void getFields() throws ClassNotFoundException {
		Class<?> clazz = Class.forName("reflection.YGOCard");
		Field[] fields = clazz.getFields();
		for(Field f : fields) {
			System.out.println("成员变量名:" +f.getName());
			System.out.println("成员变量类型" + f.getType());
		}
	}
	
	@Test
	public void createObject() throws Exception {
		Class<?> clazz = YGOCard.class;
		//无参构造
		Object o = clazz.newInstance();
		//含参构造
		Constructor constructor = clazz.getConstructor(String.class, int.class, String.class, String.class);
		Object obj = constructor.newInstance("天空侠", 4, "效果怪兽", "①此卡召唤成功时,将一张Hero卡置于手卡.");
		if(obj instanceof YGOCard) {
			YGOCard card = (YGOCard)obj;
			System.out.println("卡片名: "+ card.getName());
		}
	}
}


class YGOCard{
	public String name;
	public int rank;
	public String type;
	public String effects;
	public YGOCard() {}
	public YGOCard(String name, int rank, String type, String effects) {
		super();
		this.name = name;
		this.rank = rank;
		this.type = type;
		this.effects = effects;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEffects() {
		return effects;
	}
	public void setEffects(String effects) {
		this.effects = effects;
	}
	@Override
	public String toString() {
		return "YGOCard [name=" + name + ", rank=" + rank + ", type=" + type + ", effects=" + effects + "]";
	}
	
}