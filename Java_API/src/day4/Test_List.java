package day4;


import java.util.ArrayList;
import java.util.List;

public class Test_List {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("�����");
		list.add("������");
		list.add("ħ����");
		list.add("������");
		list.add("������");
		list.add("������");
		list.add("������");
		System.out.println(list.hashCode());
	}
}
