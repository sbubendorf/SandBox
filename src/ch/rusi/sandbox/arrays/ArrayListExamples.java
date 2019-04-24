package ch.rusi.sandbox.arrays;

import java.util.ArrayList;

public class ArrayListExamples {

	public static void main(String[] args) {

	      ArrayList<String> arlist = new ArrayList<String>(); 

	      arlist.add("JAVA");
	      arlist.add("Csharp");
	      arlist.add("Python");
	      arlist.add("Php");
	      arlist.add("Android");
	      arlist.add("HTML");

	      //Adding "C++" at the sixth position
	      arlist.add(5, "C++");

	      //displaying elements
	      System.out.println(arlist);		

	      // Remove elements
	      arlist.remove("Php");
	      System.out.println(arlist);

	      // Remove element at a certain position
	      arlist.remove(2);
	      System.out.println(arlist);
	      
	      
	      
	}

}
