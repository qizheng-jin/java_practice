package day1;

import java.util.Scanner;

/**��װ��*/
public class Test_Number {
	public void method() {
		int a = new Scanner(System.in).nextInt();
	}
	
	public static void main(String[] args) {
		
		
		Integer i1 = new Integer(5);
		
		Integer i2 = Integer.valueOf(6);
		
		Integer i3 = Integer.valueOf(300);//Խ����-127-128
		Integer i4 = Integer.valueOf(300);//Խ����-127-128
		System.out.println(i3 == i4);//Խ����
		/**
		 * ��Χ����ͬ������ֻ���һ��,����ʹ�õ��������Ѿ����������
		 */
		Integer i5 = Integer.valueOf(127);
		Integer i6 = Integer.valueOf(127);
		System.out.println(i5 == i6); //�����Ϊֵ����һ��,ֻ��Integer��������
		
		Double d1 = new Double(3.4);
		Double d2 = Double.valueOf(3.4);
		System.out.println(d1 == d2);
		
		
	}
}
