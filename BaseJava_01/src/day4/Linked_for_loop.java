package day4;
/**
 * Ƕ��forѭ��,�ݹ�
 * @author Tedu
 *
 */

public class Linked_for_loop {
	/**
	 * �ݹ�,��ӡ������
	 * @param i
	 * @return
	 */
	public static String recursion(int i) {
		if(i==1) return("*");
		for(int j=1; j<=i; j++) {
			System.out.print("*");
		}
		System.out.println("");
		return recursion(i-1);
	}
	
	/**
	 * �ݹ飬��ӡ�˷���
	 * @param args
	 */
	
	public static String recursiveTable(int i) {
		if(i == 0) return "\n";
		for(int j=1; j<=i; j++) {
			System.out.print(j + "*" + i + "=" + j*i + "; ");
		}
		System.out.println();
		return recursiveTable(i-1);
	}
	
	public static String recursive(int i) {
		if(i == 10) {
			
		}
		return null;
		
	}
	
	public static void main(String[] args) {
		System.out.println(recursion(10));
		//System.out.println(timeTable(8));
		System.out.println("************");
		System.out.println(recursiveTable(9));
	}
}