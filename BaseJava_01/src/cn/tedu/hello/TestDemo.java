package cn.tedu.hello;

public class TestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1;
		System.out.println(a++); //先打印再自加，自加的运算优先级是最高的
		System.out.println(a); //先自加再打印
		int b = 1;
		System.out.println(--b);
		System.out.println(b);
		int c = 2;
		System.out.println(c++*2);// 自加符号在变量后的时候，不影响打印
		int d = 2;
		System.out.println(++d*2);
		
		//三目运算符
		System.out.println(2<3?"正确":"错误");
	}
}
