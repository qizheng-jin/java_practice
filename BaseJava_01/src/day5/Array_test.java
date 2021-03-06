package day5;

import java.util.ArrayList;
import java.util.Arrays;

public class Array_test {
	
	/**
	 * 
	 * 冒泡排序
	 */
	public void bubbleSort(int[] a) {
		//循环进行轮数
		for(int i=1; i<a.length; i++) {
			System.out.println("这是第" + i + "轮");
			//每一轮比较两个相邻数字的大小并调换位置
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
	 * 冒泡排序,递归方法
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
	 * 快速排序方法, l:left; r:right
	 * 快速排序法就是先选中一个数,将比它小的放左边,比它大的放右边
	 * 并递归这一步
	 */
//	private int AdjustArray(int s[], int l, int r) {
//		int x = s[l]; //s[l]就是第一个作为基准的值
//		while(l<r) {
//			// 从右向左,找小于基准值的数来填s[i];
//			while(l < r && s[r] >=x) r--;
//			if(l<r) {
//				s[l] = s[r];
//				l++;
//			}
//			
//		}
//		return 0;
//	}
	
	
	public int AdjustArray(int s[], int l, int r) //返回调整后基准数的位置
	{
	    int i = l, j = r;
	    int x = s[l]; //s[l]即s[i]就是第一个坑
	    while (i < j)
	    {
	        // 从右向左找到第一个小于x的数
	        while(i < j && s[j] >= x) 
	            j--; 
	        //找到后将小于x的数与x换位置
	        if(i < j) 
	        {
	            s[i] = s[j]; //将s[j]填到s[i]中，s[j]就形成了一个新的坑
	            System.out.println("将"+s[j]+"填到"+s[i]+"中，"+s[j]+"就形成了一个新的坑");
	            //形成新的坑之后转向从左向右数，
	            i++;
	        }
	 
	        // 从左向右找一个大于等于x的数
	        while(i < j && s[i] < x)
	            i++;  
	        //找到后将大于等于x的数与x换位置
	        if(i < j) 
	        {
	            s[j] = s[i]; //将s[i]填到s[j]中，s[i]就形成了一个新的坑
	            System.out.println("将"+s[i]+"填到"+s[j]+"中，"+s[i]+"就形成了一个新的坑");
	            //形成新的坑之后再转向从右向左数
	            j--;
	        }
	    }
	    //退出时，i等于j。将x填到这个坑中。
	    s[i] = x;
	 
	    return i;
	}
	
	/**
	 * 快速排序原理: 快速排序找到一个基准值,将比基准值小的放在左边,比基准值大的放在右边
	 * 			   然后对基准值左右两边再分别进行第一步的递归.
	 * @param s
	 * @param l
	 * @param r
	 * @return
	 */
	private int quickSort(int s[], int l, int r) {
		int thisInt = s[l];
		while(l<r) {	
			while(l<r && thisInt <= s[r]) 
				//从右向左数，直到找到第一个小于thisInt的值
				r --;
			if(l<r && thisInt > s[r]) {
				//将小于thisInt的那个值与thisInt换位置
				s[l] = s[r];
				//转向
				l++;
				
			}
			
			while(l<r && thisInt >= s[l]) 
				l++;
			
			if(l<r && thisInt < s[l]) {
				s[r] = s[l];
				//转向
				r --;
			}
		}
		s[l] = thisInt;
		
		return l;
	}
	
	public int[] quickSortArray(int[] a, int l, int r) {
		if(l<r) {
			int i = quickSort(a, l, r);
			//递归
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
		 * sort方法用的快速排序
		 */
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		
		
	
		
		
		/**
		 * copyOf 复制数组并且增容,减容 
		 * Copies the specified array, truncating or padding with zeros (if necessary)so the copy has the specified length. 
		 */
		int[] newArray = Arrays.copyOf(a, 4);
		System.out.println("new array is " + Arrays.toString(newArray));
		
		/**
		 * binarySearch, 找到数组中某个元素的位置.
		 */
		System.out.println(Arrays.binarySearch(a, 88));
		System.out.println("************");
		int[] b = {12, 0,52,2,23,15,2,154,6532,12,3,5,7,9,11};
		System.out.println(fj.quickSortArray(b, 0, b.length-1));
		System.out.println(Arrays.toString(b));
	}
} 
