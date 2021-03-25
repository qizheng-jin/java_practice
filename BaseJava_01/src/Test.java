
public class Test {
	int a;
	int b;
	public Test(int a) {
		this.a = a;
	}
	
	public Test(int a, int b) {
		this(a);
		this.b = b;
	}
}
