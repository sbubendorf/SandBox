package ch.rusi.sandbox.string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringExamples {

	public static void main(String[] args) {
		
		// -------------------------------------------------------------------------------------
		// Convert Arrays to String
		// -------------------------------------------------------------------------------------
		String[] counter = {"one","two","three","four","five"};
		System.out.println(Arrays.toString(counter));
		System.out.println(convertArrayToStringAppend(counter));
		System.out.println(convertArrayToStringUsingStreamAPI(counter));
		System.out.println(convertArrayToStringUsingCollectors(counter));

	}

	// using StringBuilder.append()
    public static String convertArrayToStringAppend(String[] strArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strArray.length; i++) {
            stringBuilder.append(strArray[i]);
        }
        return stringBuilder.toString();
    }
    
    // Using String.join() method
    public static String convertArrayToStringUsingStreamAPI(String[] strArray) {
        String joinedString = String.join("-", strArray);
        return joinedString;
    }
    
    // Using Stream API and Collectors
    public static String convertArrayToStringUsingCollectors(String[] strArray) {
        String joinedString = Arrays.stream(strArray)
            .collect(Collectors.joining());
        return joinedString;
    }

}
