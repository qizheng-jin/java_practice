package day3;

import java.util.Scanner;

public class For_loop {
	public static void main(String[] args) {
		int result = 8;
		int times = 10;
		for(int i=0; i<4; i++) {
			System.out.println(result);
			result = 10*result + 8;
		}
	//质数练习
	while(true) {
		System.out.println("请输入任意正整数");
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		String s = "是质数";
		if(a <= 1) {
			System.out.println("小于2的数都不是质数");
		}else {
		for(int i=2; i<a; i++) {
			if(a%i == 0) { 
				s = "不是质数";
				System.out.println("被" + i +"整除");
				break;
				}
			}
		System.out.println(a + s);
		}
	}
	}
}
