package day6;

import java.util.Deque;
import java.util.LinkedList;

public class Queue {
	/**
	 * 
	 * Queue�Ǽ̳���Collection�Ľӿ�֮һ
	 * ����ͨ�����Ƚ��ȳ��ķ�ʽ�������Ԫ��
	 * ������Ԫ�ض����������н�β
	 * 
	 * add -- �������β��
	 * peek -- ��ȡ����ͷ�������Ƴ�
	 * poll -- ��ȡ����ͷ�� �����Ƴ�
	 * remove -- ��ȡ���Ƴ��ζ��е�ͷ
	 * 
	 * DequeҲ�Ǽ̳���Collection�Ľӿڣ�Ҳ�Ǽ̳���Queue�Ľӿ�
	 * 		Deque��ʵ���ࣺ LinkedList�� ArrayDeque
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
