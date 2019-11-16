package lab8Dictionary;
/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class TelephoneDirectory {
	private DictionaryInterface <Name, String> dictionary;
	public TelephoneDirectory (){
		dictionary = new ArrayDictionary <>();
		//dictionary = new SortedLinkedDictionary <> ();
	}

	public void display () {
		Iterator <Name> ni = dictionary.getKeyIterator();
		Iterator <String> si = dictionary.getValueIterator();

		while (ni.hasNext()) {
			System.out.println (ni.next() + " " + si.next());
		}

		System.out.println("Finished displaying");
	}

	public void readFile(Scanner data){
		String firstName, lastName, phoneNumber;
		Name fullName;
		while (data.hasNext()) {
			
			firstName = data.next();
			lastName = data.next();
			phoneNumber = data.next();
			while(phoneNumber.charAt(0) < '0' || phoneNumber.charAt(0) > '9') {
				lastName += (" " + phoneNumber);
				phoneNumber = data.next();
			}
			
			fullName = new Name(firstName, lastName);
			dictionary.add(fullName, phoneNumber);
		}
	}
	
	public  String getPhoneNumber(Name name){
		return dictionary.getValue(name);
	} 

	public void removePhoneNumber (Name name) {
		dictionary.remove (name);
	}

	public void removePhoneNumber (String fullName) {
		Name fname = new Name (fullName);
		dictionary.remove (fname);
	}

	public static void main(String[] args) {

		try {
			TelephoneDirectory td = new TelephoneDirectory();	
			File cinemas = new File ("movie.txt");

			Scanner fileSc = new Scanner (cinemas);

			td.readFile (fileSc);

			td.display();
			String theaterName = "West Newton Cinema";

			System.out.println(theaterName + td.getPhoneNumber (theaterName));

			td.removePhoneNumber ("Capitol Theatre");

			theaterName = "Museum Of Science";

			System.out.println(theaterName + td.getPhoneNumber (theaterName));

			td.removePhoneNumber (theaterName);

			td.display();

			String phoneNumber;
			Scanner input = new Scanner (System.in);
			do {
				System.out.println ("What name are you looking for to get phone number? ");
				System.out.println (" Type quit if none");
				String searchName = input.nextLine();
				if (searchName.equals("quit"))
					break;
				phoneNumber = td.getPhoneNumber (searchName);
				if (phoneNumber == null)
					System.out.println ("No such theater");
				else
					System.out.println (phoneNumber);
			} while (true);
			input.close();
		}
		catch (FileNotFoundException ex) {
			System.out.println ("File movies.txt not found in the " +
					"project directory");
		}
	}

	//was given strings instead of Name so fixed it by created a new method
	private String getPhoneNumber(String searchName) { 
		Name n = new Name(searchName);
		return dictionary.getValue(n);
	}



}