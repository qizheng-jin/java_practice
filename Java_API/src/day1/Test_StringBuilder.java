package day1;
/**�����ַ���ƴ��*/
public class Test_StringBuilder {
	public static void main(String[] args) {
		
		method2(); //2ms���� 
		method1(); //1500ms����
	}
	
	private static void method1() {
		
		String s = "abcdefghijklmnopqrstuvwsyz";
		String result = "";
		
		/**�������е���һ�е�ʱ��*/
		long t1 = System.currentTimeMillis();
		for(int i=0; i<10000; i++) {
			result = result + s;
		}
		/**�������е���һ�е�ʱ��*/
		long t2 = System.currentTimeMillis();
		System.out.println(result);
		System.out.println(t2-t1);
	}
	
	private static void method2() {
		StringBuilder s = new StringBuilder();
		long t1 = System.currentTimeMillis();
		for(int i=0; i<10000; i++) {
			s.append("abcdefghijklmnopqrstuvwsyz");
		}
		long t2 = System.currentTimeMillis();
		System.out.println(s.toString());
		System.out.println(t2-t1);
	}
}
