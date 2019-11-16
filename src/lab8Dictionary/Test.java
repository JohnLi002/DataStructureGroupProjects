package lab8Dictionary;
/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

public class Test {
	public static void main(String[] args) {
		String s = "Hello World!";
		StringBuilder sentence = new StringBuilder(s);
		int i = sentence.indexOf(" ");
		System.out.println(sentence.substring(0, i) + "!");
		System.out.println(sentence.substring(i+1, sentence.length()));
	}
}
