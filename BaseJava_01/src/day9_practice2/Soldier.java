package day9_practice2;

import java.util.Random;
import java.util.Scanner;

public class Soldier {
	int id;
	int blood;
	AK47 ak47 = new AK47();
	
	
	public void go() {
		System.out.println(id+"ʿ����ǰ��");	
	}
	
	public void attack() {
		int d = new Random().nextInt(10);
		blood = blood - d;
		if(blood<0) blood = 0;
		System.out.println("��ǰѪ��"+blood);
		if(blood == 0) System.out.println(id+"ʿ������");
		
	}
	
	public static void main(String[] args) {
		Soldier soldier = new Soldier();
		soldier.id = 8889;
		soldier.blood =100;
		soldier.attack();
		soldier.ak47.fire();
		AK47 ak = new AK47();
		System.out.println("���س����,����loadװ���ӵ�");
		while(true) {
			String s = new Scanner(System.in).nextLine();
			if(s.equals("load")) {
				ak.load();
			}
			ak.fire();
		}
	}
}
