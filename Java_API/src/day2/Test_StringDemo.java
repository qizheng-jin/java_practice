package day2;

public class Test_StringDemo {
	public static void main(String[] args) {
		//1. ����String��������ַ�ʽ
		char[] value = {'a', 'b', 'c'};
		String s = new String(value);
		String s2 = "abc";
		s = "ab";
		s += "c";
		System.out.println(s == s2);
		
		System.out.println(s2.endsWith("c"));
		System.out.println(s2.indexOf("c"));
		System.out.println(s2.charAt(2));
		System.out.println(s2.concat("cxy"));//ƴ���ַ�������Ҫ��һ�����ַ�������
		System.out.println(s2.contentEquals("abc"));
	}
}
