package day4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class Test_Collection {
	
	public static void main(String[] args) {
		//1. 创建Collection接口对象,collection是接口不能实例化
		Collection<Integer> list = new ArrayList<Integer>();
		list.add(100);
		list.add(200);
		list.add(300);
		list.add(400);
		list.add(500);
		System.out.println(list);//直接打印查看集合中的元素
		System.out.println(list.hashCode()); //返回hashcode值
		Object[] a = list.toArray(); //返回值必须是Object[]
		
		Collection<Integer> list2 = new ArrayList<Integer>();
		list2.add(100);
		list2.add(200);
		list2.add(300);
		list2.add(400);
		list2.add(5);
		list2.size();
		System.out.println(list.retainAll(list2)); //只保留list中所有跟list2相同的元素
		System.out.println(list);
		
		//2.3 遍历/迭代集合中的元素 list.iterator
		/**
		 * 1. 获取iterator
		 * 2. 判断是否有下个元素 iterator.hasNext()
			3. 获取当前迭代到的元素 iterator.next()
		 * 
		 */
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			int i = iterator.next();
			System.out.println(i);
		}
		
		for(int i: list) {
			System.out.println(i);
		}
		
		
	}
}
