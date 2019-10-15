package project2Stacks;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

public class Test {
	public static void main(String[] args) {
		LinkedStack<Integer> nums = new LinkedStack<>();
		nums.push(1);
		nums.push(2);
		nums.push(3);
		System.out.println(nums.peek());
		System.out.println(nums.pop());
		System.out.println(nums.pop());
		System.out.println(nums.isEmpty());
		nums.clear();
		System.out.println(nums.isEmpty());
		
		System.out.println();
		System.out.println("11+22*2");
		System.out.println(CalculatingAnswer.evaluate("11+22*2") +"\n"); //checking to see if double digits work
		System.out.println("1-2*3/5");
		System.out.println(CheckingUserInput.convert("1 - 2 * 3 / 5 + 1")); //checking to see what would method handle multiple operators and spaces
		System.out.println(CalculatingAnswer.evaluate("1 - 2 * 3 / 5 + 1") +"\n"); //should get 1
		System.out.println("5^3/5");
		System.out.println(CalculatingAnswer.evaluate("5^3/5") +"\n"); //checking to see if power operation should work
		System.out.println("(3-2)*8");
		System.out.println(CalculatingAnswer.evaluate("(3-2)*8") +"\n"); //chacking to see if paranthesis works
		System.out.println("3-4-5");
		System.out.println(CalculatingAnswer.evaluate("3-4-5") +"\n"); //checking for negative answer
		System.out.println("1+2+3");
		System.out.println(CalculatingAnswer.evaluate("1+2+3"));
	}
}
