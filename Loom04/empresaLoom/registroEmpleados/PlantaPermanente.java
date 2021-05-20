package registroEmpleados;

import java.util.Date;

import unidadContable.SalarioPermanente;

public class PlantaPermanente extends Empleado{
	
	 protected Date comienzoDeActividad;
	 
	/**
	 * Pre:
	 * @param nombre, apellido  no puede ser NULL
	 * @param hijos debe ser mayor o igual a 0 
	 * Post: 
	 * Se registra el momento del ingreso como inicio de la actividad del empleado.
	 * El empleado queda preparado para ser utilizado
	 */
	public PlantaPermanente (String nombre, String apellido, boolean tieneConyugue,int cantHijos) {
		super(nombre, apellido, tieneConyugue, cantHijos);
		this.comienzoDeActividad = new Date(System.currentTimeMillis());
	}
	
	
	/**
	 * @return el sueldo de un Empleado de Planta Permanente
	 */
	@Override
	public double liquidarSueldo() {
		return new SalarioPermanente(tieneConyugue, hijos, comienzoDeActividad).liquidarSalario();
	}
	
	
	/**
	 * @return la informacion del Empleado de Planta Permanente
	 */
	@Override
	public String toString() {
		 return super.toString() +"Planta permanente, empleado/a a tiempo completo.";
	}

}
