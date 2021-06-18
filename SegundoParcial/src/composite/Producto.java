package composite;

public  abstract class Producto {

	private String nombre;
	private int stock;


	public Producto(String nombre, int stock) {
		this.nombre = nombre;
		this.stock = stock;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public int getStock() {
		return stock;
	}
	
	public String enlistarProducto() {
		return "\n  " + getNombre() + " cantidad " + getStock() ;
	}
	
	@Override
	public String toString() {
		return "\n  " + getNombre() + " X " + getStock() ;
	}
}
