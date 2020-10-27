package ch.rusi.sandbox.string;

import java.util.Set;

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

	public static String getLongestString(Set<String> strings) {
		Object[] list = strings.toArray();
		return getLongestString((String[]) list);
	}

}
