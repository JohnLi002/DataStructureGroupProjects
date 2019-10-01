package lab2Stacks;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a string for evaluation, digits only: ");
		String a = input.next();
				
		if(!InfixToPostfix.checkBalance(a)) {
			System.out.println("Input error: unbalanced string");
		} else {
			System.out.println(PostfixEvaluator.eval(InfixToPostfix.convert(a)));
		}
		
		input.close();
	}
}
