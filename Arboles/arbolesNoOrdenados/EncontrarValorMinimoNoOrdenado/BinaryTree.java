package EncontrarValorMinimoNoOrdenado;

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

	public int valorMinimo() {
		return buscarValorMinimo(root);
	}
	
	private int buscarValorMinimo(BinaryNode root) {	
		
		int min = root.value();
		
		if(root.getLeft() != null) {
			min = Math.min(min, buscarValorMinimo(root.getLeft()));
		}
		if(root.getRight() != null) {
			min = Math.min(min, buscarValorMinimo(root.getRight()));
		}
		
		return min;
	}
	
}