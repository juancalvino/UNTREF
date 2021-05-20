package empresa;

public class Gerente extends PlantaPermanente{
	
	/**
	 * Pre:
	 * @param nombre no puede ser NULL
	 * @param apellido no puede ser NULL
	 * Post: El empleado queda preparado para ser utilizado
	 */
	public Gerente(String nombre, String apellido) {
		super(nombre,apellido);
	}

	/**
	 * Post: devuelve un string con la informacion de las clases heredadas y se le adiciona "Gerente. Planta permanente".
	 */
	@Override
	public String toString() {
		return super.toString() + "Gerente. Planta permanente";
	}
}
