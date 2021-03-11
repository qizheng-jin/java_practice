package day9_practice2;

import java.util.Random;

/**
 * 
 * 本类用于热武器AK47的封装
 *
 */
public class AK47 {
	int bullets = 100;
	public void load() {
		bullets = 100;
	}
	
	public void fire() {
		
		//子弹发射数
		int r = new Random().nextInt(10);
		if(r>bullets) {
			r = bullets;
		}
		
		bullets = bullets - r;
		for(int i=0; i<r; i++) {
			System.out.print("突");
		}
		if(bullets == 0) {
			System.out.println("弹夹空了");
		}
	}
}
