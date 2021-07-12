package listas;

import java.util.NoSuchElementException;
import java.util.Stack;


public class IteradorLSE<T> {

	protected NodoLSE<T> actual;
	protected Stack<NodoLSE<T>> pila;

	public IteradorLSE(NodoLSE<T> miNodo) {
		this.actual = miNodo;
		pila = new Stack<NodoLSE<T>>();
	}

	
	/*
	 * Devuelve el siguiente elemento en la iteración.
	 */
	public T next() {
		try {
			NodoLSE<T> siguiente = actual.obtSigte();
			pila.push(actual);
			actual = siguiente;
		}
		catch(NoSuchElementException e) {
			e.getStackTrace();
		}
		
		return actual.obtDato();
	}

	
	/*
	 * Devuelve true si la iteración tiene más elementos.
	 * (En otras palabras, devuelve true si next() devuelve un elemento en lugar de lanzar una excepción).
	 */
	public boolean hasNext() {
		return actual.obtSigte() != null;
	}

	/*
	 * Devuelve el elemento anterior de la lista y mueve la posición del cursor hacia atrás.
	 * Este método puede llamarse repetidamente para recorrer la lista hacia atrás, o mezclarse con llamadas a next()
	 * para ir hacia adelante y hacia atrás.
	 *(Tenga en cuenta que la alternancia de llamadas a next y previous devolverá el mismo elemento repetidamente).
	 */
	public T previous() {
		NodoLSE<T> aux = null;
		try {
			aux = actual;
			actual = pila.pop();
		}
		catch(NoSuchElementException e) {
			e.getStackTrace();
		}
		return aux.obtDato();
	}
	
	/*
	 * Devuelve true si este iterador de lista tiene más elementos al recorrer la lista en sentido inverso. 
	 * (En otras palabras, devuelve true si previous() devolviera un elemento en lugar de lanzar una excepción).
	 */
	public boolean hasPrevious() {
		return !pila.isEmpty();
	}

}
