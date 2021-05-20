package pilas;

/**
 * Una Pila/Stack es una estructura dinámica de datos organizada de acuerdo al
 * principio LIFO (Last In - First Out).
 *
 * El último elemento en entrar es el primer elemento en salir.
 *
 * Sólo permite el acceso al elemento que denomina tope.
 * 
 */
public interface Pila<T> {

	/**
	 * @return indica si no tiene ningún elemento.
	 */
	boolean estaVacia();

	/**
	 * @post agrega el elemento 'nuevoElemento' en el tope.
	 * @param nuevoElemento
	 */
	void apilar(T nuevoElemento);

	/**
	 * @pre no está vacía.
	 * @post remueve el elemento en el tope y lo devuelve.
	 * @return elemento removido.
	 */
	T desapilar();

	/**
	 * @pre no está vacía.
	 * @post devuelve el elemento en el tope.
	 * @return elemento en el tope.
	 */
	T obtenerTope();

}