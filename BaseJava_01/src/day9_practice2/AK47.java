package day9_practice2;

import java.util.Random;

/**
 * 
 * ��������������AK47�ķ�װ
 *
 */
public class AK47 {
	int bullets = 100;
	public void load() {
		bullets = 100;
	}
	
	public void fire() {
		
		//�ӵ�������
		int r = new Random().nextInt(10);
		if(r>bullets) {
			r = bullets;
		}
		
		bullets = bullets - r;
		for(int i=0; i<r; i++) {
			System.out.print("ͻ");
		}
		if(bullets == 0) {
			System.out.println("���п���");
		}
	}
}
