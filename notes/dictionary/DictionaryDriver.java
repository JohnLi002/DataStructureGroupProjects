package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DictionaryDriver {
	private static final Name QUIT = new Name("quit","quit");
	private static final Name ERROR = new Name("error","error");

	public static void main(String[] args) {
		TelephoneDirectory dictionary = new TelephoneDirectory();
		boolean created = false;
		try {
			Scanner read = new Scanner(new File("phones.txt"));
			created = true;
		} catch(FileNotFoundException ex) {
			
		}
		
		if(created) {
			Name nextName = getName();
			
			while(nextName.equals(QUIT)) {
				if(nextName.equals(ERROR)) {
					System.out.println("try again");
					nexName = getName();
				}else {
					String phoneNumber = directory.getPhone(nextName);
					//output
				}
			}
		}
	}
	
	public String getPhone(Name name) {
		return phonebook.getValue(name);
	}
}
