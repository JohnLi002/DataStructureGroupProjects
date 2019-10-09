package project2Stacks;

public class CheckingUserInput {
	
	public static boolean balanceChecker(String equation) {
		LinkedStack<Character> paranthesis = new LinkedStack<>();
		while(!equation.isEmpty()) {
			char c = equation.charAt(0);
			equation = equation.substring(1, equation.length());
			if(c =='(') {
				paranthesis.push(c);
			} else if(c == ')' && paranthesis.isEmpty()) {
				return false; 
			} else if(c == ')') {
				paranthesis.pop();
			}
		}
		
		if(paranthesis.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}public static String convert(String a) {
		return ""; //placeholder for now
	}
	public static int precedence(char c) {
		return 0; //placeholder for now
	}
}
