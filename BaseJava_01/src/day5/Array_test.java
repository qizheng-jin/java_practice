package day5;

import java.util.ArrayList;
import java.util.Arrays;

public class Array_test {
	
	/**
	 * 
	 * ð������
	 */
	public void bubbleSort(int[] a) {
		//ѭ����������
		for(int i=1; i<a.length; i++) {
			System.out.println("���ǵ�" + i + "��");
			//ÿһ�ֱȽ������������ֵĴ�С������λ��
			for(int j=0; j<a.length-i; j++) {
				if(a[j]>a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
				
			}
			for(int m:a) System.out.print(m + "; ");
			System.out.println();
		}
		
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
	 * �������򷽷�, l:left; r:right
	 * �������򷨾�����ѡ��һ����,������С�ķ����,������ķ��ұ�
	 * ���ݹ���һ��
	 */
//	private int AdjustArray(int s[], int l, int r) {
//		int x = s[l]; //s[l]���ǵ�һ����Ϊ��׼��ֵ
//		while(l<r) {
//			// ��������,��С�ڻ�׼ֵ��������s[i];
//			while(l < r && s[r] >=x) r--;
//			if(l<r) {
//				s[l] = s[r];
//				l++;
//			}
//			
//		}
//		return 0;
//	}
	
	
	public int AdjustArray(int s[], int l, int r) //���ص������׼����λ��
	{
	    int i = l, j = r;
	    int x = s[l]; //s[l]��s[i]���ǵ�һ����
	    while (i < j)
	    {
	        // ���������ҵ���һ��С��x����
	        while(i < j && s[j] >= x) 
	            j--; 
	        //�ҵ���С��x������x��λ��
	        if(i < j) 
	        {
	            s[i] = s[j]; //��s[j]�s[i]�У�s[j]���γ���һ���µĿ�
	            System.out.println("��"+s[j]+"�"+s[i]+"�У�"+s[j]+"���γ���һ���µĿ�");
	            //�γ��µĿ�֮��ת�������������
	            i++;
	        }
	 
	        // ����������һ�����ڵ���x����
	        while(i < j && s[i] < x)
	            i++;  
	        //�ҵ��󽫴��ڵ���x������x��λ��
	        if(i < j) 
	        {
	            s[j] = s[i]; //��s[i]�s[j]�У�s[i]���γ���һ���µĿ�
	            System.out.println("��"+s[i]+"�"+s[j]+"�У�"+s[i]+"���γ���һ���µĿ�");
	            //�γ��µĿ�֮����ת�����������
	            j--;
	        }
	    }
	    //�˳�ʱ��i����j����x�������С�
	    s[i] = x;
	 
	    return i;
	}
	
	/**
	 * ��������ԭ��: ���������ҵ�һ����׼ֵ,���Ȼ�׼ֵС�ķ������,�Ȼ�׼ֵ��ķ����ұ�
	 * 			   Ȼ��Ի�׼ֵ���������ٷֱ���е�һ���ĵݹ�.
	 * @param s
	 * @param l
	 * @param r
	 * @return
	 */
	private int quickSort(int s[], int l, int r) {
		int thisInt = s[l];
		while(l<r) {	
			while(l<r && thisInt <= s[r]) 
				//������������ֱ���ҵ���һ��С��thisInt��ֵ
				r --;
			if(l<r && thisInt > s[r]) {
				//��С��thisInt���Ǹ�ֵ��thisInt��λ��
				s[l] = s[r];
				//ת��
				l++;
				
			}
			
			while(l<r && thisInt >= s[l]) 
				l++;
			
			if(l<r && thisInt < s[l]) {
				s[r] = s[l];
				//ת��
				r --;
			}
		}
		s[l] = thisInt;
		
		return l;
	}
	
	public int[] quickSortArray(int[] a, int l, int r) {
		if(l<r) {
			int i = quickSort(a, l, r);
			//�ݹ�
			quickSortArray(a, l, i-1);
			quickSortArray(a, i+1, r);
		}
		return a;
	}
	
	public static void main(String[] args) {
		Array_test fj = new Array_test();
		int[] a = {3,6,88,1,4,25,13,64,67,83,42,4,7,98,2};
//		fj.bubbleSort(a);
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
		System.out.println("************");
		int[] b = {12, 0,52,2,23,15,2,154,6532,12,3,5,7,9,11};
		System.out.println(fj.quickSortArray(b, 0, b.length-1));
		System.out.println(Arrays.toString(b));
	}
} 