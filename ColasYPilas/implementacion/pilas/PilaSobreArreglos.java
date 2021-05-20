package pilas;

/**
 * Implementación de Pila (Stack) basada en arreglos.
 * 
 */
public class PilaSobreArreglos<T> implements Pila<T> {

	private T[] elementos;
	private int cantidad;

	public PilaSobreArreglos(int capacidadInicial) {

		elementos = crearArreglo(capacidadInicial);
		cantidad = 0;
	}

	@SuppressWarnings("unchecked")
	private T[] crearArreglo(int capacidad) {

		return (T[]) new Object[capacidad];
	}

	@Override
	public boolean estaVacia() {

		return (cantidad == 0);
	}

	@Override
	public void apilar(T nuevoElemento) {

		if (cantidad == elementos.length) {

			ampliarCapacidad();
		}

		elementos[cantidad] = nuevoElemento;

		cantidad++;
	}

	private void ampliarCapacidad() {

		T[] elementosPrevios = elementos;

		elementos = crearArreglo(2 * elementosPrevios.length);

		for (int i = 0; i < elementosPrevios.length; i++) {
			elementos[i] = elementosPrevios[i];
		}
	}

	@Override
	public T desapilar() {

		T tope = obtenerTope();
		
		cantidad--;
		
		return tope;
	}

	@Override
	public T obtenerTope() {

		if (estaVacia()) {
			throw new NoExisteElElemento();
		}

		return elementos[cantidad - 1];
	}

}