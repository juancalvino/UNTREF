package Binario;


public class BinaryTreeDemo {

	public static void main(String[] args) {
		BinaryTree t1 = new BinaryTree(1);
		BinaryTree t3 = new BinaryTree(3);
		BinaryTree t5 = new BinaryTree(5);
		BinaryTree t7 = new BinaryTree(7);
		BinaryTree t2 = new BinaryTree(2, t1, t3);
		BinaryTree t6 = new BinaryTree(6, t5, t7);
		BinaryTree t4 = new BinaryTree(4, t2, t6);

		// t4.elevarAlCuadrado();

		System.out.println("t4 should be perfect 1-7; t2 empty");
		System.out.println("----------------");
		System.out.println("t4");
		t4.printInOrder();
		System.out.println("----------------");
		System.out.println("t2");
		t2.printInOrder();
		System.out.println("----------------");
		System.out.println("t4 size: " + t4.size());
		System.out.println("t4 height: " + t4.height());

		t4.printInOrder();

		t4.printPreOrder();
		System.out.println();
		t4.printPreOrder();
	}

}
