package cn.tedu.hello;

public class TestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1;
		System.out.println(a++); //�ȴ�ӡ���Լӣ��Լӵ��������ȼ�����ߵ�
		System.out.println(a); //���Լ��ٴ�ӡ
		int b = 1;
		System.out.println(--b);
		System.out.println(b);
		int c = 2;
		System.out.println(c++*2);// �Լӷ����ڱ������ʱ�򣬲�Ӱ���ӡ
		int d = 2;
		System.out.println(++d*2);
		
		//��Ŀ�����
		System.out.println(2<3?"��ȷ":"����");
	}
}