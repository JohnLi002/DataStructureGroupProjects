package lab9Trees;

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
		System.out.println("_Prompted Tree_");
		System.out.print("  height: " + BT_A.getHeight() );
		System.out.print("  number of nodes: " + BT_A.getNumberOfNodes() );
		System.out.print("  leaves: ");
		System.out.print("  four tree traversals: ");
		//	END Part 3
	}

}
