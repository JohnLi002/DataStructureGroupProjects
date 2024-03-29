package lab9Trees;

/**
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

public class Parts2and3 {
	/*	2) Create a binary tree corresponding to the following diagram:
	 *				   (A)
	 *				  /	  \
	 *				 /	   \
	 *				/	    \
	 *			  (B)	    (C)
	 *			 /   \	   /   \
	 *		   (D)   (E) (F)   (G)
	 *		   / \			   / \
	 *		 (H) (I)		 (J) (K)
	 *			   \
	 *			   (L)
	 */	
//		//		//		//		//		//		//		//		//		//		//		//
	/*	3) Output the height of this tree, the number of nodes,
	 *		all leaves, and four tree traversals.
	 */	

	public static void main(String[] args)
	{
		//	START Part 2

		BinaryTree<String> BT_L = new BinaryTree<String> ("L", null, null);
		BinaryTree<String> BT_I = new BinaryTree<String> ("I", null, BT_L);
		BinaryTree<String> BT_H = new BinaryTree<String> ("H", null, null);
		BinaryTree<String> BT_D = new BinaryTree<String> ("D", BT_H, BT_I);
		BinaryTree<String> BT_E = new BinaryTree<String> ("E", null, null);
		BinaryTree<String> BT_B = new BinaryTree<String> ("B", BT_D, BT_E);
		
		BinaryTree<String> BT_J = new BinaryTree<String> ("J", null, null);
		BinaryTree<String> BT_K = new BinaryTree<String> ("K", null, null);
		BinaryTree<String> BT_G = new BinaryTree<String> ("G", BT_J, BT_K);
		BinaryTree<String> BT_F = new BinaryTree<String> ("F", null, null);
		BinaryTree<String> BT_C = new BinaryTree<String> ("C", BT_F, BT_G);
		
		BinaryTree<String> BT_A = new BinaryTree<String> ("A", BT_B, BT_C);
			//NOTE: BT_A is the binary tree corresponding to the prompted diagram
		//	END Part 2
//		//		//		//		//		//		//		//		//		//		//		//
		//	START Part 3
		System.out.println("___Prompted_Tree___");
		System.out.println("  height: " + BT_A.getHeight() );
		System.out.println("  number of nodes: " + BT_A.getNumberOfNodes() );
		System.out.print("  leaves: "); BT_A.outputLeaves();
		
		
		System.out.println('\n' + "  four tree traversals: ");
		System.out.println("    Pre-Order:"		+ '\t' + "  A B D H I L E C F G J K");
		System.out.print("    Iterator:" + "\t" + "  ");
		Iterator<String> i = BT_A.getPreorderIterator();
		while(i.hasNext()) {
			System.out.print(i.next() + " ");
		}
		System.out.println("\n");
		
		
		System.out.println("    In-Order:"		+ '\t' + "  H D I L B E A F C J G K");
		System.out.print("    Iterator:" + "\t" + "  ");
		i = BT_A.getInorderIterator();
		while(i.hasNext()) {
			System.out.print(i.next() + " ");
		}
		System.out.println("\n");
		
		
		System.out.println("    Post-Order:"	+ '\t' + "  H L I D E B F J K G C A");
		System.out.print("    Iterator:" + "\t" + "  ");
		i = BT_A.getPostOrderIterator();
		while(i.hasNext()) {
			System.out.print(i.next() + " ");
		}
		System.out.println("\n");
		
		
		System.out.println("    Level-Order:"	+ "  A B C D E F G H I J K L");
		System.out.print("    Iterator:" + "\t" + "  ");
		i = BT_A.getLevelorderIterator();
		while(i.hasNext()) {
			System.out.print(i.next() + " ");
		}
		System.out.println("\n");
		
		//	END Part 3
		// other tests
		
		System.out.println(BT_A.getRightChild().getData());
		System.out.println(BT_A.getLeftChild().getData());
		System.out.println(BT_A.getRootData());
	}
}
