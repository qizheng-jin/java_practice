package recursive;

public class Rabbit {
	//这个月的总兔子数量 = 成熟兔子数 + 小兔子数
	// 小兔子数 = 上个月小兔子数 + 这个月总成熟兔子数 - 这个月中刚成年的小兔子数;
	// 成熟的兔子数 =上个月成熟的兔子数 + 这个月中刚成年的小兔子数
	//这个月的总兔子数量 = 上个月总兔子数量 + 这个月成熟的兔子数 
	//这个月成熟的兔子数 = 3个月前兔子数的总量
	
	public static int rabbit(int month) {
		if(month <= 2) return 2;
		return rabbit(month-1) + rabbit(month-3);
	}
	
	public static void main(String[] args) {
		for(int i=0; i<=12; i++) {
			System.out.println("第"+i +"个月的兔子总对数: " + rabbit(i)/2);
		}
	}
}
