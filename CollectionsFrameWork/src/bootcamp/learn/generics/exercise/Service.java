package bootcamp.learn.generics.exercise;

public class Service<T> implements Serviceable<T>{

	protected T serviced;
	protected float price;
	
	public Service(T serviced, float price) {
		this.serviced = serviced;
		this.price = price;
	}
	
	@Override
	public void service() {
		price+=100f;
	}

	@Override
	public String toString() {
		return "Service [serviced=" + serviced + ", price=" + price + "]";
	}
	
	public T getServiced() {
		return serviced;
	}
}
