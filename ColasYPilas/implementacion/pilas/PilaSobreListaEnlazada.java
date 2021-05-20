package pilas;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Implementación de Pila (Stack) basada en una ListaEnlazada.
 * 
 */
public class PilaSobreListaEnlazada<T> implements Pila<T> {

	private LinkedList<T> elementos;

	public PilaSobreListaEnlazada() {

		elementos = new LinkedList<T>();
	}

	@Override
	public boolean estaVacia() {

		return elementos.isEmpty();
	}

	@Override
	public void apilar(T nuevoElemento) {

		elementos.addFirst(nuevoElemento);
	}

	@Override
	public T desapilar() {

		try {

			return elementos.removeFirst();

		} catch (NoSuchElementException e) {

			throw new NoExisteElElemento();
		}
	}

	@Override
	public T obtenerTope() {

		try {

			return elementos.getFirst();

		} catch (NoSuchElementException e) {

			throw new NoExisteElElemento();
		}
	}
}