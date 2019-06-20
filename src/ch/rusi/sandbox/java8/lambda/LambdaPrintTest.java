package ch.rusi.sandbox.java8.lambda;

public class LambdaPrintTest {
	
	interface Printer {
		public void print(String s, String t);
	}

	public static void main(String[] args) {
		
		Printer p = (s,t) -> {
			t = t.toUpperCase();
			System.out.println(s + " " + t);
		};
		
		p.print("Hallo", "Welt");

	}

}
