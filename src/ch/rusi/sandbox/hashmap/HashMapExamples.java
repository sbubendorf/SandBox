package ch.rusi.sandbox.hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapExamples {

	private static Map<String, Double> productPrice = new HashMap<>();

	public static void main(String[] args) {
		
		productPrice.put("Rice"	, 6.9);
		productPrice.put("Flour", 3.9);
		productPrice.put("Sugar", 4.9);
		productPrice.put("Milk"	, 3.9);
		productPrice.put("Egg"	, 1.9);

		//get value
		Double egg = productPrice.get("Egg");
		System.out.println("The price of Egg is: " + egg);
	
		//print all the keys 
		for (String key : productPrice.keySet()) {
			System.out.println(key);
		}
		// Or : keys.forEach(key -> System.out.println(key));

		// Print all values
		Collection<Double> values = productPrice.values();
		values.forEach(value -> System.out.println(value));
		
		showAllProducts();
		
		productPrice.computeIfPresent	("Egg"		, (key, value) -> value+0.4);
		productPrice.compute			("Cheese"	, (key, value) -> (value == null ? 0 : value)+0.8);

		showAllProducts();
		
	}
	
	private static void showAllProducts() {
		// print all the keys and values altogether
		System.out.println("Current product list:");
		Set<Map.Entry<String, Double>> entries = productPrice.entrySet();
		for (Map.Entry<String, Double> entry : entries) {
			String line = String.format("%-10s : %6.2f", entry.getKey(), entry.getValue());
			System.out.println(line);
		}
		// Or: productPrice.forEach((key, value) -> {System.out.println(String.format("%-10s : %6.2f", key, value));});
	}

}
