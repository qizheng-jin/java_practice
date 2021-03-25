package day2;
/**
 * 
 * Debug:断点调试
 * 打断点:一个小圆圈
 * Step Into & Step Over的区别
 * step into：单步执行，遇到子函数就进入并且继续单步执行（简而言之，进入子函数）
 * step over：在单步执行时，在函数内遇到子函数时不会进入子函数内单步执行，而是将子函数整个执行完再停止，也就是把子函数整个作为一步。
 * 有一点,经过我们简单的调试,在不存在子函数的情况下是和step into效果一样的（简而言之，越过子函数，但子函数会执行）。
 */

public class Practice_Debug {
	public static void main(String[] args) {
		for(int i=1; i<=10; i++) {
			System.out.println(i);
		}
	}
}
