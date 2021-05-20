package SonElMismoArbol;

@SuppressWarnings("hiding")
public class BinaryNode {
	private Integer element;
	private BinaryNode left;
	private BinaryNode right;

	public BinaryNode(Integer element, BinaryNode left, BinaryNode right) {
		this.element = element;
		this.left = left;
		this.right = right;
	}

	public BinaryNode(Integer x) {
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
	
	public void elevaralCuadrado() {
		element =  element * element;
		if (left != null)
			left.elevaralCuadrado();
		if (right != null)
			right.elevaralCuadrado();
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

	public BinaryNode duplicate() {
		BinaryNode root = new BinaryNode(element, null, null);

		if (left != null)
			root.left = left.duplicate();
		if (right != null)
			root.right = right.duplicate();
		return root;
	}

	public Integer value() {
		return element;
	}

	public BinaryNode getLeft() {
		return left;
	}

	public BinaryNode getRight() {
		return right;
	}

	public void setElement(Integer element) {
		this.element = element;
	}

	public void setLeft(BinaryNode left) {
		this.left = left;
	}

	public void setRight(BinaryNode right) {
		this.right = right;
	}

	public boolean nodosPares() {
		int cantidad = 1 + contar(this.left)+contar(this.right);
		return cantidad % 2 == 0;
	}

	private int contar(BinaryNode actual) {
		return actual == null ? 0 : 1+ contar(actual.left)+contar(actual.right);
		
	}
	public void revertir() {
		
		revertir(this);
	}
	public void revertir(BinaryNode nodo) {
		BinaryNode aux;
		if (nodo == null) return;
		//if (nodo.left != null || nodo.right != null){
			revertir(nodo.left);
			revertir(nodo.right);
			
			aux = nodo.left;
			nodo.left = nodo.right;
			nodo.right = aux;
			
			
		//}
		
	}
	
	
}