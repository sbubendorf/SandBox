package ch.rusi.sandbox.arrays;

import java.util.ArrayList;

public class ArrayListExamples {

	public static void main(String[] args) {

	      ArrayList<String> arrayList = new ArrayList<>();

	      arrayList.add("JAVA");
	      arrayList.add("Csharp");
	      arrayList.add("Python");
	      arrayList.add("Php");
	      arrayList.add("Android");
	      arrayList.add("HTML");

	      //Adding "C++" at the sixth position
	      arrayList.add(5, "C++");

	      //displaying elements
	      System.out.println(arrayList);

	      // Remove elements
	      arrayList.remove("Php");
	      System.out.println(arrayList);

	      // Remove element at a certain position
	      arrayList.remove(2);
	      System.out.println(arrayList);
	      
	      
	      
	}

}
