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
	//������ϰ
	while(true) {
		System.out.println("����������������");
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		String s = "������";
		if(a <= 1) {
			System.out.println("С��2��������������");
		}else {
		for(int i=2; i<a; i++) {
			if(a%i == 0) { 
				s = "��������";
				System.out.println("��" + i +"����");
				break;
				}
			}
		System.out.println(a + s);
		}
	}
	}
}