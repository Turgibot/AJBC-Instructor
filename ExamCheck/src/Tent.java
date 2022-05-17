
import java.util.Random;

public class Tent {
	
	Random random = new Random();
	
	public int numPeople; 
	public double width;
	public double length;
	public double height;
	
	//constructor that creates random values 
	public Tent() {
		setRandomNumPeople(); 
		setRandomWidth();
		setRandomLength();
		setRandomHeight();
	}
	
	
	//parametric constructor
	public Tent(int numPeople, double width, double length, double height) {
		this.numPeople = numPeople; 
		this.width = width; 
		this.length = length;
		this.height = height; 
	}

	private void setRandomNumPeople() {
		numPeople = random.nextInt(1, 20); //1-20 people in a tent
	}

	private void setRandomWidth() {
		width = random.nextDouble(1, 10);//1-10 meter width
		
	}

	private void setRandomLength() {
		length = random.nextDouble(3, 15);//5-15 meter length
		
	}

	private void setRandomHeight() {
		height = random.nextDouble(1, 5);//1-5 meter height
		
	}
	
	public double getArea() {
		return width*length;
	}
	
	@Override
	public String toString() {
		String msg = String.format("a tent of %d people, width = %f, length = %f, height = %f", numPeople, width, length, height);
		return msg;
	}



}