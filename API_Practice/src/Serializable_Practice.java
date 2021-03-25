import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * 序列化和反序列化Teacher类的对象
 *
 */
public class Serializable_Practice {
	public void serialTeacher(Teacher t, File file) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(t);
			System.out.println("序列化成功");
		} catch (IOException e) {
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
	
	public Object antiSerialTeacher(File file){
		ObjectInputStream ois = null;
		Object o = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			int d;
			o = ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
		File file = new File("test.txt");
		Teacher t = new Teacher("易先明", 60, "男", "语文");
		Serializable_Practice sp = new Serializable_Practice();
		sp.serialTeacher(t, file);
		Object o = null;
		System.out.println(o = sp.antiSerialTeacher(file));
		if(o instanceof Teacher) {
			Teacher teacher = (Teacher)o;
			System.out.println("老师名字是: " + teacher.getName());
		}

	}
}

class Teacher implements Serializable{
	private String name;
	private int age;
	private String gender;
	private String subject;
	
	
	public Teacher(String name, int age, String gender, String subject) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.subject = subject;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}


	@Override
	public String toString() {
		return "Teacher [name=" + name + ", age=" + age + ", gender=" + gender + ", subject=" + subject + "]";
	}
	
	
}