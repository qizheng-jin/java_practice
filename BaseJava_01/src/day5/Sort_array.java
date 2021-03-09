package day5;

import java.util.Arrays;

public class Sort_array {
	/**
	 * √∞≈›≈≈–Ú
	 */
	public int[] bubbleSort(int[] a) {
		for(int i=1; i<a.length; i++) {
			for(int j=0; j<a.length-i; j++) {
				if(a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		
		return a;
	}
	
	/**
	 * √∞≈›≈≈–Úµ›πÈ∑Ω∑®
	 * @param args
	 */
	public int[] recursiveBubble(int[] a, int length) {
		if (length==0) return a;
		for(int i=0; i<length-1; i++) {
			if(a[i] > a[i+1]) {
				int temp = a[i];
				a[i] = a[i+1];
				a[i+1] = temp;
			}
		}
		return recursiveBubble(a, length-1);
	}
	
	/**
	 * 
	 * øÏÀŸ≈≈–Ú,µ›πÈ∑Ω∑®
	 */
	private int quickSort(int[] a, int l, int r) {
		int thisInt = a[l];
		while(l<r) {
			while(l<r && thisInt <= a[r]) r--;
			if(thisInt > a[r]) {
				a[l] = a[r];
				l++;
			}
			
			while(l<r && thisInt >= a[l]) l++;
			if(thisInt < a[l]) {
				a[r] = a[l];
				r--;
			}
		}
		a[l] = thisInt;
		return l;
	}
	
	public int[] recursiveQuickSort(int[] a, int l, int r) {
		if(l<r) {
			int i = quickSort(a, l, r);
			recursiveQuickSort(a, l, i-1);
			recursiveQuickSort(a, i+1, r);
		}
		
		return a;
	}
	
	
	public static void main(String[] args) {
		int[] a = {6,7,5,4,3,1,2};
		Sort_array sort = new Sort_array();
		System.out.println(Arrays.toString(sort.recursiveQuickSort(a, 0, a.length-1)));
	}

}
