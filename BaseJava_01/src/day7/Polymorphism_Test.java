package day7;

public class Polymorphism_Test {
	public static void main(String[] args) {
		Dogs dog = new Dogs();
		System.out.println(dog.sum);
		dog.eat();
		dog.play();
		//����һ����̬����
		Animals a = new Dogs();
		//��̬����ĳ�Ա�����õ��Ǹ���ģ���ʹ�����Ա����û�г�ʼ��
		System.out.println(a.sum);
		
		//��̬�У��Ǿ�̬��������ʹ�ø���������������ʵ��(ʹ������ķ���)
		a.eat();
		
		
		//��̬�У���������඼�о�̬������ʹ�õ��Ǹ����
		a.play();
		
		
	}
	
}

class Animals{
	int sum = 10;
	public void eat() {
		System.out.println("��ɶ����");
	}
	public static void play() {
		System.out.println("��ɶ����");
	}
	
}

class Dogs extends Animals{
	int sum = 20;
	public void eat() {
		System.out.println("���Թ�ͷ");
	}
	
	public static void play() {
		System.out.println("���");
	}
}
