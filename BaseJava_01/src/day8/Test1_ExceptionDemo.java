package day8;
/**
 * 如果方法抛出异常,那么谁调用谁需要解决,
 * 如果main方法没有捕获处理method2中的异常,那就需要继续抛出异常
 * 所以不提倡在main方法中捕获异常,应该在main方法之前就捕获异常 
 */
import java.util.InputMismatchException;

import java.util.Scanner;

public class Test1_ExceptionDemo {
	
	
	public static void method(){
		//2.1提示并接收用户输入的两个整数
		System.out.println("请输入您要计算的第一个数");
		int a = new Scanner(System.in).nextInt();
		System.out.println("请输入计算的第二个数");
		int b = new Scanner(System.in).nextInt();
		//2.2输出出发运算的结果
		System.out.println(a/b);
	}
	
	/**
	 * 捕获的语法规则
	 * try{
	 *   可能会出现的异常的代码
	 * }catch{
	 *   如果捕获到异常的对应解决方案
	 * }
	 */
	public static void method1() {
		try {
			//2.1提示并接收用户输入的两个整数
			System.out.println("请输入您要计算的第一个数");
			int a = new Scanner(System.in).nextInt();
			System.out.println("请输入计算的第二个数");
			int b = new Scanner(System.in).nextInt();
			//2.2输出出发运算的结果
			System.out.println(a/b);
		}catch(InputMismatchException e){
			System.out.println("输入类型不是整数");
		}catch(ArithmeticException e) {
			System.out.println("除数不能为零");
			//只要是异常，可以直接用Exception catch
		}catch(Exception e) {
			System.out.println("请输入正确的整数");
		}
	}
	
	/**
	 * 
	 * 抛出异常:
	 * 在可能会出现异常的方法上,加上throws异常类型
	 * 在抛出时,也可以用多态,直接throws Exception
	 */
	public static void method2() throws InputMismatchException, ArithmeticException{
		//2.1提示并接收用户输入的两个整数
		System.out.println("请输入您要计算的第一个数");
		int a = new Scanner(System.in).nextInt();
		System.out.println("请输入计算的第二个数");
		int b = new Scanner(System.in).nextInt();
		//2.2输出出发运算的结果
		System.out.println(a/b);
	}
	
	public static void main(String[] args) {
			method();
			

	}
	
}
