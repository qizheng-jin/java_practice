package day8;
/**
 * 
 * �������еĹ��캯��
 * 1. �������п����й��췽��
 * 2. ����Ĺ��췽��Ҫ����������ִ��
 * 3. �����಻���Դ�������
 * 4. �������д��ڵĹ��췽������Ϊ�˴����������ʱ����
 * ����Ϊ�˴����������ʱʹ��
 *
 */
public class Test3_Abstract {
	public static void main(String[] args) {
		
		Animals animal = new Mouse("����");
		//new Animals();//�����಻�ܴ�������
		
	}
	
}


abstract class Animals{
	public Animals(String s) {
		System.out.println("����Animal3�Ĺ��췽��");
	}
}

class Mouse extends Animals{
	public Mouse(String s) {
		super(s);
		System.out.println("mouse�Ĺ��췽��" + s);
	}
	
}