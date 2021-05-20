package empresa;

public class TransitorioTiempoCompleto extends PlantaTemporaria {

	/**
	 * Pre:
	 * @param nombre no puede ser NULL
	 * @param apellido no puede ser NULL
	 * Post: El empleado queda preparado para ser utilizado
	 */
	public TransitorioTiempoCompleto(String nombre, String apellido) {
		super(nombre, apellido);
	}
	
	/**
	 * Post: devuelve un string con la informacion de las clases heredadas y se le adiciona "empleado/a a tiempo completo. Planta transitoria".
	 */
	@Override
	public String toString() {
		return super.toString() + "empleado/a a tiempo completo. Planta transitoria";
	}
}
