package bootcamp.learn.generics;

import java.util.HashMap;

public class DataHolder<T>{
	private T data;
	
	public DataHolder(T data){
		setData(data); 
	}
	public T getData(){
		return this.data;
	}
	
	public void setData(T data){
		this.data=data;
	}	
}
