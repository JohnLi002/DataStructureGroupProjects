package project2Stacks;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

public class CheckingUserInput {

/* Method unneeded in the end
	public static boolean balanceChecker(String equation) { //important for checking balance at the last moment
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
	}
*/
	public static String convert(String a) {
		String result = "";
		LinkedStack<Character> operators = new LinkedStack<>();
		boolean numDigit = true; //checks to see if there is a digit to create space
		
		while(!a.isEmpty()) {
			char c = a.charAt(0);
			a = a.substring(1, a.length());
			
			if(c >= '0' && c <= '9') {
				result += c;
				numDigit = true; //there are in fact numbers so a space might be needed
			} else if(c == '*' || c == '/' || c == '+' || c== '-' || c == '^') {
				if(numDigit) {
					result += " "; //creates a space if there was previously digit
					numDigit = false; //no need for an extra space for now
				}
				while(!operators.isEmpty() && precedence(c) <= precedence(operators.peek())) { 
				//makes sure that all numbers with greater or equal importance is thrown into the equation first
					result += operators.pop();
				}
				
				operators.push(c);
			} else if(c == '(') {
				operators.push(c);
			} else if(c == ')') {
				
				result += " "; //a space needed to separate nums and operators
				while(!(operators.peek() == '(')) {
					result += operators.pop();
				}
				numDigit = false;
				operators.pop(); //gets rid of remaining '('
			} else {
				continue; //this statement is just to let the user know that there is nothing else to check for
			}
		}
		
		while(!operators.isEmpty()) { //just in case there is a single operator left in the stack
			if(numDigit) {
				result += " ";
				numDigit = false;
			}
			result+=operators.pop();
		}
		
		return result;
	}
	
	private static int precedence(char c) { //checks for precedence or importance. An important operator is something that is done first
			//more important = higher number
			if(c== '(' || c == ')') {
				return 1;
			} else if(c == '+' || c == '-') {
				return 2;
			} else if(c == '*' || c == '/') {
				return 3;
			} else { //must be '^'
				return 4;
			}
		}
	
}
