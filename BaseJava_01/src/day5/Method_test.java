package day5;

public class Method_test {
	/**
	 * ���η� ����ֵ���� �������֣������Ĳ�����{������}
	 */
	public void method() {
		System.out.println("��Ү!");
	}
	
	/**
	 * 	����������:
	 * ��ͬһ������,�ж��ٸ�ͬ��&�����б�ͬ�ķ���
	 * 
	 * */
	
	public void method(String s) {
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		Method_test test = new Method_test();
		test.method();
		test.method("����˹");
	}
}
