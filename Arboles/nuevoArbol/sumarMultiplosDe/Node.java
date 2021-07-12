package sumarMultiplosDe;

public class Node {
	int value;
	Node left;
	Node right;

	Node(int value) {
		this.value = value;
		right = null;
		left = null;
	}

	
	public void printPreOrder() {
		System.out.print(" " + value + " ");
		if (left != null)
			left.printPreOrder();
		if (right != null)
			right.printPreOrder();
	}

	public void printInOrder() {
		if (left != null)
			left.printInOrder();
		System.out.print(" " + value + " ");
		if (right != null)
			right.printInOrder();
	}

	public void printPostOrder() {
		if (left != null)
			left.printPostOrder();
		if (right != null)
			right.printPostOrder();
		System.out.print(" " + value + " ");
	}

}
