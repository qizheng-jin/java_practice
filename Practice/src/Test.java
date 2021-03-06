import java.util.ArrayList;

public class Test{ 
	public static void main(String arg[]){
/**
 * &是二元运算符，
 * 它以特定的方式的方式组合操作数中对应的位 
 * 如果对应的位都为1，那么结果就是1， 
 * 如果任意一个位是0 则结果就是0		
 * 例如：13的二进制0000 1101
 *     7的二进制0000 0111
 *     &的结果
 *     0000 0101 = 5
 * |运算符类似， 如果对应的位有一个是1， 那么结果就是1
 * 		13|7 = 0000 1111 = 15   
 * 
 *  ^运算符是非运算符任何相同的二进制位用^计算结果是0
 *  	13^7 = 0000 1010 = 10	
 *  
 *  <<位移符 二进位数向后面加0
 *  15 << 2 ----> 0000 1111 ----> 0011 1100 = 32 + 16 + 8 + 4 = 60
 *  如果二进制最前面是0 用0补, 如果是1(负数)用1补
 *  15 >> 2 ----> 0000 1111 ----> 0000 0011 = 3
 *  >>>无论前面是0还是1都是用0补位
 *  **任何小数用>>0可以取整
 *  
 */
		System.out.println(13&7);
		System.out.println(13|7);
		System.out.println(13^7);
		System.out.println(15<<2);
		System.out.println(15>>2);
		System.out.println(15>>>2);
	}

}
