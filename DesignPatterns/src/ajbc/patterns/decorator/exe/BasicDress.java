package ajbc.patterns.decorator.exe;

public class BasicDress implements Dress {
	private String color;
	private String size;

	public BasicDress(String color, String size) {	
		this.color = color;
		this.size = size;
	}

	@Override
	public void create() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "BasicDress features: color=" + color + ", size=" + size ;
	}
	
}
