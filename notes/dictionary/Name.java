package dictionary;

import java.util.Scanner;

public class Name {
	String firstName;
	String lastName;
	
	public Name(String first, String last) {
		
	}
	
	public Name(String full) {
		
	}
	
	@Override
	public boolean equals(Object o) {
		
		return false;
	}
	
	public void readFile(Scanner data) {
		String firstName = null, lastName = null;
		String phone;
		
		while(data.hasNext()) {
			firstName = data.next();
			lastName = data.next();
			phone = data.next();
		}
		Name name = new Name(firstName, lastName);
		//phonebook.add(name, phone);
	}
	public String getPhone(Name name) {
		return phonebook.getValue(name);
	}
}
