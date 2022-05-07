package ajbc.patterns.decorator.exe;

public class Runner {
	public static void main(String[] args) {
		Dress basicDress = new BasicDress("Orange", "M");
		Dress basicFancyDress = new FancyDressDecorator(basicDress);
		Dress basicCasualDress = new CasualDressDecorator(basicDress);
		Dress basicFancySportyDress = new SportyDressDecorator(basicFancyDress);
		Dress basicFancyCasualDress = new CasualDressDecorator(basicFancyDress);
		Dress basicSportyCasualFancyDress = new FancyDressDecorator(new CasualDressDecorator(new SportyDressDecorator(basicDress)));
		Dress[] dresses = {
				basicDress, 
				basicFancyDress, 
				basicCasualDress, 
				basicFancySportyDress, 
				basicFancyCasualDress,
				basicSportyCasualFancyDress};
		for (Dress dress : dresses) {
			System.out.println("--------------------------");
			dress.create();
		}
	}
}
