package lab2Stacks;

public class InfixToPostfix {
	private static boolean checkBalance (String expression) { //part of the lab is to also make sure that there is no problem with the brackets
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
                default: //irelevant character
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
		if(!checkBalance(a)) { //checks to make sure that everything actually closes
			return "nope";
		}
		
		LinkedStack<Character> operatorStack = new LinkedStack<>();
		String postfix = "";

		while (!a.isEmpty()) {
			char nextChar = a.charAt(0);
			a = a.substring(1, a.length());
					switch (nextChar) {
					case '0': // checks for numbers 0 to 9 variables
						postfix += nextChar;
						break;
					case '1':
						postfix += nextChar;
						break;
					case '2':
						postfix += nextChar;
						break;
					case '3':
						postfix += nextChar;
						break;
					case '4':
						postfix += nextChar;
						break;
					case '5':
						postfix += nextChar;
						break;
					case '6':
						postfix += nextChar;
						break;
					case '7':
						postfix += nextChar;
						break;
					case '8':
						postfix += nextChar;
						break;
					case '9':
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
						while (!operatorStack.isEmpty() && precedence(nextChar) <= precedence(operatorStack.peek())) {
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
