package day4;

import java.util.ArrayList;

/**
 * 
 * 本类用于测试泛型的优点
 *
 */
public class Test_Generic {
	
	/**
	 * 
	 * 泛型方法可以实现通用代码的编写,使用E表示元素类型是Element类型--可以理解成神似多态
	 * 泛型的语法要求:如果是 方法上使用泛型,必须两处同时出现
	 * 
	 */
	public static <E> void genericPrint(E[] e){
		for(E i: e) {
			System.out.println(i.toString());
		}
		
	}
	
	public static void main(String[] args) {
		String[] s = new String[3];
		s[0] = "是[0]";
		s[1] = "是[1]";
		s[2] = "是[2]";
		genericPrint(s);
		/**泛型想要模拟数组的数据类型检查*/
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(123);
		list.add(123);
		System.out.println(list);
		
		/**
		 * 引入泛型去约束集合中的元素类型
		 * <typename> 需要存放什么类型就定义什么类型
		 * 但不能是基本类型必须是引用类型
		 *  
		 * 
		 * */
		
	}
}
