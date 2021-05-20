package Local;

public abstract class Electrodomestico {

	private String marca;
	private double precio;
	private boolean funciona;
	
	public Electrodomestico(String marca, double precio) {
		this.marca = marca;
		this.precio = precio;
		this.funciona = true;
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isFunciona() {
		return funciona;
	}

	public void setFunciona(boolean funciona) {
		this.funciona = funciona;
	}

	public String getNombre() {
		return marca;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " " + this.marca;
	}
	
}
