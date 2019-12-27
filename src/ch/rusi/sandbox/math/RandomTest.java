package ch.rusi.sandbox.math;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		
		Random rand = new Random();
		for ( int i = 0 ; i < 10 ; i++ ) {
			System.out.println(rand.nextInt(100));
		}
		
		System.out.println("-------");
	
		rand.ints(10, 1, 100).sorted().forEach(System.out::println);

	}

}
