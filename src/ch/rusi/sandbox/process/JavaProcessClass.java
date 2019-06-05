package ch.rusi.sandbox.process;

public class JavaProcessClass {

	public static void main(String[] args) {
		
		System.out.println("This comes from a Java Sub Process with the following argumtnet:");
		for ( String arg : args ) {
			System.out.println("  - " + arg);
		}

	}

}
