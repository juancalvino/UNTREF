package conjuntosDiccionariosYColasDePrioridad;

import java.util.Objects;

public class Empleado {

	private String nombre;
	private int edad;


	public Empleado(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}
	
	public int getEdad() {
		return edad;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Empleado)) {
			return false;
		}
		Empleado objEmpleado = (Empleado) obj;
		return Objects.equals(this.nombre, objEmpleado.nombre);

	}
	
	@Override
	public String toString() {
		return getNombre();
	}


}
