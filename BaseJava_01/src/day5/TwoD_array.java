package day5;

import java.util.Arrays;
/**
 * 
 * ��ά����
 *
 */

public class TwoD_array {
	
	public static void main(String[] args) {
		String[][] a = new String[6][8];
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				a[i][j] = i+1+"/"+(j+1); //���(j+1)һ��Ҫ������
			}
		}
		
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				System.out.print(a[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
