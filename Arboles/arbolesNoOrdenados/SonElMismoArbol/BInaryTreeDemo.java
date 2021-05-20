package SonElMismoArbol;

public class BInaryTreeDemo {

	public static void main(String[] args) {
		BinaryTree t9 = new BinaryTree(2); 
		BinaryTree t8 = new BinaryTree(12,t9,null); 
		BinaryTree t7 = new BinaryTree(1); 
		BinaryTree t4 = new BinaryTree(7,t7,t8); 
		BinaryTree t3 = new BinaryTree(9); 
		BinaryTree t1 = new BinaryTree(5,t3,t4);
		BinaryTree t6 = new BinaryTree(3); 
		BinaryTree t5 = new BinaryTree(11,t6,null); 
		BinaryTree t2 = new BinaryTree(4,null,t5); 		
		BinaryTree t0 = new BinaryTree(8,t1,t2);
		
		BinaryTree tS9 = new BinaryTree(2); 
		BinaryTree tS8 = new BinaryTree(12,tS9,null); 
		BinaryTree tS7 = new BinaryTree(1); 
		BinaryTree tS4 = new BinaryTree(7,tS7,tS8); 
		BinaryTree tS3 = new BinaryTree(9); 
		BinaryTree tS1 = new BinaryTree(5,tS3,tS4);
		BinaryTree tS6 = new BinaryTree(7); 
		BinaryTree tS5 = new BinaryTree(11,tS6,null); 
		BinaryTree tS2 = new BinaryTree(4,null,tS5); 		
		BinaryTree tS0 = new BinaryTree(8,tS1,tS2);

//		t0.printInOrder();
//		System.out.println("----------------");
//		t0.printPostOrder();
//		System.out.println("----------------");
//		t0.printPreOrder();

		System.out.println(t0.equalsTree(tS0));
	}
}
