package day4;

import java.util.ArrayList;

/**
 * 
 * �������ڲ��Է��͵��ŵ�
 *
 */
public class Test_Generic {
	
	/**
	 * 
	 * ���ͷ�������ʵ��ͨ�ô���ı�д,ʹ��E��ʾԪ��������Element����--�����������ƶ�̬
	 * ���͵��﷨Ҫ��:����� ������ʹ�÷���,��������ͬʱ����
	 * 
	 */
	public static <E> void genericPrint(E[] e){
		for(E i: e) {
			System.out.println(i.toString());
		}
		
	}
	
	public static void main(String[] args) {
		String[] s = new String[3];
		s[0] = "��[0]";
		s[1] = "��[1]";
		s[2] = "��[2]";
		genericPrint(s);
		/**������Ҫģ��������������ͼ��*/
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(123);
		list.add(123);
		System.out.println(list);
		
		/**
		 * ���뷺��ȥԼ�������е�Ԫ������
		 * <typename> ��Ҫ���ʲô���;Ͷ���ʲô����
		 * �������ǻ������ͱ�������������
		 *  
		 * 
		 * */
		
	}
}
