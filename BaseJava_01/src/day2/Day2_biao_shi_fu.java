package day2;

import java.util.Scanner;

/**
 * 
 * ��ʶ����������ĸ�����֡��»��ߡ���Ԫ����ɣ����ǲ��ܰ���@��%���ո��
 * ���������ַ���
 * ���������ֿ�ͷ
 * �ϸ����ִ�Сд
 * ��ʶ��������java�ؼ���
 *
 */

/**
 * eclipse��ݼ�һ��:
 * �������캯��/getters/setters: alt + shift + s
 * ����java: ctrl + F11
 * ���ٴ��System.out.println(); : sout + alt + /
 * ���ٵ����: ctrl + shift + m.
 * ����ɾ��һ�У� ctrl + d
 * ����ѡ��һ�� �� ɾ���ӷ�����һ��
 * 
 */




public class Day2_biao_shi_fu {
	
	
	  public static void main(String[] args) {
		  System.out.println("�������µ�һ!");
		  String name = "�²�����";
		  int age = 30;
		  double salary = 10000;
		  
		  System.out.println("����" + name + ", ��" + age + "��" +
				  			"����н����" + salary + "��/ÿ��");
		  
		  System.out.println("byte���ֵ��" + Byte.MAX_VALUE);
		  System.out.println("byte��Сֵ��" + Byte.MIN_VALUE);
		  System.out.println("short���ֵ��" + Short.MAX_VALUE);
		  System.out.println("short���ֵ��" + Short.MIN_VALUE);
		  System.out.println("long���ֵ��" + Long.MAX_VALUE);
		  System.out.println("long���ֵ��" + Long.MIN_VALUE);
		  System.out.println("double���ֵ��" + Double.MAX_VALUE);
		  System.out.println("double���ֵ��" + Double.MIN_VALUE);
		  
		  //char���Ϳ��Ա��浥���ַ�
		//char���ͻᱣ������,��ȥ��ASCII���
		//ASCII���ֻ����0-127  
		  char a = 123; 
		  char b = '��';
		  char c = 'a';
		  char d = '*';
		  System.out.println(a);//�����ASCII����123��Ӧ�ַ�"{"
		  
//		  Scanner in = new Scanner(System.in);
//		  System.out.println("����Ҫ����İ뾶");
//		  double r = in.nextDouble();
//		  final double pi = 3.14;
//		  System.out.println("Բ�������: " + pi*r*r);
		  
		  int i1 = 1;
		  int temp;
		  int i3 = 2;
		  temp = i1;
		  i1 = i3;
		  i3 = temp;
		  System.out.println(i1 + "&" + i3);
		  
		  
		  /**
		   * ���ֻ����������͵��ֽڳ���:
		   * byte һ�ֽ�
		   * char ���ֽ�
		   * short ���ֽ�
		   * int 4�ֽ�
		   * float 4�ֽ�
		   * double 8�ֽ�
		   * long 8�ֽ�
		   * boolean -- booleanֻ������ֵ�������ֽ�
		   */
		  Long x = 99999999999L;//�������Խ����int�ı߽�,��Ҫ��Long����
		  float f = 3.141f; //С��Ĭ��ֵΪdouble(8�ֽ�)��float��4�ֽ�,���Ƽ���ô����,����Ҫ�ٺ������f
		  double doubleNum = 123d; //123������,�������d�ͱ����double����
		  
		  System.out.println("3d/2 = " + 3d/2 + "; 3d/2d = " + 3d/2d + "; (double)3/2 = " + (double)3/2);
		 
		  /**
		   * byte short char�������͵ı�����intС��
		   * ����������л���ת��Ϊint�ٽ�������
		   * b1+b2�ᱻת��Ϊ int�Ƚ�������,�������ﲻ��ֱ�� byte b3 = b1+b2(��������)
		   * �����������������ǿ������ת��
		   */
		  byte b1 = 1;
		  byte b2 = 12;
		  byte b3 = (byte)(b1+b2);
		  System.out.println(b3);
		  
		  /**
		   * ���������㲻��ȷ
		   */
		  System.out.println(1-0.8);
	  }
	 

}