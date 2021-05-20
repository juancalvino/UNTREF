package EncontrarValorMinimoNoOrdenado;

public class BInaryTreeDemo {

	public static void main(String[] args) {
		BinaryTree t9 = new BinaryTree(2); 
		BinaryTree t8 = new BinaryTree(12,t9,null); 
		BinaryTree t7 = new BinaryTree(1); 
		BinaryTree t4 = new BinaryTree(7,t7,t8); 
		BinaryTree t3 = new BinaryTree(-9); 
		BinaryTree t1 = new BinaryTree(5,t3,t4);
		BinaryTree t6 = new BinaryTree(3); 
		BinaryTree t5 = new BinaryTree(11,t6,null); 
		BinaryTree t2 = new BinaryTree(4,null,t5); 		
		BinaryTree t0 = new BinaryTree(8,t1,t2);
		
//		t0.printInOrder();
//		System.out.println("----------------");
//		t0.printPostOrder();
//		System.out.println("----------------");
//		t0.printPreOrder();

		System.out.println("Resultado debe ser 1");
		System.out.println(t0.valorMinimo());
	}
}
