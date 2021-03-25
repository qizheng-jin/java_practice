package recursive;

// 2/1 3/2 5/3 8/5 13/8 .........
public class Recursion {
	private int recursive(int i) {
		if(i == 1) return 1;
		if(i == 2) return 2;	
		return recursive(i-1) +recursive(i-2); 
	}
	
	public double sum(int len) {
		double sum = 0;
		for(int i=1; i<=len; i++) {
			int fenMu = recursive(i);
			int fenZi = recursive(i+1);
			double num = (double)fenZi / fenMu;
			sum += num;
			System.out.println("num is " + fenZi + "/" + fenMu);
		}
		
		return sum;
	}
	
	private int recursiveFenzi(int i) {
		return 0;
	}
	
	private int recursiveFenmu(int i) {
		return 0;
	}
	
	public static void main(String[] args) {
		Recursion r = new Recursion();
		System.out.println(r.sum(10));
	}
}
