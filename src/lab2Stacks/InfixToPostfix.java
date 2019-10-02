package lab2Stacks;

public class InfixToPostfix {
	public static boolean checkBalance (String expression) { //part of the lab is to also make sure that there is no problem with the brackets
		LinkedStack <Character> openDelimiterStack = new LinkedStack<>();
		boolean isBalanced = true;
		int index = 0;
		int characterCount = expression.length();
		char nextCharacter;

		while (isBalanced && index < characterCount){
			nextCharacter = expression.charAt(index);
			switch (nextCharacter)
			{
			case '(': case '[': case '{':
				openDelimiterStack.push(nextCharacter);
				break;
			case ')': case ']': case '}':
				if (openDelimiterStack.isEmpty())
					isBalanced = false;
				else {
					char openDelimiter = openDelimiterStack.pop();
					isBalanced = 
							isPaired (openDelimiter, nextCharacter );
				}
				break;
			default: //irrelevant character
				break;

			}
			index ++;
		}
		if (!openDelimiterStack.isEmpty())
			isBalanced = false;

		return isBalanced;
	}

	private static boolean isPaired (char first, char second) {
		return (first == '(' && second == ')' ||
				first == '[' && second == ']' ||
				first == '{' && second == '}');
	}

	public static String convert(String a) {
		LinkedStack<Character> operatorStack = new LinkedStack<>();
		String postfix = "";

		while (!a.isEmpty()) {
			char nextChar = a.charAt(0);
			a = a.substring(1, a.length());
			if('0' <= nextChar && nextChar <= '9') {
				postfix += nextChar;
			} 
			else if(nextChar == '+' || nextChar == '-' || nextChar == '*' || nextChar == '/' || nextChar == '^') {
				while (!operatorStack.isEmpty() && precedence(nextChar)<= precedence(operatorStack.peek())) {
					postfix += operatorStack.peek();
					operatorStack.pop();
				}
				operatorStack.push(nextChar);
			} 
			else if(nextChar == '(') {
				operatorStack.push(nextChar);
			} 
			else if (nextChar == ')') {
				char topOperator = operatorStack.pop();
				while (topOperator != '(') {
					postfix += topOperator;
					topOperator = operatorStack.pop();	
				}
			} //ignore everything else is there is an unexpected variable
		}

		while (!operatorStack.isEmpty()) {
			char topOperator = operatorStack.pop();
			postfix += topOperator;
		}

		return postfix;
	}

	private static int precedence(char c) { //based on the symbols, a number is returned representing how import said symbols are
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
