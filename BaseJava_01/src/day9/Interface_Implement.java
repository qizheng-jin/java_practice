package day9;

/**
 * ����̳нӿڵ�����һ��������Ļ�,�Ͳ���Ҫǿ��Ҫ����д��������г��󷽷�
 * 
 * ���ʵ������Ҫʹ�ýӿڵĹ��ܾ���Ҫ��ӿڽ���ʵ�ֹ�ϵ(implements)
 */

public class Interface_Implement implements Interface_Test, UserInterface, Teacher{ //extends

	@Override
	public void skillq() {
		System.out.println("����Q����");
	}

	@Override
	public void skillw() {
		System.out.println("����w����");
	}
	
	@Override
	public void abstractMethod() {
		
	}
	
	@Override
	public void prepare() {
		System.out.println("��ʦ����");
	}

	@Override
	public void teach() {
		System.out.println("��ʦ�Ͽ�");
	}
	
	public static void main(String[] args) {
		Interface_Implement ic = new Interface_Implement();
		ic.skillq();
		ic.skillw();
		/**
		 * �ӿ���������û������,ʹ�õĻ���ȫ��������ķ���,��Ϊ�ӿ���ȫ����
		 */
		Interface_Test it = new Interface_Implement();
		it.skillq();
		it.skillw();
		
		System.out.println(Interface_Implement.pi);//��������ֱ���������
	}


	
	


}
