package day3;

/**
 * //Ctrl+s 执行  Ctrl+f11执行  Ctrl+fn+f11执行 ,注意禁用系统快捷键
 * public --公共的，用来修饰谁可以访问这个类
 * class ---类
 * Helloworld -- 给这个类起的名字，每个单词首字母大写
 * {类的主体内容}
 * 
 *
 */
public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		//三目运算符求最大值
		int a =  0;
		int b = 1;
		int c = 2;
		int max = a>b?(a>c?a:c):(b>c?b:c);
		System.out.println("max is " + max);
		
	}

}
