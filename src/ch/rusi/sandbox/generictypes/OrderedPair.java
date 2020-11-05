package ch.rusi.sandbox.generictypes;

public class OrderedPair<K, V> implements IPair<K, V> {
	
	private final K key;
	private final V value;

	public OrderedPair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

}
