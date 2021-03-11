package day8;

public class Test {
	public String jie_cheng(int l) {
		if(l==0) return "";
		else {
			for(int i=0; i<l; i++) {
				System.out.print("*");
			}
			System.out.println();
			return jie_cheng(l-1);
		}
	}
	

	public static void main(String[] args) {
		Test test = new Test();
		System.out.println(test.jie_cheng(5));
	}
}

interface Whatever {
	int sum = 10;
	public abstract void sayHi();
}
