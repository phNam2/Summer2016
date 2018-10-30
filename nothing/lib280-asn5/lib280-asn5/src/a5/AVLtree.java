package a5;

//Name: NAM HOANG PHAM			NSID: HNP435			Student No: 11183768


import lib280.tree.OrderedSimpleTree280;
import lib280.tree.*;

public class AVLtree<I extends Comparable<? super I>> extends OrderedSimpleTree280<I> {

	public AVLtree() {
		super();
	}

	/**
	 * 
	 */
	@Override
	public void insert(I x) {
		rootNode = this.insertAVL(x, rootNode);
	}
	
	
	/**
	 * 
	 * @param x
	 * @param current
	 * @return
	 */
	public BinaryNode280<I> insertAVL(I x, BinaryNode280<I> current)
	{
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
			if (((AVLNode<I>) current).getLeftHeight() - ((AVLNode<I>) current).getRightHeight() == 2) {
				
				if (x.compareTo(current.leftNode().item()) < 0) {
					
					current = this.RightRotation(current);
				}
				else {
					
					current = this.DoubleRightRotation(current);
				}
			}
				
			
		}
		else
		{
			
			if (current.rightNode() == null) {
				current.setRightNode(new AVLNode<I>(x));
			}
			else {
				current.setRightNode(insertAVL(x, current.rightNode()));
			}
			
			//Set the height of the right tree in the current node
			((AVLNode<I>) current).setRightHeight(max(current.rightNode()));
			
			//Check if the binary tree is unbalanced and if yes, fix it
			if (((AVLNode<I>) current).getLeftHeight() - ((AVLNode<I>) current).getRightHeight() == -2) {
				
				if (x.compareTo(current.rightNode().item()) > 0) {
					
					current = this.LeftRotation(current);
				}
				else {
					
					current = this.DoubleLeftRotation(current);
				}
			}
			
		}
		
		
		
		return current;
	}
	
	/**
	 * 
	 * @param current
	 * @return
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
	 * 
	 * @param current
	 * @return
	 */
	public BinaryNode280<I> RightRotation (BinaryNode280<I> current) {
		
		BinaryNode280<I> newNode = current.leftNode();
		current.setLeftNode(null);
		newNode.setRightNode(current);
		
		((AVLNode<I>) newNode.rightNode()).setLeftHeight(0);
		((AVLNode<I>) newNode).setRightHeight(( (AVLNode<I>) newNode.rightNode()).getRightHeight() + 1);
		
		return newNode;
		
	}
	
	
	/**
	 * 
	 * @param current
	 * @return
	 */
	public BinaryNode280<I> LeftRotation (BinaryNode280<I> current) {
		
		BinaryNode280<I> newNode = current.rightNode();
		current.setRightNode(null);
		newNode.setLeftNode(current);
		
		((AVLNode<I>) newNode.leftNode()).setRightHeight(0);
		((AVLNode<I>) newNode).setLeftHeight(( (AVLNode<I>) newNode.leftNode()).getLeftHeight() + 1);
		
		
		return newNode;
		
	}
	
	
	/**
	 * 
	 * @param current
	 * @return
	 */
	public BinaryNode280<I> DoubleRightRotation (BinaryNode280<I> current) {
		
		current.setLeftNode(LeftRotation(current.leftNode()));
		
		return RightRotation(current);
	}
	
	/**
	 * 
	 * @param current
	 * @return
	 */
	public BinaryNode280<I> DoubleLeftRotation (BinaryNode280<I> current) {
		
		current.setRightNode(RightRotation(current.rightNode()));
		
		return LeftRotation(current);
	}
	
	
	public static void main(String[] args) {


		AVLtree<Integer> tree1 = new AVLtree<Integer>();
		
		tree1.insert(10);
		tree1.insert(3);
		tree1.insert(6);
		tree1.insert(0);
		tree1.insert(1);
		//tree1.insert(5);
		//tree1.insert(11);
		
		
		System.out.println(tree1.toStringByLevel());
	}

}
