package project5Trees;

import java.util.Iterator;

public class Problem1Answers {
	public static void main(String[] args) {
		/*
		 * 1.	Specify and implement a class of binary search trees in which duplicate entries are allowed. 
		 * 		Place the duplicate entry in the entry�s left or right subtree at random. 
		 * 		Thus, the definition of a binary search is modified as follows:
		 * 			-For each node in a binary search treThe data in a node is greater than or equal to the data in 
		 * 			 the node�s left subtree
		 * 			-The data in a node is less than or equal to the data in the node�s right subtree
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
		Iterator<String> i = tree.getLevelorderIterator();
		while(i.hasNext()) {
			System.out.print(i.next() + " ");
		}
		
		
		
		
		
		/* 
		 * 	2.	Write Java code that creates a binary search tree (implemented in part 1)  from n random integers in the 
		 * 		range 0 to 50,  outputs them using inorder iterator, and returns the height of the search tree. 
		 * 		Run your code for n=2^h-1 where h ranges from 4 to 10. Compare the height of the randomly built tree with h, 
		 * 		the height of the shortest binary tree.
		 */
		
		
		
		
		/*
		 *  3.	Create a class Name as in lab 8, make it comparable by comparing just first names, then create a 
		 *  	binary search tree out of names in the provided file names.txt. 
		 * 		This way of comparing makes names like �Mark Julius� and �Mark Twain� duplicate entries. Make sure that 
		 * 		searching for matches to any name (e.g. �John�) brings the correct list of names.
		 */
		
		
		
		
		
	}
}