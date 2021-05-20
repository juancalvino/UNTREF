package AlCuadrado_Revertido_SonPares;

public class BInaryTreeDemo {

	public static void main(String[] args) {
		BinaryTree t7 = new BinaryTree(0);
		BinaryTree t8 = new BinaryTree(2);
		BinaryTree t3 = new BinaryTree(1,t7,t8);
		BinaryTree t9 = new BinaryTree(4);
		BinaryTree t10 = new BinaryTree(6);
		BinaryTree t4 = new BinaryTree(5,t9,t10);
		BinaryTree t13 = new BinaryTree(12);
		BinaryTree t14 = new BinaryTree(14);
		BinaryTree t6 = new BinaryTree(13,t13,t14);		
		BinaryTree t11 = new BinaryTree(8);
		BinaryTree t12 = new BinaryTree(10);
		BinaryTree t5 = new BinaryTree(9,t11,t12);		
		BinaryTree t2 = new BinaryTree(11,t5,t6);
		BinaryTree t1 = new BinaryTree(3,t3,t4);
		BinaryTree t0 = new BinaryTree(7,t1,t2);
		
//		t0.printInOrder();
//		System.out.println("----------------");
//		t0.printPostOrder();
//		System.out.println("----------------");
//		t0.printPreOrder();
		System.out.println("La cantidad de nodos son pares? " + t0.nodosPares());
		
		t0.elevarAlCuadrado();
		System.out.println("Elementos al cuadrado");
		t0.printInOrder();
		
		t0.revertir();
		System.out.println("Arbol revertido");
		t0.printInOrder();
	}
}
