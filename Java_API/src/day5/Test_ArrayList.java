package day5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Test_ArrayList {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();//不指定容量的话，初始容量是10
		List l;
		list.add(213);
		list.add(146);
		list.remove(0); //按下标删除
		//list.remove(146);会报错因为它会默认找下标
		list.remove(Integer.valueOf(146)); //这是删除int类型元素的的通用方法
		list.add(213);
		list.add(146);
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		ListIterator<Integer> li = list.listIterator();
	}
}
