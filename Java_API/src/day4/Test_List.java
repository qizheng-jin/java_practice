package day4;


import java.util.ArrayList;
import java.util.List;

public class Test_List {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Ìì¿ÕÏÀ");
		list.add("ÔöÁ¿ÏÀ");
		list.add("Ä§ĞÔÏÀ");
		list.add("¶ÀÉÆÏÀ");
		list.add("º£ëàÏÀ");
		list.add("ĞÂÓîÏÀ");
		list.add("·ÂÉúÏÀ");
		System.out.println(list.hashCode());
	}
}
