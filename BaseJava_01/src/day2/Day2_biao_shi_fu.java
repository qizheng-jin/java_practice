package day2;

import java.util.Scanner;

/**
 * 
 * 标识符可以由字母、数字、下划线、美元符组成，但是不能包含@、%、空格等
 * 其它特殊字符。
 * 不能以数字开头
 * 严格区分大小写
 * 标识符不能是java关键字
 *
 */

/**
 * eclipse快捷键一览:
 * 建立构造函数/getters/setters: alt + shift + s
 * 运行java: ctrl + F11
 * 快速打出System.out.println(); : sout + alt + /
 * 快速导入包: ctrl + shift + m.
 * 快速删除一行： ctrl + d
 * 快速选中一行 ： 删除加返回上一步
 * 快速纠错： ctrl + 数字1;
 * 查看类继承的快捷键: ctrl + T;
 * 自动储存变量地址: 写好new的对象 然后按 alt + shift + L;
 * 整理代码格式: CTRL+i;
 * 代码向上移动: ALT + 方向键上
 */




public class Day2_biao_shi_fu {
	
	
	  public static void main(String[] args) {
		  System.out.println("曼城天下第一!");
		  String name = "德布劳内";
		  int age = 30;
		  double salary = 10000;
		  
		  System.out.println("他叫" + name + ", 他" + age + "岁" +
				  			"他的薪资是" + salary + "磅/每天");
		  
		  System.out.println("byte最大值是" + Byte.MAX_VALUE);
		  System.out.println("byte最小值是" + Byte.MIN_VALUE);
		  System.out.println("short最大值是" + Short.MAX_VALUE);
		  System.out.println("short最大值是" + Short.MIN_VALUE);
		  System.out.println("long最大值是" + Long.MAX_VALUE);
		  System.out.println("long最大值是" + Long.MIN_VALUE);
		  System.out.println("double最大值是" + Double.MAX_VALUE);
		  System.out.println("double最大值是" + Double.MIN_VALUE);
		  
		  //char类型可以保存单个字符
		//char类型会保存数字,会去查ASCII码表
		//ASCII码表只用了0-127  
		  char a = 123; 
		  char b = '好';
		  char c = 'a';
		  char d = '*';
		  System.out.println(a);//会输出ASCII码中123对应字符"{"
		  
//		  Scanner in = new Scanner(System.in);
//		  System.out.println("输入要计算的半径");
//		  double r = in.nextDouble();
//		  final double pi = 3.14;
//		  System.out.println("圆的面积是: " + pi*r*r);
		  
		  int i1 = 1;
		  int temp;
		  int i3 = 2;
		  temp = i1;
		  i1 = i3;
		  i3 = temp;
		  System.out.println(i1 + "&" + i3);
		  
		  
		  /**
		   * 八种基本变量类型的字节长度:
		   * byte 一字节
		   * char 两字节
		   * short 两字节
		   * int 4字节
		   * float 4字节
		   * double 8字节
		   * long 8字节
		   * boolean -- boolean只有两个值不计算字节
		   */
		  Long x = 99999999999L;//如果整数越过了int的边界,则要用Long储存
		  float f = 3.141f; //小数默认值为double(8字节)而float是4字节,不推荐这么储存,所以要再后面加上f
		  double doubleNum = 123d; //123是整数,后面加上d就变成了double类型
		  
		  System.out.println("3d/2 = " + 3d/2 + "; 3d/2d = " + 3d/2d + "; (double)3/2 = " + (double)3/2);
		 
		  /**
		   * byte short char三种类型的变量比int小，
		   * 在运算过程中会先转化为int再进行运算
		   * b1+b2会被转化为 int先进行运算,所以这里不能直接 byte b3 = b1+b2(编译会出错)
		   * 而必须进行下面这种强制类型转化
		   */
		  byte b1 = 1;
		  byte b2 = 12;
		  byte b3 = (byte)(b1+b2);
		  System.out.println(b3);
		  
		  /**
		   * 浮点数运算不精确
		   */
		  System.out.println(1-0.8);
	  }
	 

}
