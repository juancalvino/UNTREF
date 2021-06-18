package composite;

import java.util.ArrayList;
import java.util.List;

public class ProductoElaborado extends Producto {

	private List<Producto> listaDeComponentes;

	public ProductoElaborado(String nombre, int stock) {
		super(nombre, stock);
		this.listaDeComponentes = new ArrayList<Producto>();
	}

	public ProductoElaborado(String nombre, int stock, List<Producto> listaDeComponentes) {
		super(nombre, stock);
		this.listaDeComponentes = listaDeComponentes;
	}
	
	public void addProducto(Producto producto) {
		listaDeComponentes.add(producto);
	}
	
	public String enlistarProducto() {
		return super.enlistarProducto() + listaDeComponentes;
	}
	
	@Override
	public String toString() {
		return super.toString() + listaDeComponentes;
	}
	
}
