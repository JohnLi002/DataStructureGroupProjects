package lab4Lists;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		AList<String> alist = new AList<>();
		
		try {
			File foxandcat = new File("foxandcat.txt");
			Scanner sc = new Scanner(foxandcat);
			
			//adds strings into a list
			list = (LinkedList<String>) fileIntoList(sc, list); 
			
			//	remove all words starting with A or a
			list = (LinkedList<String>) removeA(list);
			
			
			//	find the indices of "TO" and "BE"
			findTOandBE(list);
			
			//	replace "FOX" with "ELEPHANT"
			list = (LinkedList<String>) replaceFox(list);
			
			//printwriter
			PrintWriter printer = new PrintWriter("elephantandcat.txt");
			for (int i = 0; i < list.getLength(); i++)
			{
				if (i % 15 == 14) {
					printer.println(list.getEntry(i) + " ");
				}
				else {
					printer.print(list.getEntry(i) + " ");
				}
			}
			printer.close();
			
			//	clear & make sure its empty
			list.clear();
			if(list.isEmpty()) {
				System.out.println('\n' + "LinkedList is now empty.");
			}
			
			sc.close();
			Scanner s = new Scanner(foxandcat);
			alist = (AList<String>) fileIntoList(s, alist); 
			alist = (AList<String>) removeA(alist);
			findTOandBE(alist);
			alist = (AList<String>) replaceFox(alist);
			
			PrintWriter printer2 = new PrintWriter("elephantandcatArray.txt");
			for (int i = 0; i < alist.getLength(); i++)
			{
				if (i % 15 == 14) {
					printer2.println(alist.getEntry(i) + " ");
				}
				else {
					printer2.print(alist.getEntry(i) + " ");
				}
			}
			printer2.close();
			
			alist.clear();
			if(alist.isEmpty()) {
				System.out.println("\n" + "ArrayList is empty");
			}
			s.close();
			
		} catch(FileNotFoundException ex) {
			System.out.println ("foxandcat.txt not found");
		}

	}
	
	private static ListInterface<String> fileIntoList(Scanner input, ListInterface<String> words) {
		while (input.hasNext())
		{
			String temp = input.next();
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
			words.add(temp);
		}
		
		return words;
	}
	
	private static ListInterface<String> removeA(ListInterface<String> newList){
		
		for (int i = 0; i < newList.getLength(); i++) {
			if (newList.getEntry(i).substring(0, 1).contentEquals("a") || newList.getEntry(i).substring(0, 1).contentEquals("A")){
				newList.remove(i);
				i--;
			}
		}
		
		return newList;
	}
	
	private static void findTOandBE(ListInterface<String> list) {
		for (int i = 0; i < list.getLength(); i++) {
			if (list.getEntry(i).contentEquals("to") || list.getEntry(i).contentEquals("be")) {
				System.out.print(" " + list.getEntry(i) + "" + i);
			}
		}
	}
	
	private static ListInterface<String> replaceFox(ListInterface<String> list){
		for (int i = 0; i < list.getLength(); i++)
		{
			if (list.getEntry(i).contains("Fox"))
			{
				list.replace(i, "Elephant");
			}
			else if (list.getEntry(i).contains("fox"))
			{
				list.replace(i, "elephant");
			}
		}
		return list;
	}
	
	
	
}
