package registroEmpleados;
import unidadContable.SalarioGerente;

public class Gerente extends PlantaPermanente{
	
	/**
	 * Pre:
	 * @param nombre, apellido  no puede ser NULL
	 * @param hijos, antiguedad deben ser mayor o igual a 0 
	 * Post: El empleado queda preparado para ser utilizado
	 */
	public Gerente(String nombre, String apellido, boolean tieneConyugue,int cantHijos) {
		super(nombre, apellido, tieneConyugue, cantHijos);
	}
	
	/**
	 * @return el sueldo de un Gerente
	 */
	@Override
	public double liquidarSueldo() {
		return new SalarioGerente(tieneConyugue, hijos, comienzoDeActividad ).liquidarSalario();
	}
	
	/**
	 * @return la informacion del Gerente
	 */
	@Override
	public String toString() {
		String informacion = super.toString();
		return informacion.replace("empleado/a a tiempo completo", "Gerente");
	}
}