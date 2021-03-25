package day4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * ��ObjectOutputStream��������Ϣȫ�����л�
 * ��ObjectInputStream�����л��õ�����
 * 
 *
 */
public class Test_Serializable {
	
	public static void method1() {
		ObjectOutputStream oos = null;
		try {
			 oos = new ObjectOutputStream(new FileOutputStream("test.txt"));
			
			//ͨ��OOS������л�����
			Student s = new Student("Сǿ", 10, "male", "�人");
			oos.writeObject(s);
			System.out.println("���л�,�ɹ�");
		} catch (IOException e) {
			System.out.println("���л�,ʧ��");
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
			System.out.println("�����л��ɹ�,������: "+o.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("�����л�ʧ��");
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
