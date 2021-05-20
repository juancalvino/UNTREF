package registroEmpleados;

import verificadores.Verificador;

public class InformacionEmpleados {

	private Empleado[] empleado;
	private int empleadoIndice = 0;
	
	
	/**
	 * Pre:
	 * @param cantidadEmpleados es mayor o igual a 1
	 * Post:
	 * El registro de empleados queda preparado para agregar empleados y ver su informacion.
	 */
	protected InformacionEmpleados(int cantidadEmpleados) {
		if(cantidadEmpleados < 1)
			throw new IllegalArgumentException("La cantidad de empleados ingresados debe ser mayor a 1");
			
		this.empleado = new Empleado[cantidadEmpleados];
	}

	
	/**
	 * Pre:
	 * @param nuevo es distinto de NULL
	 * Post: agrega un nuevo Empleado al registro.
	 */
	protected void addEmpleado(Empleado nuevo) {
	
		if(nuevo == null)
			throw new NullPointerException("No se puede ingresar el valor NULL");
			
		empleado[Verificador.indiceDeArray(empleadoIndice, empleado)] = nuevo;
		empleadoIndice++;
	}
	
	
	/**
	 * Post: devuelve un String con la informacion de los Empleados almacenados
	 */
	@Override
	public String toString() {
		String informacion = "";
			
		for(int i=0; i<empleadoIndice; i++) {
			if(empleado[i]!= null)
				informacion += empleado[i].toString() +"\n";
		}
		
		if(informacion == "")
			informacion = "No hay informacion disponible";
		
		return informacion;
	}

	
}
