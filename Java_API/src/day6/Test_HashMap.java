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
		System.out.println("ÿ���ַ����ִ���: " + hashMap);
	}
	
	
	public static void main(String[] args) {
		/**
		 * ��ʼ������16 --> 1<<4= ��1����4λ 10000(2)=16
		 * ��������:0.75f
		 * ������������˳�ʼ����*��������,��Ҫ����
		 * ���ݻ����¿��ٿռ�,���¼�������Ԫ�ص�λ��
		 * Ҳ��rehash
		 * ������������Ƴ�ʼ������������ӵ�ʱ��Ҫ���
		 * ƽ��,����������ӹ�����rehash����ƽ��
		 * �����ʼ������Ƶ�̫�����������̫��,Ӱ���ѯЧ��
		 */
		Test_HashMap th = new Test_HashMap();
		th.count("aaabbb");
		
	}
}
