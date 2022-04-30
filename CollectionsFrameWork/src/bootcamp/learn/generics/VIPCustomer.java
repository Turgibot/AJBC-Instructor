package bootcamp.learn.generics;

public class VIPCustomer extends Customer {
	protected float spent;

	public VIPCustomer(long id, String name, int rank, float spent) {
		super(id, name, rank);
		this.spent = spent;
	}

	@Override
	public String toString() {
		return "VIPCustomer [spent=" + spent + ", rank=" + rank + ", id=" + id + ", name=" + name + "]";
	}
	
}
