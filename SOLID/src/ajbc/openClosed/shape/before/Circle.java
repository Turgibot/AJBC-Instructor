package ajbc.openClosed.shape.before;

public class Circle implements Shape{
	
	private int radius;
	
	public Circle(int radius) {
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return 0;
	}

}
