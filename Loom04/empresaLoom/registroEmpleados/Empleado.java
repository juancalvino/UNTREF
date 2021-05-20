package registroEmpleados;

import java.text.DecimalFormat;
import verificadores.*;

public abstract class Empleado {

	private String nombre;
	private String apellido;
	protected boolean tieneConyugue;
	protected int hijos;
	
	
	/**
	 * Pre:
	 * @param nombre no puede ser NULL
	 * @param apellido no puede ser NULL
	 * Post: El empleado queda preparado para ser heredado.
	 */
	public Empleado(String nombre, String apellido, boolean tieneConyugue,int cantHijos ) {
		this.nombre = Verificador.ausenciaDeNull(nombre);
		this.apellido = Verificador.ausenciaDeNull(apellido);
		this.tieneConyugue = tieneConyugue;
		this.hijos = Verificador.negatividad(cantHijos);
	}
	
	
	/**
	 * @return el salario del empleado
	 */
	public abstract double liquidarSueldo();
	
	
	/**
	 * Post: devuelve un String con la informacion almacenada en la clase".
	 */
	@Override
	public String toString() {
		return nombre + " " + apellido +":\n"
			   +"  Sueldo: $" + new DecimalFormat("#,###.##").format(liquidarSueldo()) 
			   + "\n  ";
	}

	
	/**
	 * Post:
	 * @param tieneConyugue actualiza el valor de 'tieneConyugue'
	 */
	protected void setConyugue(boolean tieneConyugue) {
		this.tieneConyugue = tieneConyugue; 
	}
	
	
	/**
	 * Pre:
	 * @param cantHijos debe ser mayor o igual que 0
	 * Post:Actualiza el valor de 'hijos'
	 */
	protected void setHijos(int cantHijos) {
		this.hijos = Verificador.negatividad(cantHijos); 
	}
	
	
}
