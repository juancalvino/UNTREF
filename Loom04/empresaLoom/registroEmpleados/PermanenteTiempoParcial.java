package registroEmpleados;

import unidadContable.SalarioParcialPermanente;
import verificadores.*;

public class PermanenteTiempoParcial extends PlantaPermanente{
	
	private int horasTrabajadas;
	
	/**
	 * Pre:
	 * @param nombre, apellido  no puede ser NULL
	 * @param hijos, horasTrabajadas deben ser mayor o igual a 0 
	 * Post: 
	 * Se regista el momento del ingreso como el inicio de la actividad.
	 * El empleado queda preparado para ser utilizado
	 */
	public PermanenteTiempoParcial(String nombre, String apellido,
									boolean tieneConyugue,int hijos, int horasTrabajadas) {
		
		super(nombre, apellido, tieneConyugue, hijos);
		this.horasTrabajadas = Verificador.negatividad(horasTrabajadas);
	}

	
	/**
	 * @return el sueldo de un Empleado de Planta Permanente a Tiempo Parcial
	 */
	@Override
	public double liquidarSueldo() {
		return new SalarioParcialPermanente(tieneConyugue,hijos,comienzoDeActividad,horasTrabajadas).liquidarSalario();
	}
	
	
	/**
	 * @return la informacion del Empleado de Planta Permanente a Tiempo Parcial
	 */
	@Override
	public String toString() {
		String informacion = super.toString() + "\n  Horas trabajadas: " + getHorasTrabajadas();
		return informacion.replace("tiempo completo", "tiempo parcial");
	}
	
	
	/**
	 * @param horasTrabajadas debe ser mayor o igual que 0
	 * Post: modifica el valor de las 'horasTrabajadas'
	 */
	protected void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = Verificador.negatividad(horasTrabajadas);
	}

	
	/**
	 * @return cantidad de horas trabajadas
	 */
	private int  getHorasTrabajadas() {
		return horasTrabajadas;
	}
	

}
