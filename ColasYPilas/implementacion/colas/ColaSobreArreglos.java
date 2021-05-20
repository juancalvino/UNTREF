package colas;

/**
 * Implementación de Cola (Queue) basada en arreglos.
 * 
 */
public class ColaSobreArreglos<T> implements Cola<T> {

    private T[] elementos;
    private int cantidad;
    private int posicionFrente;
    private int posicionFondo;

	public ColaSobreArreglos(int capacidadInicial) {
    	
    	elementos = crearArreglo(capacidadInicial);
    	cantidad = 0;
    	posicionFrente = 0;
    	posicionFondo = -1;
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
	public void acolar(T nuevoElemento) {

		if (cantidad == elementos.length) {

			ampliarCapacidad();
		}
		
		posicionFondo = incrementar(posicionFondo);
		elementos[posicionFondo] = nuevoElemento;
		cantidad++;
	}
	
	private void ampliarCapacidad() {

		T[] elementosNuevos = crearArreglo(2 * elementos.length);

        for( int i = 0; i < cantidad; i++) {

        	elementosNuevos[i] = elementos[posicionFrente];
        	posicionFrente = incrementar(posicionFrente);
        }
        
        elementos = elementosNuevos;
        posicionFrente = 0;
        posicionFondo = cantidad - 1;
	}
	
	private int incrementar(int posicion) {
		
		posicion++;
		
		return (posicion < elementos.length) ? posicion : 0;
	}
	
	@Override
	public T desacolar() {

		T frente = obtenerFrente();
		
		posicionFrente = incrementar(posicionFrente);
		cantidad--;
		
		return frente;
	}

	@Override
	public T obtenerFrente() {

		if (estaVacia()) {
			throw new NoExisteElElemento();
		}

		return elementos[posicionFrente];
	}
}