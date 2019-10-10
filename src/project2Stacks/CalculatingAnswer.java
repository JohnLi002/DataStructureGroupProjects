package project2Stacks;

public class CalculatingAnswer {
	public static int evaluate(String s) { 
		int index = 0;
		//"12+32" = 12 32 +
		//Make it so that it registers numbers like 69 and 420
		LinkedStack<Integer> postfix = new LinkedStack<>();
		LinkedStack<Character> numStack = new LinkedStack<>();
		while(index != s.length()) {
			if(s.charAt(index) >= '0' && s.charAt(index) <= '9') { //checks if the character is a digit.
				String num = "";
				int temp = index;
				while(s.charAt(temp) != ' ') { //will keep looping until it reaches a whitespace
					numStack.push(s.charAt(temp));
					temp++;
				}
				numStack = reverse(numStack); //reverses the numbers in numStack
				while(!numStack.isEmpty()) { //will keep looping until numStack is empty
					num += numStack.pop(); //stores the number in numStack into num
				}
				postfix.push(Integer.parseInt(num)); //parseInt the num string into a number and pushes to postfix stack
			}else if(s.charAt(index) == '+' || s.charAt(index) == '-' ||
					 s.charAt(index) == '*' || s.charAt(index) == '/' ||
					 s.charAt(index) == '^') { //checks if the character is an operator
				int operandTwo = postfix.pop();
				int operandOne = postfix.pop();
				int result;
				if(s.charAt(index) == '+') {
					result = operandOne + operandTwo;
				}else if(s.charAt(index) == '-') {
					result = operandOne - operandTwo;
				}else if(s.charAt(index) == '*') {
					result = operandOne * operandTwo;
				}else if(s.charAt(index) == '/') {
					result = operandOne / operandTwo;
				}else {
					result = (int) Math.pow(operandOne, operandTwo);
				}
				postfix.push(result);
			}else {
				continue;
			}
			index++;
		}
		return postfix.pop();
	}
	public static LinkedStack<Character> reverse(LinkedStack<Character> c){
		LinkedStack<Character> numAssistant = new LinkedStack<>(); 
		while(!c.isEmpty()) { //will transfer the latest number of the c stack and pop it to numAssistant until c stack is empty
			numAssistant.push(c.pop());
		}
		return numAssistant; //placeholder for now
	}
}
