package day8;

public class Test2_AbstractDemo {
	public static void main(String[] args) {
		Animal animal = new Dog();
		animal.eat();
		animal.fly(); //��̬֮����ó��󷽷�,���е��������ʵ��
		//Cannot instantiate the type Pig����ʵ����һ��������,���ܴ�������
		//Animal animal2 = new Pig();
	}
}

/**
 * 
 *  ������̳г������,������Ա�ɳ�������,
 *  ����ʵ�ָ��������г��󷽷�
 */
abstract class Animal{
	public void eat() {
		System.out.println("����Animal���е�eat����");
	}
	public void play() {
		System.out.println("����animal���е�play����");
	}
	public abstract void fly();
}

abstract class Pig extends Animal{
	public abstract void fly();
}

class Dog extends Animal{

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("����dog���е�fly����");
	}
	
}

interface Animal_interface{
	public void start();
	public void stop();
	public void eat();
	public void sleep();
}
