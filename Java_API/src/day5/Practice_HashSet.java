package day5;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 如果想让Set不添加相同属性的对象,需要重写HashCode 和 equals
 * 
 */
public class Practice_HashSet {
	public static void main(String[] args) {
		Student s1 = new Student("111", 11, "111", "male");
		Student s2 = new Student("222", 22, "222", "female");
		Student s3 = new Student("333", 33, "333", "male");
		Student s4 = new Student("111", 11, "111", "male");
		HashSet<Student> studentSet = new HashSet<Student>();
		studentSet.add(s1);
		studentSet.add(s2);
		studentSet.add(s3);
		studentSet.add(s4);
		Iterator<Student> iterator = studentSet.iterator();
		while(iterator.hasNext()) System.out.println(iterator.next());
		
	}
		
}
