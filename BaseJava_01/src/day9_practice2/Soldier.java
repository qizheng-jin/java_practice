package day9_practice2;

import java.util.Random;
import java.util.Scanner;

public class Soldier {
	int id;
	int blood;
	AK47 ak47 = new AK47();
	
	
	public void go() {
		System.out.println(id+"士兵在前进");	
	}
	
	public void attack() {
		int d = new Random().nextInt(10);
		blood = blood - d;
		if(blood<0) blood = 0;
		System.out.println("当前血量"+blood);
		if(blood == 0) System.out.println(id+"士兵挂了");
		
	}
	
	public static void main(String[] args) {
		Soldier soldier = new Soldier();
		soldier.id = 8889;
		soldier.blood =100;
		soldier.attack();
		soldier.ak47.fire();
		AK47 ak = new AK47();
		System.out.println("按回车射击,输入load装载子弹");
		while(true) {
			String s = new Scanner(System.in).nextLine();
			if(s.equals("load")) {
				ak.load();
			}
			ak.fire();
		}
	}
}
