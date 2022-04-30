package bootcamp.learn.generics;

import java.util.HashMap;


public class MapDataHolder<K,V> implements DataMappable<K,V>{
	protected HashMap<K,V> data;
	
	public MapDataHolder(HashMap<K,V> data){
		this.data = data; 
	}
	public HashMap<K,V>  getData(){
		return this.data;
	}
	
	public V addItem(K key, V value){
		return data.put(key, value);
	}
	@Override
	public String getStrValueByKey(K key) {
		if(data.containsKey(key)){
			return data.get(key).toString();
		}
		return null;
	}
}
