package day6;

import java.util.HashMap;
import java.util.Map.Entry;

public class Test_HashMap {
	private HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
	
	public void count(String s) {
		for(int i=0; i<s.length(); i++) {
			char k = s.charAt(i);
			Integer value = hashMap.get(k);
			if(value == null) {
				hashMap.put(k, 1);
			}else {
				hashMap.put(k, value+1);
			}
		}
		System.out.println("每个字符出现次数: " + hashMap);
	}
	
	
	public static void main(String[] args) {
		/**
		 * 初始容量是16 --> 1<<4= 将1左移4位 10000(2)=16
		 * 加载因子:0.75f
		 * 如果容量打捞了初始容量*加载因子,需要扩容
		 * 扩容会重新开辟空间,重新计算所有元素的位置
		 * 也叫rehash
		 * 所以我们在设计初始容量与加载因子的时候要相对
		 * 平衡,如果加载因子过低则rehash过于平凡
		 * 如果初始容量设计的太高则加载容量太高,影响查询效率
		 */
		Test_HashMap th = new Test_HashMap();
		th.count("aaabbb");
		
	}
}
