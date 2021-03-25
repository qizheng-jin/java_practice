package recursive;

public class Recursion2 {
	// 2/1 3/2 5/3 8/5 13/8 .........
	// x(n)/y(n) = [y(n-1) +x(n-1)]/x(n-1);
	
	public int fenMu(int i) {
		if(i == 1) return 1;
		return fenZi(i-1);
	}
	
	public int fenZi(int i) {
		if(i == 1) return 2;
		return fenMu(i-1) + fenZi(i-1);
	}
	
	public double sum(int len) {
		double sum = 0;
		for(int i=1; i<=len; i++) {
			double num = (double)fenZi(i)/fenMu(i);
			sum += num;
			System.out.println("num is " + fenZi(i) + "/" +fenMu(i));
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Recursion2 r = new Recursion2();
		System.out.println(r.sum(5));
	}
}
