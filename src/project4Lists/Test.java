package project4Lists;

import java.util.Scanner;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

public class Test {
	public static void main(String[] args) {
		Card[] c= {new Card("DIAMONDS","ACE"), new Card("SPADES","JACK")};
		Hand h = new Hand(c);
		Player p = new Player(h,0, h.getValue());
		p.addAceValue(true);
		System.out.println(p.getHandValue());
	}
}
