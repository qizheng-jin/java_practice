package day4;

import java.util.Random;
import java.util.Scanner;

public class Continue_Break_Return {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r = new Random().nextInt(10);//[0, 10)
		int rightNum = (int)(Math.random()*10);//[0,10)
		System.out.println(r);
		while(true) {
			System.out.println("输入你的数字");
			Scanner in = new Scanner(System.in);
			int i = in.nextInt();
			
			if(rightNum != i) continue;
			if(rightNum == i) break;
		}
		System.out.println("你猜对了");
			
	}

}
