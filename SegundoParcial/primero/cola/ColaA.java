package cola;

import java.util.Stack;

public class ColaA<T> implements Cola<T>{

	Stack<T> pilaA;
	Stack<T> pilaB;

	public ColaA() {
		this.pilaA = new Stack<T>();
		this.pilaB = new Stack<T>();
	}
	
	/**
	 * Costo O(1).
	 */
	@Override
	public boolean estaVacia() {
		return pilaA.isEmpty() && pilaB.isEmpty();
	}
	

	/**
	 * Costo O(1).
	 */
	@Override
	public void acolar(T nuevoElemento) {
		pilaA.push(nuevoElemento);
	}
	
	/**
	 * Costo en el peor caso si la pilaB no esta vacia O(n) si existen elementos en la pilaB es O(1)
	 * Siendo el costo O(n)
	 */
	@Override
	public T desacolar() {
		if(pilaB.isEmpty())
			obtenerFrente();
		return pilaB.pop();
	}
	
	/**
	 * Costo en el peor caso si la pilaB no esta vacia O(n) si existen elementos en la pilaB es O(1)
	 * Siendo el costo O(n)
	 */
	@Override
	public T obtenerFrente() {
		if(pilaB.isEmpty()) {
			while(!pilaA.isEmpty()) {
				pilaB.push(pilaA.pop());
			}
		}
		return pilaB.peek();
	}




}
