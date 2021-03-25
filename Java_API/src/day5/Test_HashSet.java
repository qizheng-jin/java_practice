package day5;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * ��������set�Ľӿ�
 *
 */
public class Test_HashSet {
	public static void main(String[] args) {
		
		Set<String> set = new HashSet<String>();
		
		//����������ڲ���
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("DEF");
		set.add("a");
		set.add("A");
		set.add(null); // ���Լӿ�Ԫ��,�������ӡ����
		
		System.out.println(set);
		/**set�е�Ԫ����������Ҳ����ظ�*/
		System.out.println(set.contains("B"));
		set.remove("C");
		System.out.println(set.equals("A"));
		set.retainAll(set);//ȡ����
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) System.out.println(iterator.next());
		System.out.println("*************************");
		for(String s : set) {
			System.out.println(s);
		}
		
		
	}
}
