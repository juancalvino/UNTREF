package empresa;

public abstract class Empleado {

	private String nombre;
	private String apellido;
	
	/**
	 * Pre:
	 * @param nombre no puede ser NULL
	 * @param apellido no puede ser NULL
	 * Post: El empleado queda preparado para ser heredado.
	 */
	public Empleado(String nombre, String apellido) {
		this.nombre = verificarAusenciaDeNull(nombre);
		this.apellido = verificarAusenciaDeNull(apellido);
	}
	
	/**
	 * Post: devuelve un String con la informacion almacenada en la clase".
	 */
	@Override
	public String toString() {
		return nombre + " " + apellido +":";
	}
	
	/**
	 * Post:
	 * @param dato si es NULL este lanzara una excepcion.
	 * @return devuelve el dato ingresado.
	 */
	private String verificarAusenciaDeNull(String dato) {
		if(dato == null)
			throw new Error("El dato ingresado no puede ser NULL");
	
		return dato;
	}
}
