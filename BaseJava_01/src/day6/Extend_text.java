package day6;

public class Extend_text {
	public static void main(String[] args) {
		Son son = new Son();
		
	}
}

class Father{
	String s;
	public Father() {
		System.out.println("������޲ι���");
	}
	public Father(String s) {
		this.s = s;
	}
}
/**
 * 
 * �����������һ������ø�����޲ι���!
 * ���಻����д����Ĺ��췽��
 * ����Ĺ��췽����,Ĭ�ϴ���super()���ø�����޲ι���
 * 
 */
class Son extends Father{
	public Son() {
		super();//Ĭ������super()���ø�����޲ι���
		System.out.println("������޲ι���");
	}
}