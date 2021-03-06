package day3;

import java.util.Scanner;

/**
 * 
 * 运算符
 *
 */
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
		
		int year = 1900;
		String result = "是平年";
		if(year%4 == 0 && year%100 != 0 || year%400 == 0) {
			result = "是闰年";
		}
		System.out.println(year + "是" + result);
		
		double price = 2500;
		double payment = 0;
		if(price<1000) payment = price;
		if(price>=1000 && price<2000) payment = price*0.9;
		if(price>=2000 && price<5000) payment = price*0.8;
		if(price>=5000) payment = price*0.5;
		System.out.println("用户应该给: " + payment + "元");
		
		/**
		 *	switch-case方法
		 */
		Scanner in = new Scanner(System.in);
		System.out.println("请输入商品价格");
		int m = 2;
		double p = in.nextDouble();
		/**
		 * 总结1: m支持5种类型 byte short char int, jdk1.5之后也支持String
		 */
		switch(m){
			case 1: System.out.println(1); break;
			case 2: System.out.println(2);
			
			default: System.out.println(0);
		}
		
		
	}
}
