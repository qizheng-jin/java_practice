import java.util.HashMap;

/**
 *  找到字符串中重复字符出现的次数
 */
public class Hashmap_Practice {
	public HashMap<Character, Integer> repeat(String s) {
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			Integer value = hashMap.get(c);
			if(value == null) {
				hashMap.put(c, 1);
			}else {
				hashMap.put(c, value+1);
			}
		}
		System.out.println("字母出现次数"+hashMap);
		return hashMap;
	}
	
	public static void main(String[] args) {
		Hashmap_Practice hp = new Hashmap_Practice();
		hp.repeat("asdxzcewqrxzasewqxzewqsadxz");
	}
}
