package empresa;

/*
 * Aclaracion: Segun lo que entendi del ejercicio esta clase existe ya que un empleado de planta permanente puede ser un 'SinCategoriaEspecial'.
 * Y estos a su vez PUEDEN (no deben) ser a tiempo completo o a tiempo parcial.
 */

public class SinCategoriaEspecial extends PlantaPermanente {

	/**
	 * Pre:
	 * @param nombre no puede ser NULL
	 * @param apellido no puede ser NULL
	 * Post: El empleado queda preparado para ser utilizado
	 */
	public SinCategoriaEspecial(String nombre, String apellido) {
		super(nombre, apellido);
	}
	
	/**
	 * Post: devuelve un string con la informacion de las clases heredadas y se le adiciona "empleado/a. Planta permanente".
	 */
	@Override
	public String toString() {
		return super.toString()+ "empleado/a. Planta permanente" ;
	}
}
