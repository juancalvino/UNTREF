package  verificadores;

public class Verificador {

	/**
	 * @param valor si es menor que 0 este lanzara un IllegalArgumentException.
	 * @return devuelve el valor ingresado.
	 */
	public static double negatividad(double valor) {
		if(valor < 0)
			throw new IllegalArgumentException("El valor ingresado debe ser mayor que 0");
		
		return valor;
	}

	
	/**
	 * @param valor si es menor que 0 este lanzara un IllegalArgumentException.
	 * @return devuelve el valor ingresado.
	 */
	public static int negatividad(int valor) {
		if(valor < 0)
			throw new IllegalArgumentException("El valor ingresado debe ser mayor que 0");
		
		return valor;
	}
	
	
	/**
	 * @param dato si es NULL este lanzara NullPointerException.
	 * @return devuelve el dato ingresado.
	 */
	public static String ausenciaDeNull(String dato) {
		if(dato == null)
			throw new NullPointerException("El dato ingresado no puede ser NULL");
	
		return dato;
	}
	
	

	/**
	 * @param indice debe menor que la longitud de 'Object'.
	 * @return 'indice'.
	 */
	public static int indiceDeArray(int indice, Object[] object ) {
		if(indice >= object.length)
			throw new IndexOutOfBoundsException("No hay mas espacio");
	
		return indice;
	}
	
}
