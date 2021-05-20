package sumarMultiplosDe;


public class DemoBinaryTree {

	
	public static void main(String[] args) {
	    BinaryTree bt = new BinaryTree();


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
	  
	  System.out.println(bt.sumarNodosMultiplosDeSeis());

	}
	
}
