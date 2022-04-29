package ajbc.testing.tshirts;

public class Design {
	// consts

	private static final double WIDTH_MIN, WIDTH_MAX, HEIGHT_MIN, HEIGHT_MAX, COMPLEX_MIN, COMPLEX_MAX;
	private static final String DEF_SLOGAN;

	static {
		WIDTH_MIN = 20;
		WIDTH_MAX = 30;
		HEIGHT_MIN = 10;
		HEIGHT_MAX = 25;
		COMPLEX_MIN = 1;
		COMPLEX_MAX = 100;
		DEF_SLOGAN = "Best T-Shirts";
	}

	// fields
	private double width;
	private double height;
	private String slogan;
	private Color color;
	private double complexity;

	// constructors
	public Design(double width, double height, String slogan, Color color, double complexity) {
		setWidth(width);
		setHeight(height);
		setSlogan(slogan);
		setColor(color);
		setComplexity(complexity);
	}

	public Design() {
		this(WIDTH_MIN, HEIGHT_MIN, DEF_SLOGAN, new Color(), COMPLEX_MIN);
	}
	// setters

	private void setWidth(double width) {
		if (Utils.isInRange(width, WIDTH_MIN, WIDTH_MAX))
			this.width = width;
	}

	private void setHeight(double height) {
		if (Utils.isInRange(height, HEIGHT_MIN, HEIGHT_MAX))
			this.height = height;
	}

	private void setComplexity(double complexity) {
		if (Utils.isInRange(complexity, COMPLEX_MIN, COMPLEX_MAX))
			this.complexity = complexity;
	}

	private void setSlogan(String slogan) {
		if (Utils.isLetterDigits(slogan))
			this.slogan = slogan;
		else
			this.slogan = DEF_SLOGAN;
	}

	public double calcArea() {
		return width * height;
	}

	// methods
	private void setColor(Color color) {
		this.color = color;
	}

	public double getComplexity() {
		return complexity;
	}

	@Override
	public String toString() {
		return "Design [width=" + width + ", height=" + height + ", slogan=" + slogan + ", color=" + color
				+ ", complexity=" + complexity + "]";
	}
	
	
}
