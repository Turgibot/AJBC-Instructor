package bootcamp.learn.generics;


public class DataHolder<T> implements Comparable<T>{
	private T data;
	private int num;
	
	public DataHolder(T data){
		setData(data); 
	}
	public T getData(){
		return this.data;
	}
	
	public void setData(T data){
		this.data=data;
	}
	@Override
	public int compareTo(T o) {
		
		return compare(new VIPCustomer(12, "ss", 1, 3), new Customer(12, "ss", 2));
	}
	
	public <T extends Person> int compare( T t1, T t2) {
		return t1.hashCode()-t2.hashCode();
		
	}
}
