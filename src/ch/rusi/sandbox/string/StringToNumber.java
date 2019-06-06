package ch.rusi.sandbox.string;

import java.text.DecimalFormat;
import java.text.ParseException;

public class StringToNumber {

	public static void main(String[] args) {

		String str = "1234x";

		// Convert using Integer.parseInt()
		try {
			int number = Integer.parseInt(str);
			System.out.println("Convert using Integer.parseInt() : " + number);
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		}

		// Convert using Integer.valueOf()
		int number1 = Integer.valueOf(str);
		System.out.println("Convert using Integer.valueOf() : " + number1);

		// Convert using new Integer(String).intValue()
		int number2 = new Integer(str).intValue();
		System.out.println("Convert using new Integer(String).intValue() : " + number2);

		// Convert using DecimalFormat
		DecimalFormat decimalFormat = new DecimalFormat("#");
		try {
		     int number3 = decimalFormat.parse(str).intValue();
		     System.out.println("Convert using DecimalFormat : " + number3);
		} catch (ParseException e) {
		     System.out.println(str + " is not a valid number.");
		}

	}

}
