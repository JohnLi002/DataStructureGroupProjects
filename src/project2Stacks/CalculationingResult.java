package project2Stacks;

public class CalculationingResult {
	public int calculatingAnswer(String equation) { //will take in the equation and calculate the correct answer
		return 0; //a placeholder for now
	}
	public boolean balanceChacker(String equation) {
		LinkedStack<Character> paranthesis = new LinkedStack<>();
		while(!equation.isEmpty()) {
			char c = equation.charAt(0);
			equation = equation.substring(1, equation.length());
			if(c =='(') {
				paranthesis.push(c);
			} else if(c == ')' && paranthesis.isEmpty()) {
				return false;
			}
		}
		
		return false; //a placeholder for now
	}

}
