package project4Lists;

import java.util.Scanner;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

public class Test {
	public static void main(String[] args) {

		Game g = new Game();
		boolean restart = true;
		Scanner scan = new Scanner(System.in);
		while(restart) {
			System.out.println("you have " + g.getUser().getNumAces() + " Aces!");
			String input = scan.next();

			if(input.toLowerCase().equals("draw")) {
				g.drawCard();
			} else if(input.toLowerCase().equals("done")) {
				restart = false;
			} else if(input.toLowerCase().equals("aces")) {
				System.out.println(g.getHandValue());
				g.getUser().addAceValue(true);
				System.out.println(g.getHandValue());
			}
		}

		System.out.println(g.getComputer());
		System.out.println(g.getUser());

		
		scan.close();

	}
}