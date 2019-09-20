package ch.rusi.sandbox.string;

public class StringUtil {
	
	public static String getLongestString(String[] array) {
		
		String longString = null;
		int maxLen = 0;
		
		for ( String s : array ) {
			if ( s.length() > maxLen ) {
				longString = s;
				maxLen = s.length();
			}
		}
		
		return longString;
		
	}

}
