package java_thread;

import java.util.HashMap;

/**用hashmap判断字符串重复次数*/
public class Practice_HashMap {
	public static void repeat(String line) {
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		for(int i=0; i<line.length(); i++) {
			char key = line.charAt(i);
			Integer value = hashMap.get(key);
			if(value == null)
				hashMap.put(key, 1);
			else
				hashMap.put(key, value+1);
		}
		
		System.out.println(hashMap);
	}
	
	public static void main(String[] args) {
		String s = "asdwqdxzcesadzsdqwecxz";
		repeat(s);
	}
}
