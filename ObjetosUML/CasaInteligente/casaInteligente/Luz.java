package casaInteligente;

public class Luz extends ObjetoInteligente {

	private int intensidad;
	
	public Luz(String nombre, int intensidad) {
		super(nombre);
		this.intensidad = intensidad;
	}
	
	public int getIntensidad() {
		return intensidad;
	}
	
}
