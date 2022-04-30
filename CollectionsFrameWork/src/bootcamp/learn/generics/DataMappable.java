package bootcamp.learn.generics;

import java.util.HashMap;
import java.util.Map;

public interface DataMappable<K, V> {
	public String getStrValueByKey(K key);
}
