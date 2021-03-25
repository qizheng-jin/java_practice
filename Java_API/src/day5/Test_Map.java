package day5;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * HashMap中Key是不能重复的
 * Key作用是为了索引value的
 *
 */
public class Test_Map {
	public static void main(String[] args) {	
	Map<Integer, String> map = new HashMap<Integer, String>();
	
	map.put(10, "A");
	map.put(20, "B");
	map.put(30, "C");
	
	map.put(40, "D");
	map.put(50, "A");
	
	map.containsKey(10);//是否有key是10
	map.containsValue("A");//是否有A元素
	System.out.println(map);
	
	Collection<String> keyset = map.values(); //将map中的values放在collection中
	
	/**
	 * 想要遍历map中的数据,需要先把map转化为set集合
	 * Set<Key> keySet(): 把map集合中的所有K存到set集合中
	 */
	
	Set<Integer> keySet = map.keySet();
	Iterator<Integer> it = keySet.iterator();
	while(it.hasNext()) {
		int key = it.next();
		System.out.println("Key is " + key);
		System.out.println("Value is " + map.get(key));
	}
	                                                   
	
	/**
	 * 把map中的key和value全部传入一个二维数组
	 * Entry可以理解为是Map中的一个内部接口,用来储存一对对的键值对
	 */
	Set<Entry<Integer, String>> entrySet = map.entrySet();
	Iterator<Entry<Integer, String>> iterator = entrySet.iterator();
	while(iterator.hasNext()) {
		System.out.println(iterator.next());
	}
	System.out.println("****************");
	for(Entry<Integer, String> entry: entrySet) {
		System.out.println(entry);
	}
	
	
	}
}
