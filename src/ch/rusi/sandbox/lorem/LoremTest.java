package ch.rusi.sandbox.lorem;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

public class LoremTest {
	
	/* --------------------------------------------------------------------------------
	 *	See https://github.com/mdeanda/lorem 
	 * --------------------------------------------------------------------------------
	 */

	public static void main(String[] args) {
		
		Lorem lorem = LoremIpsum.getInstance();
		
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println(lorem.getWords(5));
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println(lorem.getWords(5, 10));
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println(lorem.getParagraphs(2, 4));
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println(lorem.getName());
		System.out.println(lorem.getNameMale());
		System.out.println(lorem.getNameFemale());
		System.out.println("--------------------------------------------------------------------------------");
		for ( int i = 0 ; i < 10 ; i++ ) {
			System.out.println(lorem.getFirstName());
		}

	}

}
