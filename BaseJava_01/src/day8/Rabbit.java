package day8;

public class Rabbit {
	
	public int sum(int mon) {
		if(mon <= 2) return 2;
		else {
			return getMature(mon) + getMature(mon)/2;
		}
		
		
	}
	
	public int getMature(int mon) {
		if(mon <= 2) return 2;
		
		
		
		return getMature(mon-3)/2 + getMature(mon-3);
	}
	
	public static void main(String[] args) {
		Rabbit rabbit = new Rabbit();
		System.out.println(rabbit.sum(5));
	}
}
