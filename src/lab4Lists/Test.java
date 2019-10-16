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
				String temp = sc.next();
				for(int i = 0; i < temp.length(); i++)
				{
					if(temp.substring(i, i+1).contentEquals("?")
							|| temp.substring(i, i+1).contentEquals("!")
							|| temp.substring(i, i+1).contentEquals(",")
							|| temp.substring(i, i+1).contentEquals(".")
							|| temp.substring(i, i+1).contentEquals(":")
							|| temp.substring(i, i+1).contentEquals(";"))
					{
						temp = temp.substring(0, i) + temp.substring(i+1, temp.length());
					}
				}
				list.add(temp);
				System.out.print(temp);
			}
			
		} catch(FileNotFoundException ex) {
			System.out.println ("foxandcat.txt not found");
		}

	}
}
