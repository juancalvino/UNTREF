package nodoPadreSumaDeSusHijos;


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
	  bt.add(10);
	  bt.add(5);
	  bt.add(15);
	  bt.add(2);
	  bt.add(8);
	  bt.add(12);
	  
	  
	  bt.printPreOrder();	   
	  bt.nodoPadreSumaDeSusHijos();
	  bt.printPreOrder();
	}
}
