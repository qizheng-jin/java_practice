package day7;

public class Test3_Block {
	public static void main(String[] args) {
		Person p = new Person();
		p.study();
		System.out.println("********");
		Person p2 = new Person(); //��̬����鲻���ٵ���һ��
		
	}
	
}
/**
 * 
 * ����˳��:��̬�����>��������>���캯��>��ͨ����>�ֲ������
 * ��̬�����:
 * ���﷽����,�����ڵ�:������ļ��ض�����,ֻ����һ��
 * ��������:
 * ���﷽�����𴥷��ڵ�:��������ʱ����ִ��
 * �ֲ������:
 * ������,�����ڵ�:���÷���ʱ��ִ��
 */

class Person{
	static {
		System.out.println("��̬�����"); //��̬�����ִֻ��һ��,������������ֻ�����һ��
	}
	{
		System.out.println("��������");
	}

	public Person() {
		System.out.println("���췽��");
	}
	
	public void study() {
		System.out.println("������ͨ����");
		{
			System.out.println("�ֲ������");
		}
	}
}