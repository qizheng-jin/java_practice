package day5;

import java.util.LinkedList;

public class Test_LinkedList {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList();
		
		list.add("�����");
		list.add("��˽�");
		list.add("ɳʦ��");
		list.add("������");
		list.add("������");
		list.offer("��Ǵ���");//offer��addһ��
		list.addFirst("�����ү!");
		list.element();//��ѯ��Ԫ��
		System.out.println(list.indexOf("�����"));
		
		list.remove("��Ǵ���");
		
	}
}
