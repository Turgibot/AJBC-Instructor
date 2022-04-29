package ajbc.testing.tshirts;

public class Runner {

	public static void main(String[] args) {
		TShirt[] shirts = new TShirt[3];
		shirts[0] = new TShirt();
		shirts[1] = new TShirt(null, null, 0, 0);
		shirts[2] = new TShirt(Size.XL, new Design(22.5d, 19.9d, "JAVA IS THE BEST", new Color((short)50, (short)50, (short)50), 11), 0.5d, 12.5d);

		for (TShirt tShirt : shirts) {
			System.out.println(tShirt);
			System.out.println(tShirt.calculateFinalPrice()+" is expensive: "+tShirt.isExpensive());
			System.out.println("----------------------------");
		}
	}
	
}
