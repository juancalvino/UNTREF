package sumarMultiplosDe;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	Node root;

	public void add(int value) {
		root = addRecursive(root, value);
	}

	private Node addRecursive(Node current, int value) {
		if (current == null) {
			return new Node(value);
		}

		if (value < current.value) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.value) {
			current.right = addRecursive(current.right, value);
		} else {
			// value already exists
			return current;
		}

		return current;
	}

	public void printPreOrder() {
		if (root != null)
			root.printPreOrder();
		System.out.println("");
	}

	public void printInOrder() {
		if (root != null)
			root.printInOrder();
		System.out.println("");

	}

	public void printPostOrder() {
		if (root != null)
			root.printPostOrder();
		System.out.println("");
	}

	public boolean containsNode(int value) {
		return containsNodeRecursive(root, value);
	}

	private boolean containsNodeRecursive(Node current, int value) {
		if (current == null) {
			return false;
		}
		if (value == current.value) {
			return true;
		}
		return value < current.value ? containsNodeRecursive(current.left, value)
				: containsNodeRecursive(current.right, value);
	}

	public void delete(int value) {
		root = deleteRecursive(root, value);
	}

	private Node deleteRecursive(Node current, int value) {
		if (current == null) {
			return null;
		}

		if (value == current.value) {
			// Node to delete found

			// Node has no children
			if (current.left == null && current.right == null) {
				return null;
			}

			// node has exactrly one child
			if (current.right == null) {
				return current.left;
			}

			if (current.left == null) {
				return current.right;
			}

			// node has two children
			int smallestValue = findSmallestValue(current.right);
			current.value = smallestValue;
			current.right = deleteRecursive(current.right, smallestValue);
			return current;
		}

		if (value < current.value) {
			current.left = deleteRecursive(current.left, value);
			return current;
		}
		current.right = deleteRecursive(current.right, value);
		return current;
	}

	private int findSmallestValue(Node root) {
		return root.left == null ? root.value : findSmallestValue(root.left);
	}

//	private int findBiggestValue(Node root) {
//		return root.right == null ? root.value : findBiggestValue(root.right);
//	}
	
	public void traverseLevelOrder() {
	    if (root == null) {
	        return;
	    }

	    Queue<Node> nodes = new LinkedList<>();
	    nodes.add(root);

	    while (!nodes.isEmpty()) {

	        Node node = nodes.remove();

	        System.out.print(" " + node.value);

	        if (node.left != null) {
	            nodes.add(node.left);
	        }

	        if (node.right != null) {
	            nodes.add(node.right);
	        }
	    }
	}
	
	public int sumarNodosMultiplosDeSeis() {
		return sumarNodosNodosMultiplosDeSeis(root);
	}

	private int sumarNodosNodosMultiplosDeSeis(Node root) {
		
		if(root == null) {
			return 0;
		}
		
		int suma = root.value%6 == 0
				   ? root.value
				   : 0;
		
		return suma +=
				(sumarNodosNodosMultiplosDeSeis(root.left)
				+ sumarNodosNodosMultiplosDeSeis(root.right));			
	} 
	
}
