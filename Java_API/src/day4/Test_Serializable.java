package day4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 用ObjectOutputStream将对象信息全部序列化
 * 用ObjectInputStream反序列化得到对象
 * 
 *
 */
public class Test_Serializable {
	
	public static void method1() {
		ObjectOutputStream oos = null;
		try {
			 oos = new ObjectOutputStream(new FileOutputStream("test.txt"));
			
			//通过OOS完成序列化操作
			Student s = new Student("小强", 10, "male", "武汉");
			oos.writeObject(s);
			System.out.println("序列化,成功");
		} catch (IOException e) {
			System.out.println("序列化,失败");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static Object method2() {
		ObjectInputStream ois = null;
		Object o = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("test.txt"));
			o = ois.readObject();
			System.out.println("反序列化成功,对象是: "+o.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("反序列化失败");
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return o;
	}
	
	public static void main(String[] args) {
		method1();
		method2();
	}
}
