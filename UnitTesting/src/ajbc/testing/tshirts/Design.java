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
	protected double width;
	protected double height;
	protected String slogan;
	protected Color color;
	protected double complexity;

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

	protected void setWidth(double width) {
		if (Utils.isInRange(width, WIDTH_MIN, WIDTH_MAX))
			this.width = width;
	}

	protected void setHeight(double height) {
		if (Utils.isInRange(height, HEIGHT_MIN, HEIGHT_MAX))
			this.height = height;
	}

	protected void setComplexity(double complexity) {
		if (Utils.isInRange(complexity, COMPLEX_MIN, COMPLEX_MAX))
			this.complexity = complexity;
	}

	protected void setSlogan(String slogan) {
		if (Utils.isLetterDigits(slogan))
			this.slogan = slogan;
		else
			this.slogan = DEF_SLOGAN;
	}
	
	protected void setColor(Color color) {
		this.color = color;
	}

	
	//getters
	
	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public String getSlogan() {
		return slogan;
	}

	public Color getColor() {
		return color;
	}

	public double getComplexity() {
		return complexity;
	}
	



	// methods
	
	public double calcArea() {
		return width * height;
	}
	

	@Override
	public String toString() {
		return "Design [width=" + width + ", height=" + height + ", slogan=" + slogan + ", color=" + color
				+ ", complexity=" + complexity + "]";
	}
	
	
}
