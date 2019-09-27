package lab2Stacks;

public class Test {
	public static void main(String[] args) {
		String a = "(1+2)*3";
		System.out.println(a);
		System.out.println(InfixToPostfix.convert(a)); //answer should 12+3*
		
	}
}
