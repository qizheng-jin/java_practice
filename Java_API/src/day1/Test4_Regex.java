package day1;

import java.util.Scanner;

/**
 * 
 * �������ڲ���������ʽ
 * ����:�����û���������֤��,�����Ƿ�������ȷ
 *
 */
public class Test4_Regex {
	public static void main(String[] args) {
		System.out.println("���������֤��");
		String input = new Scanner(System.in).nextLine();
		//2. �༭������ʽ
		//���֤����:18λ,ǰ17λ������
		//���һλ����������Ҳ������x����X
		String regex = "[0-9]{17}[0-9X]";
		//3. �ж�,�Ƿ����������ʽ����
		if(input.matches(regex)) {
			System.out.println("������ȷ");
			return ;
		}
		System.out.println("�������");
	}
}
