package arbolOrdenado;


public class DemoBinaryTree {

	
	public static void main(String[] args) {
	    BinaryTree bt = new BinaryTree();

//	    bt.add(7);
//	    bt.add(3);
//	    bt.add(1);
//	    bt.add(5);
//	    bt.add(4);
//	    bt.add(-3);
//	    bt.add(2);
//	    

//	    bt.printPreOrder();
//	    bt.printInOrder();
//	    bt.printPostOrder();
//	    System.out.println(bt.containsNode(5));
//	    System.out.println(bt.containsNode(-1));
//	    System.out.println(bt.containsNode(-6));
	    
//	    bt.delete(3);
//	    bt.printInOrder();
//	    
//	    bt.traverseLevelOrder();

	  bt.add(20); 
	  bt.add(10); 
	  bt.add(5); 
	  bt.add(2); 
	  bt.add(6); 
	  bt.add(12); 
	  bt.add(14); 
	  bt.add(40); 
	  bt.add(30); 
	  bt.add(45); 
	  bt.add(25); 
	  bt.add(21); 

	  bt.printPreOrder();
	   System.out.println(bt.altura()); 
	}
}
