package ArbolDeBusqueda;


import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class InOrderIterator<T> implements Iterator<T> {
	private Stack<BinaryNode<T>> stack = new Stack<BinaryNode<T>>();

	InOrderIterator(BinaryNode<T> root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public T next() {
		if (!hasNext())
			throw new NoSuchElementException("End of tree");

		BinaryNode<T> node = stack.pop();
		T result = node.element;
		if (node.right != null) {
			node = node.right;

			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		return result;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}
