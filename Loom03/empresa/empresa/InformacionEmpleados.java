package empresa;

public class InformacionEmpleados {

	private Empleado[] empleado;
	private int empleadoIndice = 0;
	

	/**
	 * Pre:
	 * @param cantidadEmpleados es mayor o igual a 1
	 * Post:
	 * El registro de empleados queda preparado para agregar empleados y ver su informacion.
	 */
	public InformacionEmpleados(int cantidadEmpleados) {
		if(cantidadEmpleados < 1)
			throw new Error("La cantidad de empleados ingresados debe ser mayor a 1");
			
		this.empleado = new Empleado[cantidadEmpleados];
	}

	/**
	 * Pre:
	 * @param nuevo es distinto de NULL
	 * Post: agrega un nuevo Empleado al registro.
	 */
	public void addEmpleado(Empleado nuevo) {
	
		if(nuevo == null)
			throw new Error("No se puede ingresar el valor NULL");
			
		empleado[verificarIndice()] = nuevo;
		empleadoIndice++;
	}
	
	/**
	 * Post: devuelve un String con la informacion de los Empleados almacenados en la clase".
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
	
	/**
	 * Pre: 'empleadoIndice' debe ser menor a la longitud de 'empleado[]'
	 * @return devuelve el indice del empleado validado.
	 */
	private int verificarIndice() {
		if(empleadoIndice >= empleado.length)
			throw new Error ("No hay mas espacio para agregar empleados al sistema");
	
		return empleadoIndice;
	}
	
}
