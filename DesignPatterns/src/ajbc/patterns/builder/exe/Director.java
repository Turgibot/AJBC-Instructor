package ajbc.patterns.builder.exe;

/**
 * Director defines the order of building steps. It works with a builder object
 * through common Builder interface. Therefore it may not know what product is
 * being built.
 */
public class Director {
	
	private final String HI= "Hawaiian Pizza";
	private final int HI_MOZZARELLA = 100, HI_FETA=40, HI_MUSHROOM=20, HI_PINEAPPLE=25;
	
	private final String DOM= "Dominican Puff-Pastry";
	private final int DOM_MOZZARELLA = 10, DOM_FETA=100, DOM_MUSHROOM=20, DOM_PINEAPPLE=15;
	
	
	
    public void constructHawaiianPizza(Builder builder) {
        builder.setName(HI);
        builder.setMozzarellaCheese(HI_MOZZARELLA);
        builder.setFetaCheese(HI_FETA);
        builder.setMushroom(HI_MUSHROOM);
        builder.setPineapple(HI_PINEAPPLE);
    }

    public void constructDominicanPuffPastry(Builder builder) {
    	builder.setName(DOM);
        builder.setMozzarellaCheese(DOM_MOZZARELLA);
        builder.setFetaCheese(DOM_FETA);
        builder.setMushroom(DOM_MUSHROOM);
        builder.setPineapple(DOM_PINEAPPLE);
    }

}