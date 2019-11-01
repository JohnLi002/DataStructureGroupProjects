package project4Lists;

import java.util.Scanner;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

public class Test {
	public static void main(String[] args) {
		Deck d = new Deck();
		for(int i = 0; i < 52; i++)
			System.out.println(d.draw().toString());
		Scanner input = new Scanner(System.in);
		input.nextLine();
		input.close();
		
	}
}
