package ch.rusi.sandbox.string;

import java.util.HashSet;

public class StringSplitExample {
	
	private HashSet<String> userNames = new HashSet<String>();
	
	public StringSplitExample() {
	}

	private void run() {

		addUserName("B040910");
		addUserName("B040910");
		addUserName("B040910");
		addUserName("B040910_gugus");
		addUserName("B040910_gugus");
		addUserName("B040910_gugus");
		
		listUserName();
		
	}

	private void listUserName() {
		for(String userName : userNames) {
			System.out.println(userName);
		}
	}

	public static void main(String[] args) {

		StringSplitExample inst = new StringSplitExample();
		inst.run();
		
	}
	
	private void addUserName(String userName) {
		
		int postfix = 0;
		if ( userNames.contains(userName) ) {
			String[] nameParts = userName.split("_");
			String postFixPart = "";
			String userNamePart = "";
			for ( int i = 0 ; i == 0 || i < nameParts.length-1 ; i++ ) {
				userNamePart += nameParts[i] + "_";
			}
			if ( nameParts.length > 1 ) {
				postFixPart = nameParts[nameParts.length-1];
				try {
					postfix = Integer.parseInt(postFixPart);
				} catch (NumberFormatException e) {
					// Current postfix is not numeric --> Add numeric postfix
					System.out.println("The postfix '" + nameParts[1] + "' of the user name '" + userName + "' is not numerci!");
					userNamePart += postFixPart + "_";
				}
			}
			postfix += 1;
			addUserName(userNamePart + postfix);
		} else {
			userNames.add(userName);
		}
	}
	
}
