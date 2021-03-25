package day1;

import java.util.Arrays;

public class Test_String {
	public static void main(String[] args) {
		char[] data = {'a', 'b', 'c'};
		String s1 = new String(data);
		
		String s2 = "abc";
		//��ֵַ��һ��
		System.out.println(s1 == s2);
		System.out.println(s2.charAt(0));
		System.out.println(s2.concat("cxy"));//ƴ�ӵ���β
		System.out.println(s2.endsWith("c"));
		System.out.println(s2.equals(s1));//String��equals��д�˱Ƚ�����String������
		System.out.println(s2.getBytes());//���ַ������byte[]����
		System.out.println(s2.indexOf("c"));//��ȡc�ַ����ַ����г��ֵĵ�һ��λ��ֵ
		System.out.println(s2.lastIndexOf('c'));//��ȡc�ַ����ַ������һ�γ��ֵ�λ��
		System.out.println(s2.length());//��ȡ�ַ����ĳ���
		
		s2 = "a b c d e";
		System.out.println(s2.split("")); //split��������ĳһ�ַ����ַ���Ϊ�ֽ���,���ַ�����Ϊ������,�ֽ������߶���ռ
		System.out.println(Arrays.toString(s2.split("b")));
		System.out.println(s2.startsWith("a"));//true,�ж��Ƿ���a��ͷ
		
		System.out.println(s2.substring(5)); //���±�Ϊn�ĵط���ʼ��ȡ�ַ���
		System.out.println("***********************");
		System.out.println(s2.substring(1, 3));//���±�Ϊx���±�Ϊy�ĵط���ȡ�ַ���������ҿ�
		System.out.println(s2.toUpperCase() +" &&& "+ s2.toLowerCase());//���Сд
		System.out.println(s2.trim());//ȥ������Ŀո�
		
		System.out.println(String.valueOf(10) + 10);//����Ļ�������ת��Ϊstring���
	}
}
