import java.util.Comparator;
import java.util.PriorityQueue;

public class ColaDeSupermercado {

	private PriorityQueue<Cliente> colaDeSuper = new PriorityQueue<Cliente>(new OrdenadorPrioridadClientes());

	public void agregarACola(TipoCliente cliente) {
		colaDeSuper.add(new Cliente(cliente));
	}
	
	public PriorityQueue<Cliente> getCola(){
		return colaDeSuper;
	}
	
	public void verCola(){
		System.out.println(colaDeSuper.toString());
		 
	}

	public static void main(String[] args) {
		ColaDeSupermercado colaSuper = new ColaDeSupermercado();
		colaSuper.agregarACola(TipoCliente.COMUN);
		colaSuper.agregarACola(TipoCliente.COMUN);
		colaSuper.agregarACola(TipoCliente.ANCIANO);		
		colaSuper.agregarACola(TipoCliente.EMBARAZADA);		
		colaSuper.agregarACola(TipoCliente.COMUN);
		colaSuper.agregarACola(TipoCliente.COMUN);
		colaSuper.agregarACola(TipoCliente.CON_BEBE);		
		colaSuper.agregarACola(TipoCliente.EMBARAZADA);		
		colaSuper.agregarACola(TipoCliente.COMUN);
		System.out.println(colaSuper.getCola().peek());
		colaSuper.verCola();
	}

}
