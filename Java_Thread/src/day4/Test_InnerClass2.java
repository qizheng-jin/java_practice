package day4;

import day4.Outer3.Inner3;

public class Test_InnerClass2 {
	public static void main(String[] args) {
		
		// Outer3.Inner3 inner = new Outer3().new Inner3();
		//��̬�ڲ���ĵ���
		Outer3.Inner3 inner = new Outer3.Inner3();
		inner.play();
		new Outer3.Inner3().play();
		
		//��̬�ڲ���ľ�̬��������
		Outer3.Inner3.run();
		
		
		/**ʹ�þֲ��ڲ���
		 * ֱ�ӵ���show�������޷������ڲ��๦�ܵ�
		 * ��Ҫ���ⲿ���д����ڲ�����󲢽��е��ã����ܳ����ڲ���Ĺ���
		 * */
		
		
	}
}


class Outer3{
	
	public void outMethod() {
		
		class Inner4{
			String name;
			int age;
			public void eat() {
				System.out.println("����out�෽��������ڲ������ͨ����");
			}
		}
		Inner4 inner4 = new Inner4();
		System.out.println(inner4.name);
		inner4.eat();
	}
	
	//2. �����ڲ���Inner3
	static class Inner3{
		//3. �����ڲ�����ͨ��Ա����
		public void play() {
			System.out.println("����Inner����ͨ����");
		}
		
		public static void run() {
			System.out.println("����Inner�ľ�̬����");
		}
	}
}