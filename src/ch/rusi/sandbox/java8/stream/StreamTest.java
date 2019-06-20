package ch.rusi.sandbox.java8.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		
		String element = Arrays.asList("a1","a2","a3").stream().findFirst().get();
		System.out.println(element);
		
		Stream<String> list = Arrays.asList("a1","a2","a3").stream();
		System.out.println("Stream size : " + list.count());
		//System.out.println("Element 1 : " + list.findFirst());  // <<---- Exception because count alreday consumed the stream!!
		
		Arrays.asList("a1","a2","a3").stream();
		
		Iterator<String> iterator = Stream.of("a1","a2","a3").iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		// Convert a Stream to a List
		Stream<String> stream = Stream.of("a1","a2","a3");
		List<String> result = stream.collect(Collectors.toList());
		System.out.println("List size : " + result.size());
		for (String elem : result) {
			System.out.println(elem);
		}


	}

}
