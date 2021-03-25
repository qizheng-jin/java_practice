package day5;

import java.util.LinkedList;

public class Test_LinkedList {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList();
		
		list.add("孙悟空");
		list.add("猪八戒");
		list.add("沙师弟");
		list.add("唐三藏");
		list.add("白龙马");
		list.offer("金角大王");//offer和add一样
		list.addFirst("干你大爷!");
		list.element();//查询首元素
		System.out.println(list.indexOf("孙悟空"));
		
		list.remove("金角大王");
		
	}
}
