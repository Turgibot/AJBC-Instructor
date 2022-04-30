package bootcamp.learn.generics.exercise;

import java.util.Objects;

public class Customer extends Person implements Comparable<Customer>{
	
	protected int rank;
    public Customer(long id, String name, int rank ) {
        super(id, name);
    	this.rank = rank;
    }
	@Override
	public String toString() {
		return "Customer [rank=" + rank + ",  " + super.toString() + "]";
	}
	
	@Override
	public void accept() {
		rank++;
	}
	@Override
	public int compareTo(Customer o) {
		return this.rank-o.rank;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(rank);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return rank == other.rank;
	}
	
}
