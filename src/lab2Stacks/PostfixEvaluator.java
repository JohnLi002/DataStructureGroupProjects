package lab2Stacks;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

public class PostfixEvaluator {
	public static double eval(String a) {
		LinkedStack<Double> valueStack = new LinkedStack<>();
		while (!a.isEmpty()) { //Searches through the whole string.
			char nextChar = a.charAt(0);
			a = a.substring(1, a.length());
			if('0' <= nextChar && nextChar <= '9') {
				valueStack.push((double) (nextChar - '0')); //Turns the character into double after converting next to the proper number.
			}else if(nextChar == '+'  || nextChar == '-' || nextChar == '*' || nextChar == '/' || nextChar == '^') {
				double operandTwo = valueStack.pop();
				double operandOne = valueStack.pop();
				double result;
				
				if(nextChar == '+') {
					result = operandOne + operandTwo;
				}else if(nextChar == '-') {
					result = operandOne - operandTwo;
				}else if(nextChar == '*') {
					result = operandOne * operandTwo;
				}else if(nextChar == '/') {
					result = operandOne / operandTwo;
				}else{ //This is for the exponent.
					result = Math.pow(operandOne, operandTwo);
				}
				valueStack.push(result);
			}
		}
		return valueStack.pop();
	}
}
