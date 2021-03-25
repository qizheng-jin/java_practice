package day4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class Test_Collection {
	
	public static void main(String[] args) {
		//1. ����Collection�ӿڶ���,collection�ǽӿڲ���ʵ����
		Collection<Integer> list = new ArrayList<Integer>();
		list.add(100);
		list.add(200);
		list.add(300);
		list.add(400);
		list.add(500);
		System.out.println(list);//ֱ�Ӵ�ӡ�鿴�����е�Ԫ��
		System.out.println(list.hashCode()); //����hashcodeֵ
		Object[] a = list.toArray(); //����ֵ������Object[]
		
		Collection<Integer> list2 = new ArrayList<Integer>();
		list2.add(100);
		list2.add(200);
		list2.add(300);
		list2.add(400);
		list2.add(5);
		list2.size();
		System.out.println(list.retainAll(list2)); //ֻ����list�����и�list2��ͬ��Ԫ��
		System.out.println(list);
		
		//2.3 ����/���������е�Ԫ�� list.iterator
		/**
		 * 1. ��ȡiterator
		 * 2. �ж��Ƿ����¸�Ԫ�� iterator.hasNext()
			3. ��ȡ��ǰ��������Ԫ�� iterator.next()
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
