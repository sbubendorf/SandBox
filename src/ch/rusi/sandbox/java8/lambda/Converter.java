package ch.rusi.sandbox.java8.lambda;

/*

Seit Java 8.0 werden Interfaces mit nur einer einzigen abstrakten Methode als "funktionale Interfaces" bezeichnet!
Um deren Methoden zu n�tzen k�nnen in Java 8.0 sogenannte Lambda-Ausdr�cke verwendet werden.
 
 */

@FunctionalInterface
public interface Converter<F, T> {
	
	T convert (F from);
	
}
