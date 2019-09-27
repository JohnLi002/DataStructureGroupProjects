package lab2Stacks;

public class Test {
	public static void main(String[] args) {
		LinkedStack<Character> stack1 = new LinkedStack<>();
		String a = "(1+2)*3";
		System.out.println(a);
		System.out.println(InfixToPostfix.convert(a));
		
	}
}
