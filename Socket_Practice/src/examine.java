
public class examine {
	public static void main(String[] args) {
		String s = "����˭?���";
		if(s.contains("?")) System.out.println(s);
		
		String[] data = s.split("\\?");
		System.out.println(data[0]);
	}
}