package a5;

//Name: NAM HOANG PHAM			NSID: HNP435			Student No: 11183768


import lib280.tree.OrderedSimpleTree280;
import lib280.tree.*;
import lib280.exception.*;

public class AVLTree280<I extends Comparable<? super I>> extends OrderedSimpleTree280<I> {

	/**
	 * Constructor for the AVLTre280 class
	 */
	public AVLTree280() {
		super();
	}

	/**
	 * The insert method of the AVLtree class
	 */
	@Override
	public void insert(I x) {
		rootNode = this.insertAVL(x, rootNode);
	}
	
	
	/**
	 * Inserting the given item into the given node subtree
	 * @param x			the item need to be inserted
	 * @param current	the node current node that is checked to insert the item
	 * @return			new AVLNode that contain a new subtree
	 * @O(log n)
	 */
	protected BinaryNode280<I> insertAVL(I x, BinaryNode280<I> current) {
		
		if (isEmpty()) {
			current = new AVLNode<I>(x);	
		}
		
		else if (x.compareTo(current.item()) < 0)
		{	
			
			if (current.leftNode() == null) {
				current.setLeftNode(new AVLNode<I>(x));//Insert to the empty node
				
			}
			else {
				current.setLeftNode(insertAVL(x, current.leftNode()));
			}
			
			
			//Set the height of the left tree in the current node
			((AVLNode<I>) current).setLeftHeight(max(current.leftNode()));
			
			//Check if the binary tree is unbalanced and if yes, fix it
			current = this.checkRightRotation(current);		
		}
		else {
			
			if (current.rightNode() == null) {
				current.setRightNode(new AVLNode<I>(x));
			}
			else {
				current.setRightNode(insertAVL(x, current.rightNode()));
			}
			
			//Set the height of the right tree in the current node
			((AVLNode<I>) current).setRightHeight(max(current.rightNode()));
			
			//Check if the binary tree is unbalanced and if yes, fix it
			current = this.checkLeftRotation(current);
		}
		
		return current;
	}
	
	
	
	/**
	 * Deleting the given item from the tree
	 * @param x		the item that is need to be deleted
	 * @throws ContainerEmpty280Exception		if the tree is empty, then the method throw an exception
	 */
	public void delete (I x) throws ContainerEmpty280Exception {
		
		if (isEmpty()) {
			throw new ContainerEmpty280Exception("The tree is empty!!!");
		}
		
		rootNode = this.deleteAVL(x, rootNode);

	}
	
	
	/**
	 * The recursive method that will delete the given item from the subtree of the current node
	 * @param x		the item that is need to be deleted
	 * @param current	the current node that being checked
	 * @return		a new not that is not contain the given item
	 * @O(log n)
	 */
	protected BinaryNode280<I> deleteAVL (I x, BinaryNode280<I> current) {
		
		// If the item is found, the start to do the deletion
		if ( x.compareTo(current.item()) == 0 ) {
			
			//The first case is when the tree have a right subtree and we can find the smallest node
			//in the right subtree of the current node
			if (current.rightNode() != null) {
				
				BinaryNode280<I> smallest = current;
				smallest = smallestInorder(current.rightNode());//Getting the smallest item in the right subtree
				//System.out.println(smallest.toString());
				
				current.setRightNode(this.deleteSmallestInorder(current.rightNode()));
				current.setItem(smallest.item());
				
				//After the deletion, we will return it height
				if (current.rightNode() == null) {
					
					((AVLNode<I>) current).setRightHeight(0);
				}
				else {
					
					((AVLNode<I>) current).setRightHeight( max(current.rightNode()) );
				}
				
				//Right rotation if the tree is left imbalance
				current = this.checkRightRotation(current);
				/*if (((AVLNode<I>) current).getLeftHeight() - ((AVLNode<I>) current).getRightHeight() == 2) {
					
					//If the current node is left imbalance
					current = this.RightRotation(current);
				}*/
			}
			else{
				
				//The second case is when the current node is a leaf node
				if (current.leftNode() == null) {
					
					current = null;
				}
				
				//The third case it when it still has the left node, and we only need to replace it with that left node 
				else {
					
					current = current.leftNode();
				}
			}		
		}
		
		else if ( x.compareTo(current.item()) < 0) {
			
			// If the we go to the last node in the subtree but does not find the item, 
			//it means it does not exist
			if ( current.leftNode() == null) {
				System.out.println("The item you want to delete does not exist");
			}
			else {
				
				current.setLeftNode(deleteAVL(x, current.leftNode()));
				
				// calculate the height of the left subtree of the current node
				if (current.leftNode() == null) {
					
					((AVLNode<I>) current).setLeftHeight(0);
				}
				else {
					
					((AVLNode<I>) current).setLeftHeight( max(current.leftNode()) );
				}
				
				//Left rotation if the tree is right imbalance			
				current = this.checkLeftRotation(current);
			}	
		}
		
		else {
			
			if ( current.rightNode() == null) {
				System.out.println("The item you want to delete does not exist");
			}
			else {
				current.setRightNode(deleteAVL(x, current.rightNode()));
				
				// calculate the height of the right subtree of the current node
				if (current.rightNode() == null) {
					
					((AVLNode<I>) current).setRightHeight(0);
				}
				else {
					
					((AVLNode<I>) current).setRightHeight( max(current.rightNode()) );
				}
				
				//Right rotation if the tree is left imbalance 
				current = this.checkRightRotation(current);
			}
		}
		
		return current;
	}
	
	
	/**
	 * This method will give back the smallest item of from the given node
	 * @param right		the node that is being checked
	 * @return			the smallest item of the given node
	 */
	public BinaryNode280<I> smallestInorder (BinaryNode280<I> right) {
		
		BinaryNode280<I> smallest = right;
		
		if (right.leftNode() != null) {
			
			smallest = smallestInorder (right.leftNode());
		}
		
		return smallest;
	}
	
	
	/**
	 * This method will delete the smallest item of from the given node
	 * @param right		the node that is being checked
	 * @return			the new node that does not contain the smallest item in its left subtree or it will return itself
	 */
	public BinaryNode280<I> deleteSmallestInorder (BinaryNode280<I> right) {
		
		
		//The tree will keep recursing until it meet the smallest of the right subtree 
		if (right.leftNode() != null) {
			
			right.setLeftNode(deleteSmallestInorder(right.leftNode()));
			
			if (right.leftNode() == null) {
				
				((AVLNode<I>) right).setLeftHeight(0);
			}
			else {
				((AVLNode<I>) right).setLeftHeight(this.max(right.leftNode()));
			}
			
			//Now we will check the imbalance case
			right = this.checkLeftRotation(right);
		} 
		else {
			
			//If this node has a right subtree, then we only need to swap them together (just like what we do in 
			//the deleteAVL method but we use right node as a substitution)
			if (right.rightNode() == null) {
				
				right = null;
			}
			else {
				
				right = right.rightNode();
			}
		}
		
		return right;
	}
	
	
	/**
	 * Return the height of the given node (including itself)
	 * @param current		the given node
	 * @return				the height of the given node
	 */
	public int max (BinaryNode280<I> current) {
		
		if (((AVLNode<I>) current).getLeftHeight() > ((AVLNode<I>) current).getRightHeight() ) {
			
			return 1+ ((AVLNode<I>) current).getLeftHeight(); 
		} 
		else {
			
			return 1+ ((AVLNode<I>) current).getRightHeight(); 
		}
	
	}
	
	/**
	 * Do the right rotation for the given critical node
	 * @param current		the critical node
	 * @return				the new critical node after the rotation
	 */
	protected BinaryNode280<I> RightRotation (BinaryNode280<I> current) {
		
		BinaryNode280<I> newNode = current.leftNode();
		current.setLeftNode(newNode.rightNode());// the old critical point get the right subtree of the new one
		newNode.setRightNode(current);
		
		
		//When rotation, the height of the subtree will change depend on whether there exist there exist a subtree or not,
		//so, if the old critical point doesn't get any subtree from the new one (null), the it left height is zero, else,
		//its left height will be the max of the left subtree
		if (current.leftNode() == null) {
			
			((AVLNode<I>) newNode.rightNode()).setLeftHeight(0);
		}
		else {
			
			((AVLNode<I>) newNode.rightNode()).setLeftHeight( max(newNode.rightNode().leftNode()) );
		}
		
		//The new critical node right height is also change after the rotation
		((AVLNode<I>) newNode).setRightHeight(max (newNode.rightNode()) );
		
		return newNode;
		
	}
	
	
	/**
	 * Do the left rotation for the given critical node
	 * @param current		the critical node
	 * @return				the new critical node after the rotation
	 */
	protected BinaryNode280<I> LeftRotation (BinaryNode280<I> current) {
		
		BinaryNode280<I> newNode = current.rightNode();
		current.setRightNode(newNode.leftNode());
		newNode.setLeftNode(current);
		
		//This rotation will do the same as the right rotation above
		if (current.rightNode() == null) {
			
			((AVLNode<I>) newNode.leftNode()).setRightHeight(0);
		}
		else {
			
			((AVLNode<I>) newNode.leftNode()).setRightHeight( max(newNode.leftNode().rightNode()) );
		}
		
		((AVLNode<I>) newNode).setLeftHeight(max (newNode.leftNode()) );
		
		return newNode;
		
	}
	
	
	/**
	 * Do the double right rotation for the given critical node
	 * @param current		the critical node
	 * @return				the new critical node after the rotation
	 */
	protected BinaryNode280<I> DoubleRightRotation (BinaryNode280<I> current) {
		
		//The Double right rotation will do the left Rotation in the left subtree first then do the right 
		//rotation in the critical node
		current.setLeftNode(LeftRotation(current.leftNode()));
		
		return RightRotation(current);
	}
	
	/**
	 * Do the double left rotation for the given critical node
	 * @param current		the critical node
	 * @return				the new critical node after the rotation
	 */
	protected BinaryNode280<I> DoubleLeftRotation (BinaryNode280<I> current) {
		
		//The Double left rotation will do the right Rotation in the right subtree first then do the leftt 
		//rotation in the critical node
		current.setRightNode(RightRotation(current.rightNode()));
		
		return LeftRotation(current);
	}
	
	/**
	 * Check if the critical node is left imbalance or LR imbalance, if yes, call the rotation method
	 * @param current		the critical node
	 * @return				the new critical node if it has imbalance
	 */
	public BinaryNode280<I> checkRightRotation(BinaryNode280<I> current) {

		if (((AVLNode<I>) current).getLeftHeight() - ((AVLNode<I>) current).getRightHeight() == 2) {
			
			//If the current node is left imbalance
			if (current.leftNode().rightNode() == null) {
				current = this.RightRotation(current);
			} 
			//If the current node is LL imbalance
			else {
				current = this.DoubleRightRotation(current);
			}

		}
		
		return current;
	}
	
	/**
	 * Check if the critical node is right imbalance or RL imbalance, if yes, call the rotation method
	 * @param current		the critical node
	 * @return				the new critical node if it has imbalance
	 */
	public BinaryNode280<I> checkLeftRotation(BinaryNode280<I> current) {
		
		if (((AVLNode<I>) current).getLeftHeight() - ((AVLNode<I>) current).getRightHeight() == -2) {
			
			//If the current node is left imbalance
			if (current.rightNode().leftNode() == null) {
				current = this.LeftRotation(current);
			} 
			//If the current node is LL imbalance
			else {
				current = this.DoubleLeftRotation(current);
			}

		}
		return current;
	}
	
	
	
	
	
	
	public static void main(String[] args) {

		//Create an object of AVLTree280 
		AVLTree280<Integer> tree1 = new AVLTree280<Integer>();
		
		//*********TESING**************//
		
		// Check the precondition of the delete() when the list is empty
		/*System.out.println("Check the empty tree by deleting 1 ");
		try {
			tree1.delete(1);
		} catch (ContainerEmpty280Exception x) {
			System.out.println(x+ "\n");
		}
		System.out.println("Empty tree: " + tree1.toStringByLevel() + "\n\n");
		
		
		//Now we will do the case for the insertion 
		tree1.insert(10);
		System.out.println("Insert 10: " + tree1.toStringByLevel() + "\n\n");
		
		tree1.insert(20);
		System.out.println("Insert 20: " + tree1.toStringByLevel() + "\n\n");
		
		tree1.insert(50);
		System.out.println("Insert 50: " + tree1.toStringByLevel() + "\n\n");
		
		tree1.insert(28);
		System.out.println("Insert 28: " + tree1.toStringByLevel() + "\n\n");
		
		tree1.insert(5);
		tree1.insert(0);
		System.out.println("Insert 5 and 0: " + tree1.toStringByLevel() + "\n\n");
		
		tree1.insert(38);
		System.out.println("Insert 38: " + tree1.toStringByLevel() + "\n\n");
		
		tree1.insert(15);
		tree1.insert(12);
		System.out.println("Insert 15, 12: " + tree1.toStringByLevel() + "\n\n");
		
		tree1.insert(57);
		tree1.insert(61);
		tree1.insert(60);
		System.out.println("Insert 57, 61, 60: " + tree1.toStringByLevel() + "\n\n");
		
		
		//Now we will do the case for the deletion
		tree1.delete(10);
		System.out.println("Delete 10: " + tree1.toStringByLevel() + "\n\n");
		
		System.out.println("Delete 14: ");
		tree1.delete(14);
		System.out.println(tree1.toStringByLevel() + "\n\n");
		
		tree1.delete(38);
		System.out.println("Delete 38: " + tree1.toStringByLevel() + "\n\n");
		
		tree1.delete(0);
		System.out.println("Delete 0: " + tree1.toStringByLevel() + "\n\n");
		
		tree1.delete(12);
		tree1.delete(15);
		System.out.println("Delete 12, 15: " + tree1.toStringByLevel() + "\n\n");
		
		tree1.delete(50);
		System.out.println("Delete 50: " + tree1.toStringByLevel() + "\n\n");
		
		tree1.delete(60);
		tree1.delete(61);
		System.out.println("Delete 60, 61: " + tree1.toStringByLevel() + "\n\n");
		
		System.out.println("Delete 100: ");
		tree1.delete(100);
		System.out.println(tree1.toStringByLevel() + "\n\n");
		
		tree1.delete(57);
		System.out.println("Delete 57: " + tree1.toStringByLevel() + "\n\n");
		
		tree1.insert(30);
		tree1.delete(5);
		System.out.println("Insert 30, then delete 5: " + tree1.toStringByLevel() + "\n\n");
		
		tree1.delete(30);
		tree1.delete(28);
		System.out.println("Delete 30, 28: " + tree1.toStringByLevel() + "\n\n");
		
		tree1.delete(20);
		System.out.println("Delete 20: " + tree1.toStringByLevel() + "\n\n");
		
		System.out.println("Delete 1: ");
		try {
			tree1.delete(1);
		} catch (ContainerEmpty280Exception x) {
			System.out.println(x+ "\n");
		}
		System.out.println("Empty tree: " + tree1.toStringByLevel() + "\n\n");
		
		
		System.out.println("THE END");*/
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		tree1.insert(50);
		tree1.insert(10);
		tree1.insert(60);
		tree1.insert(55);
		tree1.insert(65);
		tree1.insert(52);
		//tree1.insert(35);
		//tree1.insert(8);
		//tree1.insert(9);
		//tree1.insert(19);
		//tree1.insert(3);
		//tree1.insert(6);
		//System.out.println(tree1.toStringByLevel() + "\n\n");
		System.out.println(tree1.toStringByLevel() + "\n\n");
		
		//tree1.delete(50);
		//tree1.delete(15);
		
		
		//System.out.println(tree1.toStringByLevel() + "\n\n");
		
	}

}
