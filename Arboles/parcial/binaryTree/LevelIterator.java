package binaryTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class LevelIterator<T> implements Iterator<T> {
	
	private Queue <BinaryNode<T>> cola = new LinkedList<BinaryNode<T>>();
	private BinaryNode<T> actual;
	
	/*
	 * Constructor recibe el nodo inicial para comenzar la iteración
	 */
	public LevelIterator (BinaryNode<T> raiz) {
		this.actual = raiz;	
		cola.add(actual);
	}
	
	/*
	 * Devuelve true si la iteración tiene más elementos.
	 * (En otras palabras, devuelve true si next() devuelve un elemento en lugar de lanzar una excepción).
	 */
	@Override
	public boolean hasNext() {
        return !cola.isEmpty();
    }
	
	/*
	 * Devuelve el siguiente elemento en la iteración.
	 */
	@Override
	public T next() {
		if(hasNext()){
	        actual = cola.poll();
	        if (actual.getLeft() != null) {
	            cola.add(actual.getLeft());
	        }
	        if (actual.getRight() != null) {
	            cola.add(actual.getRight());
	        }
		}
		else {
	       throw new NoSuchElementException("No cuenta con elementos");
	    }
	    return actual.getElement();
	}
}
	
	
	
	
	
	
