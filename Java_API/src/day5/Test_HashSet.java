package day5;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * 用来测试set的接口
 *
 */
public class Test_HashSet {
	public static void main(String[] args) {
		
		Set<String> set = new HashSet<String>();
		
		//存放数据用于测试
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("DEF");
		set.add("a");
		set.add("A");
		set.add(null); // 可以加空元素,甚至会打印出来
		
		System.out.println(set);
		/**set中的元素是无序的且不能重复*/
		System.out.println(set.contains("B"));
		set.remove("C");
		System.out.println(set.equals("A"));
		set.retainAll(set);//取交集
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) System.out.println(iterator.next());
		System.out.println("*************************");
		for(String s : set) {
			System.out.println(s);
		}
		
		
	}
}
