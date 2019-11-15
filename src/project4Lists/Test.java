package project4Lists;

import java.util.Scanner;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

public class Test {
	public static void main(String[] args) {

		Deck d = new Deck();
		
		Card[] c1 = d.deal();
		d.deal();
		d.deal();
		d.deal();
		d.deal();
		d.deal();
		
		for(int i =0 ; i< c1.length;i++) {
			System.out.println(c1[i]);
		}
		
		Card[] c = d.toArray();
		System.out.println();
		for(int i = 0; i < c.length; i++) {
			if(c[i].equals(c1[0])) {
				System.out.println(true);
			} else if(c[i].equals(c1[1])) {
				System.out.println(true);
			}
			System.out.println(i);
		}
		
	}
}