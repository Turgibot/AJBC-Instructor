package ajbc.openClosed.shape.before;

public class Rectangle implements Shape{
	
	private int height;
	private int width;
	
	public Rectangle(int height, int width) {
		this.height = height;
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return 0;
	}
}
