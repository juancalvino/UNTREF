package registroEmpleados;

import unidadContable.SalarioParcial;
import verificadores.Verificador;

public class PlantaTemporariaTiempoParcial extends PlantaTemporaria {
	
	int horasTrabajadas;
	
	/**
	 * Pre:
	 * @param nombre, apellido  no puede ser NULL
	 * @param hijos y horasTrabajadas deben ser mayor o igual a 0 
	 * Post: 
	 * Se registra el momento del ingreso como inicio de la actividad del empleado.
	 * El empleado queda preparado para ser utilizado
	 */
	public PlantaTemporariaTiempoParcial(String nombre, String apellido, boolean tieneConyugue,int cantHijos, int horasTrabajadas) {
		super(nombre, apellido, tieneConyugue, cantHijos);
		this.horasTrabajadas = Verificador.negatividad(horasTrabajadas);
	}
	
	
	/**
	 * @return el sueldo de un Empleado de Planta Temporal a Tiempo Parcial
	 */
	@Override
	public double liquidarSueldo() {
		return new SalarioParcial(tieneConyugue, hijos, horasTrabajadas).liquidarSalario();
	}
	
	
	/**
	 * @return la informacion del Empleado de Planta Temporal a Tiempo Parcial
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
