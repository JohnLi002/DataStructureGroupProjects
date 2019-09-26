package lab2Stacks;

public class InfixToPostfix {
	public static String convert(String a) {
		LinkedStack<Character> operatorStack = new LinkedStack<>();
		String postfix = "";

		while (!a.isEmpty()) {
			char nextChar = a.charAt(a.length() - 1);
			a = a.substring(0, a.length() - 1);
					switch (nextChar)
					{
					case '0':
						postfix += nextChar;
						break;
					case '1':
						postfix += nextChar;
						break;
					case '^':
						operatorStack.push(nextChar);
						break;
					case '+':
						while (!operatorStack.isEmpty() && precedence(nextChar)<= precedence(operatorStack.peek())) {
							postfix += operatorStack.peek();
							operatorStack.pop();
						}
						operatorStack.push(nextChar);
						break;
					case '-':
						while (!operatorStack.isEmpty() && precedence(nextChar)<= precedence(operatorStack.peek())) {
							postfix += operatorStack.peek();
							operatorStack.pop();
						}
						operatorStack.push(nextChar);
						break;
					case '*':
						while (!operatorStack.isEmpty() && precedence(nextChar)<= precedence(operatorStack.peek())) {
							postfix += operatorStack.peek();
							operatorStack.pop();
						}
						operatorStack.push(nextChar);
						break;
					case '/' :
						while (!operatorStack.isEmpty() && precedence(nextChar)<= precedence(operatorStack.peek())) {
							postfix += operatorStack.peek();
							operatorStack.pop();
						}
						operatorStack.push(nextChar);
						break;
					case '(':
						operatorStack.push(nextChar);
						break;
					case ')' : // the stack is not empty
						char topOperator = operatorStack.pop();
						while (topOperator != '(') {
							postfix += topOperator;
							topOperator = operatorStack.pop();
						}
						break;
					default:
						break; // ignore unexpected characters

					}
		}

		while (!operatorStack.isEmpty()) {
			char topOperator = operatorStack.pop();
			postfix += topOperator;
		}
		
		return postfix;
	}
	
	private static int precedence(char c) {
		switch(c) {
		case '(':
			return 1;
		case ')':
			return 1;
		case '+':
			return 2;
		case '-':
			return 2;
		case '*':
			return 3;
		case '/':
			return 3;
		default: //the character must be '^'
			return 4;
		}
	}
}
