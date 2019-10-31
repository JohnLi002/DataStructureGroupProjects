package lab6SortedList;
/*
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

*/
public class Test {
	public static void main(String[] args) {
		/*
		try{
			File f = new File("encodedTest.txt");
			Scanner scan = new Scanner(f);
			while(scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
			

			scan.close();
		}catch(FileNotFoundException ex) {
			System.out.println("File not found");
		}
		*/
		FileDecoder decode = new FileDecoder("encodedTest.txt");
		decode.print();
	
	}
}
