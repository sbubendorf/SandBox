package ch.rusi.sandbox.java8.lambda;

public class LambdaHello {
	
	interface Printer { void print(); }

	public static void main(String[] args) {
		
		Printer p = () -> { System.out.println("Hallo Welt!"); };
		
		p.print();  // Hallo Welt!

	}

}
