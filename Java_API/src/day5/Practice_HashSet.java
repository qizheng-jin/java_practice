package day5;

import java.util.HashSet;
import java.util.Iterator;

/**
 * �������Set�������ͬ���ԵĶ���,��Ҫ��дHashCode �� equals
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
