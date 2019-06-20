package ch.rusi.sandbox.java8.defaultmethods;

/*
Besides the abstract method calculate the interface Formula also defines the default method sqrt. 
Concrete classes only have to implement the abstract method calculate. 
The default method sqrt can be used out of the box
 */

public class FormulaTest implements Formula {

	@Override
	public double calculate(int a) {
		return sqrt(a * 100);
	}

	public static void main(String[] args) {

		FormulaTest form = new FormulaTest();
		
		System.out.println(form.calculate(100));
		System.out.println(form.sqrt(16));

	}

}
