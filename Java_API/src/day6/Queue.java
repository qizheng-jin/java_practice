package day6;

import java.util.Deque;
import java.util.LinkedList;

public class Queue {
	/**
	 * 
	 * Queue是继承于Collection的接口之一
	 * 队列通常是先进先出的方式排序各个元素
	 * 所有新元素都必须插入队列结尾
	 * 
	 * add -- 插入队列尾部
	 * peek -- 获取队列头，但不移除
	 * poll -- 获取队列头， 并且移除
	 * remove -- 获取并移除次队列的头
	 * 
	 * Deque也是继承于Collection的接口，也是继承于Queue的接口
	 * 		Deque的实现类： LinkedList， ArrayDeque
	 * 
	 */
	public static void main(String[] args) {
		String str = "LEA";
		Deque<Character> stack = new LinkedList<Character>();
		for(int i=0; i<str.length(); i++) {
			stack.push(str.charAt(i));
		}
		
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(stack.peek());
	}
}
