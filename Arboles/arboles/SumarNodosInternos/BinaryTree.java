package SumarNodosInternos;

public class BinaryTree {

	private BinaryNode root;

	public BinaryTree() {
		root = null;
	}

	public BinaryTree(Integer root) {
		this.root = new BinaryNode(root, null, null);
	}

	public BinaryTree(Integer root, BinaryTree leftTree, BinaryTree rightTree) {
		this.root = new BinaryNode(root, leftTree.root, rightTree.root);
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
	
	public int sumarNodosInternos() {
		return sumarNodosInternos(root);
	}

	private int sumarNodosInternos(BinaryNode root) {
		
		if(root.getLeft() == null && root.getRight() == null)
			return 0;
		
		return root.getElement()
				+ sumarNodosInternos(root.getLeft())
				+sumarNodosInternos(root.getRight());
	} 
	
}