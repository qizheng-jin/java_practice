package day1;

import java.util.Arrays;

public class Test_String {
	public static void main(String[] args) {
		char[] data = {'a', 'b', 'c'};
		String s1 = new String(data);
		
		String s2 = "abc";
		//地址值不一样
		System.out.println(s1 == s2);
		System.out.println(s2.charAt(0));
		System.out.println(s2.concat("cxy"));//拼接到结尾
		System.out.println(s2.endsWith("c"));
		System.out.println(s2.equals(s1));//String的equals重写了比较两个String的内容
		System.out.println(s2.getBytes());//将字符串变成byte[]数组
		System.out.println(s2.indexOf("c"));//获取c字符在字符串中出现的第一次位置值
		System.out.println(s2.lastIndexOf('c'));//获取c字符在字符串最后一次出现的位置
		System.out.println(s2.length());//获取字符串的长度
		
		s2 = "a b c d e";
		System.out.println(s2.split("")); //split方法是以某一字符或字符串为分界线,将字符串分为两部分,分界线两边都不占
		System.out.println(Arrays.toString(s2.split("b")));
		System.out.println(s2.startsWith("a"));//true,判断是否以a开头
		
		System.out.println(s2.substring(5)); //从下标为n的地方开始截取字符串
		System.out.println("***********************");
		System.out.println(s2.substring(1, 3));//从下标为x到下标为y的地方截取字符串，左闭右开
		System.out.println(s2.toUpperCase() +" &&& "+ s2.toLowerCase());//变大小写
		System.out.println(s2.trim());//去除多余的空格
		
		System.out.println(String.valueOf(10) + 10);//将别的基本类型转化为string输出
	}
}
