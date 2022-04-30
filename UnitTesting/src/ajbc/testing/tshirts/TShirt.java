package ajbc.testing.tshirts;

public class TShirt {

	// constants

	private final static double FACTOR_MIN, FACTOR_MAX, BASE_PRICE_MIN, EXPENSIVE_PRICE;
	static {
		FACTOR_MIN = 0.1;
		FACTOR_MAX = 1;
		BASE_PRICE_MIN = 3;
		EXPENSIVE_PRICE = 10000;
	}

	// fields

	protected Size size;
	protected Design design;
	protected double demandFactor;
	protected double basePrice;

	// constructors

	public TShirt(Size size, Design design, double demandFactor, double basePrice) {
		setSize(size);
		setDesign(design);
		setDemandFactor(demandFactor);
		setBasePrice(basePrice);
	}

	public TShirt() {
		this(Size.M, new Design(), FACTOR_MIN, BASE_PRICE_MIN);
	}

	// setters getters

	private void setSize(Size size) {
		if (size == null)
			this.size = Size.M;
		else
			this.size = size;

	}

	private void setDemandFactor(double demandFactor) {
		if (Utils.isInRange(demandFactor, FACTOR_MIN, FACTOR_MAX))
			this.demandFactor = demandFactor;
		else
			this.demandFactor = FACTOR_MIN;
	}

	private void setDesign(Design design) {
		if (design == null)
			this.design = new Design();
		else
			this.design = design;
	}

	private void setBasePrice(double basePrice) {
		if (Utils.isInRange(basePrice, BASE_PRICE_MIN, Double.MAX_VALUE))
			this.basePrice = basePrice;
		else
			this.basePrice = BASE_PRICE_MIN;
	}
	
	
	public Size getSize() {
		return size;
	}

	public Design getDesign() {
		return design;
	}

	public double getDemandFactor() {
		return demandFactor;
	}

	public double getBasePrice() {
		return basePrice;
	}
	
	// methods

	public double calculateFinalPrice() {
		return (basePrice + design.getComplexity()) * design.calcArea() / demandFactor;
	}
	
	public boolean isExpensive() {
		return calculateFinalPrice()>=EXPENSIVE_PRICE;
	}

	@Override
	public String toString() {
		return "TShirt [size=" + size + ", design=" + design + ", demandFactor=" + demandFactor + ", basePrice="
				+ basePrice + "]";
	}

}
