package day2;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 
 *
 */
public class Test_BigDecimal {
	
	public static void main(String[] args) {
		//1. 提示并接收用户输入的两个小数
		System.out.println("请输入小数1:");
		Scanner in = new Scanner(System.in);
		String a = in.next();
		System.out.println("请输入小数2 :");
		String b = in.next();
		
		//2. 创建BigDecimal对象,分别将a b 交给bd1 bd2保存,最好不要使用double作为构造函数的参数,不然还是会不精确
		BigDecimal bdA = new BigDecimal(a);
		BigDecimal bdB = new BigDecimal(b);
		
		
		//3. 通过BigDecimal做精密运算 加 add, 减subtract, 乘multiply, 除divide
		BigDecimal bdResult = bdA.subtract(bdB);
		
		//divide方法如果除不尽会报错, .divide(divisor, scale, roundingMode),scale:保留小数, roundingMode: 进位方式.
		bdA.divide(bdB, 3, BigDecimal.ROUND_HALF_UP);
		
		System.out.println(bdA + "-" + bdB + "=" + bdResult);
		System.out.println(1-0.8);
	}
}
