package empresa;

public class PermanenteTiempoParcial extends SinCategoriaEspecial {
	
	/**
	 * Pre:
	 * @param nombre no puede ser NULL
	 * @param apellido no puede ser NULL
	 * Post: El empleado queda preparado para ser utilizado
	 */
	public PermanenteTiempoParcial(String nombre, String apellido) {
		super(nombre,apellido);
	}

	/**
	 * Post: devuelve un string con la informacion de las clases heredadas y reemplaza ". Planta permanente" por  a tiempo parcial. Planta permanente.
	 */
	@Override
	public String toString() {
		String informacion = super.toString();
		return informacion.replace(". Planta permanente", " a tiempo parcial. Planta permanente");
	}
}
