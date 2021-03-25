package day2;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 
 *
 */
public class Test_BigDecimal {
	
	public static void main(String[] args) {
		//1. ��ʾ�������û����������С��
		System.out.println("������С��1:");
		Scanner in = new Scanner(System.in);
		String a = in.next();
		System.out.println("������С��2 :");
		String b = in.next();
		
		//2. ����BigDecimal����,�ֱ�a b ����bd1 bd2����,��ò�Ҫʹ��double��Ϊ���캯���Ĳ���,��Ȼ���ǻ᲻��ȷ
		BigDecimal bdA = new BigDecimal(a);
		BigDecimal bdB = new BigDecimal(b);
		
		
		//3. ͨ��BigDecimal���������� �� add, ��subtract, ��multiply, ��divide
		BigDecimal bdResult = bdA.subtract(bdB);
		
		//divide��������������ᱨ��, .divide(divisor, scale, roundingMode),scale:����С��, roundingMode: ��λ��ʽ.
		bdA.divide(bdB, 3, BigDecimal.ROUND_HALF_UP);
		
		System.out.println(bdA + "-" + bdB + "=" + bdResult);
		System.out.println(1-0.8);
	}
}
