package day8;

public class Test5_Design {
	public static void main(String[] args) {
		ManCity city = new ManCity();
		System.out.println(city.getClubName());
	}
}

interface FootballClub{
	public final String name="Football Club";
	public abstract String getClubName();
	public abstract int getChampionNumber();
}

class ManCity implements FootballClub{
	@Override
	public String getClubName() {
		// TODO Auto-generated method stub
		return name +":"+ "Manchester City";
	}

	@Override
	public int getChampionNumber() {
		// TODO Auto-generated method stub
		return 20;
	}
	
}
