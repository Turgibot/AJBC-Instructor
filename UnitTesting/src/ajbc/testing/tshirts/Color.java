package ajbc.testing.tshirts;

public class Color {
	private static final short MIN;
	private static final short MAX;

	static {
		MIN = 0;
		MAX = 255;
	}

	// fields

	private short red;
	private short green;
	private short blue;

	// constructors

	public Color(short red, short green, short blue) {
		setRed(red);
		setGreen(green);
		setBlue(blue);
	}

	public Color() {
		this(MIN, MIN, MIN);
	}

	// setters

	private void setRed(short red) {
		if (Utils.isInRange(red, MIN, MAX))
			this.red = red;
	}

	private void setGreen(short green) {
		if (Utils.isInRange(green, MIN, MAX))
			this.green = green;
	}

	private void setBlue(short blue) {
		if (Utils.isInRange(blue, MIN, MAX))
			this.blue = blue;
	}

	
	
	// methods
	
	@Override
	public String toString() {
		return "Color [red=" + red + ", green=" + green + ", blue=" + blue + "]";
	}
}
