package ch.rusi.sandbox.lorem;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

public class LoremTest {
	
	/* --------------------------------------------------------------------------------
	 *	See https://github.com/mdeanda/lorem 
	 * --------------------------------------------------------------------------------
	 */

	public static void main(String[] args) {
		
		Lorem loremGenerator = LoremIpsum.getInstance();

		System.out.println("----------< Get exactly 5 words >----------");
		System.out.println(loremGenerator.getWords(5));
		System.out.println("----------< Get between 5 and 10 words randomly >----------");
		System.out.println(loremGenerator.getWords(5, 10));
		System.out.println("----------< Get paragraph with lines between 5 and 10 >----------");
		System.out.println(loremGenerator.getParagraphs(5, 10));
		System.out.println("----------< Get random full names >----------");
		System.out.println("  Gender neutral : " + loremGenerator.getName());
		System.out.println("  Male           : " + loremGenerator.getNameMale());
		System.out.println("  Female         : " + loremGenerator.getNameFemale());
		System.out.println("----------< Get 10 random first names >----------");
		for ( int i = 0 ; i < 10 ; i++ ) {
			System.out.println(loremGenerator.getFirstName());
		}
	}
}
