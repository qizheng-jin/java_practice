package day5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Test_ArrayList {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();//��ָ�������Ļ�����ʼ������10
		List l;
		list.add(213);
		list.add(146);
		list.remove(0); //���±�ɾ��
		//list.remove(146);�ᱨ����Ϊ����Ĭ�����±�
		list.remove(Integer.valueOf(146)); //����ɾ��int����Ԫ�صĵ�ͨ�÷���
		list.add(213);
		list.add(146);
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		ListIterator<Integer> li = list.listIterator();
	}
}
