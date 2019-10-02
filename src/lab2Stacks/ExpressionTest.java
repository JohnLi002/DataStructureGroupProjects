package lab2Stacks;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

public class ExpressionTest {
	public static void main(String[] args) {
		String a = "(1+2)*3";
		System.out.println(a);
		System.out.println(InfixToPostfix.convert(a)); //answer should 12+3*
		System.out.println(PostfixEvaluator.eval(InfixToPostfix.convert(a)) + "\n");
		
		String b = "3*(3/3)";
		System.out.println(b);
		System.out.println(InfixToPostfix.convert(b)); //trying to test whether paranthesis really has priority
		System.out.println(PostfixEvaluator.eval(InfixToPostfix.convert(b)) + "\n"); //prints out 3.00
		
		String c = "6-5^3";
		System.out.println(c);
		System.out.println(InfixToPostfix.convert(c)); //checks for subtractions and to power of
		System.out.println(PostfixEvaluator.eval(InfixToPostfix.convert(c)) + "\n");
		
		String d = "1+3/9"; //now checking if decimal results work
		System.out.println(d);
		System.out.println(InfixToPostfix.convert(d));
		System.out.println(PostfixEvaluator.eval(InfixToPostfix.convert(d)) + "\n");
		
		String e = "4*5/6"; //testing both multiplication and division
		System.out.println(e);
		System.out.println(InfixToPostfix.convert(e));
		System.out.println(PostfixEvaluator.eval(InfixToPostfix.convert(e)) + "\n");
		
		String f = "3+4-2"; //simple addition and subtraction
		System.out.println(f);
		System.out.println(InfixToPostfix.convert(f));
		System.out.println(PostfixEvaluator.eval(InfixToPostfix.convert(f)));
		
		String g = "(4-5";
		System.out.println(g);
		System.out.println(InfixToPostfix.checkBalance(g) + "\n");
		
		String h = "5-3)";
		System.out.println(h);
		System.out.println(InfixToPostfix.checkBalance(h) + "\n");
		
		String i = "((2-3)";
		System.out.println(i);
		System.out.println(InfixToPostfix.checkBalance(i) + "\n");
		
		String j = "((7-9)*(3+3))";
		System.out.println(j);
		System.out.println(InfixToPostfix.checkBalance(j));
		System.out.println(InfixToPostfix.convert(j));
		System.out.println(PostfixEvaluator.eval(InfixToPostfix.convert(j)));
	}
}
