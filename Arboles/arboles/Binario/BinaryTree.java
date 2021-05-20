package Binario;

public class BinaryTree<T> {

	private BinaryNode<T> root;

	public BinaryTree() {
		root = null;
	}

	public BinaryTree(T root) {
		this.root = new BinaryNode<T>(root, null, null);
	}

	public BinaryTree(T root, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		this.root = new BinaryNode<T>(root, leftTree.root, rightTree.root);
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

	public BinaryNode<T> getRoot() {
		return root;
	}
}