package lab2Stacks;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

import java.util.Scanner;

public class UserUsage {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a string for evaluation, digits only: "); //prints instructions for user
		String a = input.next();
				
		if(!InfixToPostfix.checkBalance(a)) {
			System.out.println("Input error: unbalanced string"); //checks for unbalanced string
		} else {
			System.out.println(PostfixEvaluator.eval(InfixToPostfix.convert(a)));
		}
		
		input.close();
	}
}
