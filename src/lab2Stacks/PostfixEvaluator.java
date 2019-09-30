package lab2Stacks;

public class PostfixEvaluator {
	public static double eval(String a) {
		
		LinkedStack<Double> valueStack = new LinkedStack<>();
				while (!a.isEmpty()) {
					char nextCharacter = a.charAt(0);
							switch (nextCharacter) {
							case variable:
								valueStack.push(nextCharacter);
								break;
							case '+', '-', '*', '/', '^':
								operandTwo = valueStack.pop();
							operandOne = valueStack.pop();
							result = the result of the operation nextCharacter with the operands operandOne and operandTwo
									valueStack.push (result);
							break;
							default:
								break;
							}
				}
		
	}
}
