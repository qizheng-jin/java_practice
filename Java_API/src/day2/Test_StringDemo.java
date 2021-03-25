package day2;

public class Test_StringDemo {
	public static void main(String[] args) {
		//1. 创建String对象的两种方式
		char[] value = {'a', 'b', 'c'};
		String s = new String(value);
		String s2 = "abc";
		s = "ab";
		s += "c";
		System.out.println(s == s2);
		
		System.out.println(s2.endsWith("c"));
		System.out.println(s2.indexOf("c"));
		System.out.println(s2.charAt(2));
		System.out.println(s2.concat("cxy"));//拼接字符串但需要用一个新字符串接收
		System.out.println(s2.contentEquals("abc"));
	}
}
