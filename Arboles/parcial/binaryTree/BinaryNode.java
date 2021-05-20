package binaryTree;

@SuppressWarnings("hiding")
public class BinaryNode<T> {
	private T element;
	private BinaryNode <T>left;
	private BinaryNode <T>right;

	public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
		this.element = element;
		this.left = left;
		this.right = right;
	}

	public BinaryNode(T x) {
		this.element = x;
		this.left = null;
		this.right = null;
	}

	public int size() {
		int size = 1;
		if (left != null)
			size += left.size();
		if (right != null)
			size += left.size();
		return size;
	}

	public int height() {
		int leftHeight = -1;
		int rightHeight = -1;
		if (left != null)
			leftHeight = left.height();
		if (right != null)
			rightHeight = left.height();
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public void printPreOrder() {
		System.out.println(element);
		if (left != null)
			left.printPreOrder();
		if (right != null)
			right.printPreOrder();
	}
	
	

	public void printPostOrder() {
		if (left != null)
			left.printPostOrder();
		if (right != null)
			right.printPostOrder();
		System.out.println(element);
	}

	public void printInOrder() {
		if (left != null)
			left.printInOrder();
		System.out.println(element);
		if (right != null)
			right.printInOrder();
	}

	
	public T getElement() {
		return element;
	}

	public BinaryNode<T> getLeft() {
		return left;
	}

	public BinaryNode<T> getRight() {
		return right;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public void setLeft(BinaryNode<T> left) {
		this.left = left;
	}

	public void setRight(BinaryNode<T> right) {
		this.right = right;
	}
		

	
	
}