package Local;

public class Televisor extends Electrodomestico{
	
	private int pulgadas;
	private String resolucion;
	
	public Televisor(String nombre,int pulgadas, String resolucion, double precio) {
		super(nombre, precio);
		this.pulgadas = pulgadas;
		this.resolucion = resolucion;
	}

	public int getPulgadas() {
		return pulgadas;
	}

	public String getResolucion() {
		return resolucion;
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + pulgadas + " " + resolucion;
	}

}
