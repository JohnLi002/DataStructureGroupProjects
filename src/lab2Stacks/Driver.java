package lab2Stacks;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Input equation");
		String a = input.next();
		
		System.out.println(InfixToPostfix.convert(a));
		System.out.println(PostfixEvaluator.eval(InfixToPostfix.convert(a)));
		
		input.close();
	}
}
