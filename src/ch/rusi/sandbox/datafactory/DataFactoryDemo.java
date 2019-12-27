package ch.rusi.sandbox.datafactory;

import java.util.Random;

import org.fluttercode.datafactory.impl.DataFactory;

public class DataFactoryDemo {

	public static void main(String[] args) {

		DataFactory df = new DataFactory();
		Random rand = new Random();
		
		df.randomize(rand.nextInt(1000000));
		
		
		for (int i = 0; i < 10; i++) {
			
			System.out.println(df.getFirstName() + " "+ df.getLastName());
			System.out.println(df.getStreetName() + " " + df.getNumberUpTo(50));
			System.out.println(df.getNumberBetween(1000, 9999) + " " + df.getCity());
			System.out.println(df.getEmailAddress());
			
			System.out.println("-----------------------");
		}
		
		String text = new String();
		for ( int i = 0 ; i < 50 ; i ++ ) {
			text = text + df.getRandomWord() + " ";
		}
		System.out.println(text);
		
	}

}
