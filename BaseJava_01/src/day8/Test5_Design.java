package day8;

public class Test5_Design {
	
   // A + B = C; => A = B, B = C
	public int division(int len) {
		if(len == 1) return 1;
		if(len == 2) return 2;
		
		int sum = 0;
		int b = 2;
		int a = 1;
		for(int j=2; j<len; j++) {
			sum = b + a;
			//System.out.println(divider + "+" + divided + "=" + sum);
			a = b;
			b = sum;
		}
		return sum;
	}

	
	
	public double sum(int len) {
		double sum = 0;
		for(int i=1; i<=len; i++) {
			int fenMu = division(i);
			System.out.println("分母是：" + fenMu + "\n");
			int fenZi = division(i+1);
			System.out.println("分子是: " + fenZi + "\n");
			System.out.println(i);
						
			double d = (double)fenZi/fenMu;
			sum = sum + d;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Test5_Design test = new Test5_Design();
		System.out.println(test.sum(20));
	}
	
}


	

