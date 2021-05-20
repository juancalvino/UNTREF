package patronComposite;

import java.util.ArrayList;
import java.util.List;

public class Combo extends Producto {

	private List<Producto> productos = new ArrayList<Producto>();

	public Combo(String nombre) {
		super(nombre, 0);
	}

	public void addProducto(Producto p) {
		productos.add(p);

	}

	@Override
	public double getPrecio() {
		double precio = 0;

		for (Producto producto : productos) {
			precio += producto.getPrecio();
		}

		return precio * 0.9;
	}

}
