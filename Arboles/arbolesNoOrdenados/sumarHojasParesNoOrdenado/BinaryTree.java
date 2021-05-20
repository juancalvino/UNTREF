package sumarHojasParesNoOrdenado;

import HojasPares.BinaryNode;

public class BinaryTree {

	private BinaryNode root;

	public BinaryTree() {
		root = null;
	}

	public BinaryTree(Integer root) {
		this.root = new BinaryNode(root, null, null);
	}
	
	
	public BinaryTree(Integer root, BinaryTree leftTree, BinaryTree rightTree) {
		BinaryNode leftRoot = leftTree != null ? leftTree.root : null;
		BinaryNode rightRoot = rightTree != null ? rightTree.root : null;
		
		this.root = new BinaryNode(root, leftRoot, rightRoot);
	}

	public void printPreOrder() {
		if (root != null)
			root.printPreOrder();
	}

	public void printInOrder() {
		if (root != null)
			root.printInOrder();
	}

	public void printPostOrder() {
		if (root != null)
			root.printPostOrder();
	}

	public void makeEmpty() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public int size() {
		if (root != null)
			return root.size();
		else
			return 0;
	}

	public int height() {
		if (root != null)
			return root.height();
		else
			return -1;
	}

	public BinaryNode getRoot() {
		return root;
	}

	public int sumarHojasPares() {
		return sumarHojasPares(root);
	}
	
	private int sumarHojasPares(BinaryNode root) {	
		int suma = 0;
		
		if(root.getLeft() == null && root.getRight() == null) {
			return (root.value()%2) == 0
				    ? root.value()
				    : 0;
		}
		if(root.getRight() != null)
			suma+=sumarHojasPares(root.getRight());
		
		if(root.getLeft()!= null)
			suma+=sumarHojasPares(root.getLeft());
		
		return suma; 	
	}
	
}