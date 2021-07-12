package listas;


public class ListaSE<T> {

	protected NodoLSE<T> cabeza;
	private int tamanio;
	
	public ListaSE() {
		this.cabeza = new NodoLSE<T>(null);
		cabeza.asigSigte(null);;
		tamanio = 0;
	}

	
	
	
	public boolean isEmpty() {
		return (tamanio == 0)?true:false;
	}

	

	
	public IteradorLSE<T> iterator() {
		return new IteradorLSE<T>(cabeza);
	}

	
	/*
	 * Inserta siempre en la cabeza
	 */
	public boolean add(T e) {
		NodoLSE <T>aux = new NodoLSE<T>(e);
		aux.enlazarLuegoDe(cabeza);
		tamanio++;
		return true;
	}


	
	
	

	
}
