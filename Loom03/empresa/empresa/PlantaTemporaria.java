package empresa;

abstract class PlantaTemporaria extends Empleado {

	/**
	 * Pre:
	 * @param nombre no puede ser NULL
	 * @param apellido no puede ser NULL
	 * Post: La clase queda preparada para ser heredada.
	 */
	protected PlantaTemporaria(String nombre, String apellido) {
		super(nombre, apellido);
	}	
}
