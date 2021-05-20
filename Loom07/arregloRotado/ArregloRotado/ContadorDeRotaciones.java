package ArregloRotado;

public class ContadorDeRotaciones {

	/*
	 * El sigiente contador se coloco con la finalidad de testear el rendimiendo de
	 * 'encontrarPosicionInicial' siendo irrelevante en la funcionalidad del codigo.
	 */
	public int contador = 0;

	/**
	 * @param arreglo
	 * @return la cantidad minima de rotaciones que hay que realizar para que quede
	 *         ordenado. Si el resultado es mayor que 0 los giros son hacia la
	 *         derecha. Si el resultado es menor que 0 los giros son hacia la
	 *         izquierda.
	 */
	public int devloverCantidadDeRotaciones(int[] arreglo) {
		int posicionDeInicio = encontrarPosicionInicial(0, arreglo.length - 1, arreglo);
		return devolverTrayectoMasCorto(posicionDeInicio, arreglo.length);
	}

	/**
	 * @param inicio
	 * @param fin
	 * @param arreglo debe estar estar ordenado previamente de forma circular
	 * @return la posicion donde se encuentra el valor minimo del arreglo ordenado
	 *         de forma circular.
	 */
	private int encontrarPosicionInicial(int inicio, int fin, int[] arreglo) {

		int medio = (inicio + fin) / 2;

		if (inicio == medio || fin == medio) {
			if (arreglo[inicio] > arreglo[fin])
				medio++;
			return medio;
		}

		if (arreglo[medio] < arreglo[fin]) {
			return encontrarPosicionInicial(inicio, medio, arreglo);
		}

		return encontrarPosicionInicial(++medio, fin, arreglo);

	}

	/**
	 * @param posicionMinima
	 * @param logitudDelArreglo
	 * @return
	 */
	private int devolverTrayectoMasCorto(int posicionMinima, int logitudDelArreglo) {

		int giroPositivo = logitudDelArreglo - posicionMinima;

		if (posicionMinima < giroPositivo) {
			return posicionMinima * -1;
		}
		return giroPositivo;

	}

}
