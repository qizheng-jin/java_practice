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
 * HashMap��Key�ǲ����ظ���
 * Key������Ϊ������value��
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
	
	map.containsKey(10);//�Ƿ���key��10
	map.containsValue("A");//�Ƿ���AԪ��
	System.out.println(map);
	
	Collection<String> keyset = map.values(); //��map�е�values����collection��
	
	/**
	 * ��Ҫ����map�е�����,��Ҫ�Ȱ�mapת��Ϊset����
	 * Set<Key> keySet(): ��map�����е�����K�浽set������
	 */
	
	Set<Integer> keySet = map.keySet();
	Iterator<Integer> it = keySet.iterator();
	while(it.hasNext()) {
		int key = it.next();
		System.out.println("Key is " + key);
		System.out.println("Value is " + map.get(key));
	}
	                                                   
	
	/**
	 * ��map�е�key��valueȫ������һ����ά����
	 * Entry�������Ϊ��Map�е�һ���ڲ��ӿ�,��������һ�ԶԵļ�ֵ��
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
