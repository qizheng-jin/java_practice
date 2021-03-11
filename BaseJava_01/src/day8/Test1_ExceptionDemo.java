package day8;
/**
 * ��������׳��쳣,��ô˭����˭��Ҫ���,
 * ���main����û�в�����method2�е��쳣,�Ǿ���Ҫ�����׳��쳣
 * ���Բ��ᳫ��main�����в����쳣,Ӧ����main����֮ǰ�Ͳ����쳣 
 */
import java.util.InputMismatchException;

import java.util.Scanner;

public class Test1_ExceptionDemo {
	
	
	public static void method(){
		//2.1��ʾ�������û��������������
		System.out.println("��������Ҫ����ĵ�һ����");
		int a = new Scanner(System.in).nextInt();
		System.out.println("���������ĵڶ�����");
		int b = new Scanner(System.in).nextInt();
		//2.2�����������Ľ��
		System.out.println(a/b);
	}
	
	/**
	 * ������﷨����
	 * try{
	 *   ���ܻ���ֵ��쳣�Ĵ���
	 * }catch{
	 *   ��������쳣�Ķ�Ӧ�������
	 * }
	 */
	public static void method1() {
		try {
			//2.1��ʾ�������û��������������
			System.out.println("��������Ҫ����ĵ�һ����");
			int a = new Scanner(System.in).nextInt();
			System.out.println("���������ĵڶ�����");
			int b = new Scanner(System.in).nextInt();
			//2.2�����������Ľ��
			System.out.println(a/b);
		}catch(InputMismatchException e){
			System.out.println("�������Ͳ�������");
		}catch(ArithmeticException e) {
			System.out.println("��������Ϊ��");
			//ֻҪ���쳣������ֱ����Exception catch
		}catch(Exception e) {
			System.out.println("��������ȷ������");
		}
	}
	
	/**
	 * 
	 * �׳��쳣:
	 * �ڿ��ܻ�����쳣�ķ�����,����throws�쳣����
	 * ���׳�ʱ,Ҳ�����ö�̬,ֱ��throws Exception
	 */
	public static void method2() throws InputMismatchException, ArithmeticException{
		//2.1��ʾ�������û��������������
		System.out.println("��������Ҫ����ĵ�һ����");
		int a = new Scanner(System.in).nextInt();
		System.out.println("���������ĵڶ�����");
		int b = new Scanner(System.in).nextInt();
		//2.2�����������Ľ��
		System.out.println(a/b);
	}
	
	public static void main(String[] args) {
			method();
			

	}
	
}
