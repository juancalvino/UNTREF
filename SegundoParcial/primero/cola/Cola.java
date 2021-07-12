package cola;

/**
 * Una Cola/Queue es una estructura dinámica de datos organizada de acuerdo al
 * principio FIFO (First In - First Out).
 *
 * El primer elemento en entrar es el primer elemento en salir.
 *
 * Sólo permite el acceso al elemento que denomina frente.
 *
 */
public interface Cola<T> {

	/**
	 * @return indica si no tiene ningún elemento.
	 */
    boolean estaVacia();

    /**
     * @post agrega 'nuevoElemento' en el fondo.
     * @param nuevoElemento
     */
    void acolar(T nuevoElemento);

    /**
     * @pre no está vacía.
     * @post remueve el elemento en el tope y lo devuelve.
     * @return elemento removido.
     */
    T desacolar();

    /**
	 * @pre no está vacía.
	 * @post devuelve el elemento en el frente.
	 * @return elemento en el frente.
     */
    T obtenerFrente();



}
