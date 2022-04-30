package bootcamp.learn.generics;

import java.util.HashMap;

public class DataHolderCompared<T extends Comparable<T>>{
	private T data;
	
	public DataHolderCompared(T data){
		setData(data); 
	}
	public T getData(){
		return this.data;
	}
	
	public void setData(T data){
		this.data=data;
	}	
	
}
