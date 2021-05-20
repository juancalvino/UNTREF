package ArbolDeBusqueda;

class BinaryNode<T> {
	T element;
	BinaryNode<T> left;
	BinaryNode<T> right;

	BinaryNode(T element) {
		this.element = element;
		this.left = this.right = null;
	}
}
