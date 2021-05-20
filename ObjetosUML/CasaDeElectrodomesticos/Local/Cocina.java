package Local;

public class Cocina extends Electrodomestico{

	private int hornallas;
	
	public Cocina(String nombre,int cantHornallas, double precio) {
		super(nombre, precio);
		this.hornallas = cantHornallas;
	}

	public int getHornallas() {
		return hornallas;
	}
	
	@Override
	public double getPrecio() {
		return super.getPrecio() + 200;
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + hornallas;
	}

}
