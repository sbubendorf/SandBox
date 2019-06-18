package ch.rusi.sandbox.generictypes;

public class Box<T> {
	
	/*
	 	The most commonly used type parameter names are:

		E - Element (used extensively by the Java Collections Framework)
		K - Key
		N - Number
		T - Type
		V - Value
		S,U,V etc. - 2nd, 3rd, 4th types
		
		See also: https://docs.oracle.com/javase/tutorial/java/generics/types.html

	 */
	
	private T value;
	
	public Box(T value) {
		this.value = value;
	}
	
	public void set (T value) {
		this.value = value;
	}
	
	public T get() {
		return this.value;
	}

}
