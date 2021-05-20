package oficina;

public class Empleado {
	
	private String sector;
	private String nombre;
	private int sueldo;
	
	public Empleado(String sector, String nombre, int sueldo) {
		this.sector = sector;
		this.nombre = nombre;
		this.sueldo = sueldo;
	}
	
	public String getSector() {
		return sector;
	}

	public String getNombre() {
		return nombre;
	}

	public double getSueldo() {
		return sueldo;
	}
	
	@Override
	public String toString() {
		return nombre + ", " + sueldo ;
	}

	
}
