package day3;

import java.util.Scanner;

/**
 * 
 * �����
 *
 */
public class TestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1;
		System.out.println(a++); //�ȴ�ӡ���Լӣ��Լӵ��������ȼ�����ߵ�
		System.out.println(a); //���Լ��ٴ�ӡ
		int b = 1;
		System.out.println(--b);
		System.out.println(b);
		int c = 2;
		System.out.println(c++*2);// �Լӷ����ڱ������ʱ�򣬲�Ӱ���ӡ
		int d = 2;
		System.out.println(++d*2);
		
		//��Ŀ�����
		System.out.println(2<3?"��ȷ":"����");
		
		int year = 1900;
		String result = "��ƽ��";
		if(year%4 == 0 && year%100 != 0 || year%400 == 0) {
			result = "������";
		}
		System.out.println(year + "��" + result);
		
		double price = 2500;
		double payment = 0;
		if(price<1000) payment = price;
		if(price>=1000 && price<2000) payment = price*0.9;
		if(price>=2000 && price<5000) payment = price*0.8;
		if(price>=5000) payment = price*0.5;
		System.out.println("�û�Ӧ�ø�: " + payment + "Ԫ");
		
		/**
		 *	switch-case����
		 */
		Scanner in = new Scanner(System.in);
		System.out.println("��������Ʒ�۸�");
		int m = 2;
		double p = in.nextDouble();
		/**
		 * �ܽ�1: m֧��5������ byte short char int, jdk1.5֮��Ҳ֧��String
		 */
		switch(m){
			case 1: System.out.println(1); break;
			case 2: System.out.println(2);
			
			default: System.out.println(0);
		}
		
		
	}
}