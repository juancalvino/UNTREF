package registroEmpleados;

import unidadContable.SalarioBasico;

public class PlantaTemporaria extends Empleado {

	/**
	 * Pre:
	 * @param nombre no puede ser NULL
	 * @param apellido no puede ser NULL
	 * Post: El empleado queda preparado para ser utilizado
	 */
		public PlantaTemporaria(String nombre, String apellido, boolean tieneConyugue,int cantHijos) {
			super(nombre, apellido, tieneConyugue, cantHijos);
		}
	

	/**
	 * @return el sueldo de un Empleado de Planta Temporal a Tiempo Completo
	 */
	@Override
	public double liquidarSueldo() {
		return new SalarioBasico(tieneConyugue, hijos).liquidarSalario();
	}
	
	
	/**
	 * @return la informacion del Empleado de Planta Temporal a Tiempo Completo
	 */
	@Override
	public String toString() {
		return super.toString() + "Planta transitoria, empleado/a a tiempo completo.";
	}
	
}

