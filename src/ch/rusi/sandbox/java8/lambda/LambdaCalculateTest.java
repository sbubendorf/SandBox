package ch.rusi.sandbox.java8.lambda;

public class LambdaCalculateTest {
	
	interface Rectangle {
		public double getArea(double length, double width);
	}
	
	public static void main(String[] args) {
		
		final double multi = 3;
		Rectangle rect = (l,w) -> {
			l *= multi;
			w *= multi;
			return l * w;
		};
		
		System.out.println("Fläche: " + rect.getArea(4, 3));

	}

}
