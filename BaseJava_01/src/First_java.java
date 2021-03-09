import java.util.ArrayList;
import java.util.Arrays;

public class First_java {
	/**
	 * 
	 * ð������
	 */
	public void bubbleSort(int[] a) {
		for(int i=1; i<a.length-1; i++) {
			for(int j=0; j<a.length-1; j++) {
				if(a[j]>a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		for(int i:a) System.out.println(i);
	}
	
	/**
	 * ð������,�ݹ鷽��
	 */
	public int[] recursiveSort(int i, int[] a) {
		if(i == 0) return a;
		for(int j=0; j<i-1; j++) {
			if(a[j]>a[j+1]) {
				int temp = a[j];
				a[j] = a[j+1];
				a[j+1] = temp;
			}
		}
		return recursiveSort(i-1, a);
	}
	
	
	
	/**
	 * 
	 * 
	 */
	public static void main(String[] args) {
		First_java fj = new First_java();
		int[] a = {3,6,88,1,4,25,13,64,67,83,42,4,7,98};
		//fj.bubbleSort(a);
//		int[] b = fj.recursiveSort(a.length, a);
//		System.out.println(Arrays.toString(b));
		/**
		 * sort�����õĿ�������
		 */
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		
		/**
		 * copyOf �������鲢������,���� 
		 * Copies the specified array, truncating or padding with zeros (if necessary)so the copy has the specified length. 
		 */
		int[] newArray = Arrays.copyOf(a, 4);
		System.out.println("new array is " + Arrays.toString(newArray));
		
		/**
		 * binarySearch, �ҵ�������ĳ��Ԫ�ص�λ��.
		 */
		System.out.println(Arrays.binarySearch(a, 88));
	}
}
