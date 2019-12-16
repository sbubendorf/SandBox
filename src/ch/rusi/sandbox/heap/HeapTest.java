package ch.rusi.sandbox.heap;

import org.fluttercode.datafactory.impl.DataFactory;

public class HeapTest {

	public static void main(String[] args) {
		
		DataFactory df = new DataFactory();
		df.randomize((int) Math.round(Math.random() * 1000000));
		
		HeadData person = HeadData.builder()
			.lastName(df.getLastName())
			.firstName(df.getFirstName())
			.build();
		
		System.out.println(person.getLastName() + " " + person.getFirstName());
		
	}

}
