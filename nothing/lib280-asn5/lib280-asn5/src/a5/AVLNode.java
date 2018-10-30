package a5;

//Name: NAM HOANG PHAM			NSID: HNP435			Student No: 11183768


import lib280.tree.BinaryNode280;

public class AVLNode<I extends Comparable<? super I>> extends BinaryNode280<I> {

	/**
	 * The left subtree height of the node 
	 */
	protected int leftHeight;
	/**
	 * The right subtree height of the node 
	 */
	protected int rightHeight;
	
	/**
	 * Constructor for the AVLNode class
	 * @param x		the item value the node
	 */
	public AVLNode(I x) {
		super(x);
		leftHeight = 0;
		rightHeight = 0;
	}
	
	/**
	 * The method setting the right subtree height
	 * @param x		the given right subtree height
	 */
	public void setRightHeight (int x) {
		this.rightHeight = x;
		
	}

	/**
	 * The method setting the left subtree height
	 * @param x		the given left subtree height
	 */
	public void setLeftHeight (int x) {
		this.leftHeight = x;
	}
	
	
	/**
	 * The method returning the right subtree height
	 * @return		the current right subtree height
	 */
	public int getRightHeight () {
		return this.rightHeight;
	}
	
	
	/**
	 * The method returning the left subtree height
	 * @return		the current left subtree height
	 */
	public int getLeftHeight() {
		return this.leftHeight;
	}

}
