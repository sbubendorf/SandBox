package ch.rusi.sandbox.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionSorter {

	public static void main(String[] args) {
		

		/*
		The static utility method Collections.sort accepts a list and a 
		comparator in order to sort the elements of the given list. 
		You often find yourself creating anonymous comparators and 
		pass them to the sort method.
		*/
		System.out.println("Sorting a list in prior versions of Java:");
		List<String> names = getNameList();
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return a.compareTo(b);
			}
		});
		printNames(names);
		
		System.out.println("Sorting a list with Lambda:");
		names = getNameList();
		Collections.sort(names, (String a, String b) -> { return a.compareTo(b); });
		printNames(names);
		
		System.out.println("Sorting a list with shorter Lambda:");
		names = getNameList();
		Collections.sort(names, (String a, String b) -> a.compareTo(b) );
		printNames(names);
		
		System.out.println("Sorting a list with shortest Lambda:");
		names = getNameList();
		Collections.sort(names, (a, b) -> a.compareTo(b) );
		printNames(names);
		
		

	}
	
	private static List<String> getNameList() {
		return Arrays.asList("peter","anna","simon","mike","xenia","ruth","susanna");
	}
	
	private static void printNames(List<String> names) {
		int i = 0;
		for (String name : names) {
			System.out.println(++i + " : " + name);
		}
	}

}
