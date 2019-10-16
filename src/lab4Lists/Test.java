package lab4Lists;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		
		try {
			File foxandcat = new File("foxandcat.txt");
			Scanner sc = new Scanner(foxandcat);
			
			while (sc.hasNext())
			{
				
			}
			
		} catch(FileNotFoundException ex) {
			System.out.println ("foxandcat.txt not found");
		}

	}
}
