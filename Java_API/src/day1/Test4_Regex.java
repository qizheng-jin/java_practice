package day1;

import java.util.Scanner;

/**
 * 
 * 本类用于测试正则表达式
 * 需求:接受用户输入的身份证号,测试是否输入正确
 *
 */
public class Test4_Regex {
	public static void main(String[] args) {
		System.out.println("请输入身份证号");
		String input = new Scanner(System.in).nextLine();
		//2. 编辑正则表达式
		//身份证规律:18位,前17位是数字
		//最后一位可能是数字也可能是x或者X
		String regex = "[0-9]{17}[0-9X]";
		//3. 判断,是否符合正则表达式规则
		if(input.matches(regex)) {
			System.out.println("输入正确");
			return ;
		}
		System.out.println("输入错误");
	}
}
