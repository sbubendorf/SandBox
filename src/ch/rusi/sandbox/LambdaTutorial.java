package ch.rusi.sandbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import javax.naming.directory.InvalidAttributeValueException;

public class LambdaTutorial {

	public static void main(String[] args) {
		List<Integer> list = null;
		try {
			list = getRandoms(1000);
		} catch (InvalidAttributeValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		// Sort list
		Collections.sort(list, (a,b) -> a.compareTo(b));

		System.out.println("Show complete list of values:");
		list.forEach(i -> { System.out.println(i); });
		System.out.println("Show only values divisible by 2:");
		getSpecificNumbers(list, z -> z%2 == 0).forEach(i -> { System.out.println(i);});
		System.out.println("Show only prim values:");
		getSpecificNumbers(list, z -> isPrime(z)).forEach(i -> { System.out.println(i);});

	}
	
	private static List<Integer> getRandoms(int numValues) throws InvalidAttributeValueException {
		return getRandoms(numValues, numValues);
	}
	
	private static List<Integer> getRandoms(int numValues, int randomRange) throws InvalidAttributeValueException {
		if ( randomRange < numValues ) {
			throw new InvalidAttributeValueException("The range of random numbers has to be >= to the number of values you want to get!");
		}
		List<Integer> list = new ArrayList<Integer>();
		Integer val = null;
	    Random random = new Random();
	    for( int i = 0 ; i < numValues ; i++ ) {
	    	while ( true ) {
	    		val = random.nextInt(randomRange);
	    		if ( !list.contains(val) ) {
	    			list.add(val);
	    			break;
	    		}
	    	}
	    	
	    }
		return list;
	}
	
	private static List<Integer> getSpecificNumbers (List<Integer> list, Predicate<Integer> p) {
		List<Integer> result = new ArrayList<Integer>();
		list.forEach(n -> {if(p.test(n)) result.add(n);});
		return result;
	}
	
	private static boolean isPrime(int number) {
	    //check if n is a multiple of 2
	    if (number%2==0) return false;
	    //if not, then just check the odds
	    for(int i = 3 ; i * i <= number ; i += 2 ) {
	        if( number % i == 0 )
	            return false;
	    }
	    return true;
	}	

}
