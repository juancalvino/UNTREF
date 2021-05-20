package deportistas;

public class Deportista {
	private String nombre;
	private int anio;
	private String premio;

	public Deportista(String nombre, int anio, String premio) {
		 this.nombre = nombre;
		 this.anio = anio;
		 this.premio = premio;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public int getAnio() {
		return anio;
	}

	public String getPremio() {
		return premio;
	}
	
	
	@Override
	public String toString() {
		return "(“"+ nombre +"“, “" + premio + "“)";
	}
}
