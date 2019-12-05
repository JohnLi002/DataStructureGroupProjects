package project5Trees;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Problem1Answers {
	public static void main(String[] args) {
		/*
		 * 1.	Specify and implement a class of binary search trees in which duplicate entries are allowed. 
		 * 		Place the duplicate entry in the entry’s left or right subtree at random. 
		 * 		Thus, the definition of a binary search is modified as follows:
		 * 			-For each node in a binary search treThe data in a node is greater than or equal to the data in 
		 * 			 the node’s left subtree
		 * 			-The data in a node is less than or equal to the data in the node’s right subtree
		 * 		Provide a method that searches the tree for a given entry and returns the first one it finds. 
		 * 		Also, provide a method that returns a list of all entries that match the given one.
		 * 		Searching for a duplicate must allow a search in both subtrees.
		 */
		
		
		
		//						C							
		//					   / \
		//					  D   B
		//                   /     \
		//					E		A
		//				   /	   /
		//				  E		  A
		//				 /
		//              F
		
		
		String a = "A";
		String b = "B";
		String c = "C";
		String d = "D";
		String e = "E";
		String f = "F";
		BinarySearchTree<String> tree = new BinarySearchTree<>(c, null, null);
		tree.add(b);
		tree.add(a);
		tree.add(d);
		tree.add(a);
		tree.add(e);
		tree.add(e);
		tree.add(f);
		
		//Levelorder: C D B E A E A F
		
		System.out.print("LevelOrder: "); 
		Iterator<String> i = tree.getInorderIterator();
		while(i.hasNext()) {
			System.out.print(i.next() + " ");
		}
		
		
		
		System.out.println("\n\n"+"2 Question");
		
		/* 
		 * 	2.	Write Java code that creates a binary search tree (implemented in part 1)  from n random integers in the 
		 * 		range 0 to 50, outputs them using inorder iterator, and returns the height of the search tree. 
		 * 		Run your code for n=2^h-1 where h ranges from 4 to 10. Compare the height of the randomly built tree with h, 
		 * 		the height of the shortest binary tree.
		 */
		
		Integer num = new Integer((int) (Math.random() * 51)); //random num from 0 - 50
		BinarySearchTree<Integer> tree2 = new BinarySearchTree<>(num, null, null);
		
		int h = (int) (Math.random()*7) + 4;
		int n = ( 2^h )-1;

		for(int count = 0; count < n; count++) {
			num = new Integer((int) (Math.random() * 51));
			tree2.add(num);
		}
		
		System.out.print("\n" + "Inorder: ");
		Iterator<Integer> i2 = tree2.getInorderIterator();
		while(i2.hasNext()) {
			System.out.print(i2.next() + " ");
		}
		System.out.println("\n"+"height: " + tree2.getHeight());
		System.out.println("h = " + h + " n: " + n);
		
		
		/*
		 *  3.	Create a class Name as in lab 8, make it comparable by comparing just first names, then create a 
		 *  	binary search tree out of names in the provided file names.txt. 
		 * 		This way of comparing makes names like “Mark Julius” and “Mark Twain” duplicate entries. Make sure that 
		 * 		searching for matches to any name (e.g. “John”) brings the correct list of names.
		 */
		
		
		try(Scanner s = new Scanner(new File("src/names.txt"));){
			Name tree3_temp = new Name(s.nextLine());
			BinarySearchTree<Name> tree3 = new BinarySearchTree<>(tree3_temp, null, null);
			while(s.hasNextLine()) {
				Name name = new Name(s.nextLine());
				tree3.add(name);
			}
			
			Iterator<Name> iterate = tree3.getInorderIterator();
			System.out.println("\n\n" + "Names: ");
			while(iterate.hasNext()) {
				System.out.println(iterate.next());
			}
			
		} catch(FileNotFoundException ex) {
			System.out.println("File not found");
		}
	}
}
