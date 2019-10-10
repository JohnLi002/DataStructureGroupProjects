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
		String result = "";
		LinkedStack<Character> operators = new LinkedStack<>();
		boolean numDigit = true; //when operators are added last, this boolean will make sure a single space is inputted
		
		while(!a.isEmpty()) {
			char c = a.charAt(0);
			a = a.substring(1, a.length());
			
			if(c >= '0' && c <= '9') {
				result += c;
			} else if(c == '*' || c == '/' || c == '+' || c== '-' || c== '^') {
				while(!operators.isEmpty() && precedence(c) <= precedence(operators.peek())) { //makes sure that all numbers with greater or equal importance is thrown into the equation first
					result += operators.pop();
				}
				
				result += " "; //an operator means that the number has ended
				
				operators.push(c);
			} else if(c == '(') {
				operators.push(c);
			} else if(c == ')') {
				while(!(operators.peek() == '(')) {
					result += operators.pop();
				}
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
	
	private static int precedence(char c) {
			if(c== '(') {
				return 1;
			} else if(c == ')') {
				return 1;
			} else if(c == '+') {
				return 2;
			} else if(c == '-') {
				return 2;
			} else if(c == '*') {
				return 3;
			} else if(c == '/') {
				return 3;
			} else { //must be '^'
				return 4;
			}
		}
	
}
