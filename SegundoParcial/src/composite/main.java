package composite;

import java.util.ArrayList;
import java.util.List;

public class main {
  
	public static void main(String[] args) {
	
		Producto tornillos = new ProductoBasico("tornillos", 100);
		Producto varillas = new ProductoBasico("varillas de acero", 50);

		Producto productoElaboradoB = new ProductoElaborado("ProductoElaboradoB",2,
												new ArrayList<Producto>(List.of(tornillos,varillas)));
	
		ProductoElaborado productoElaboradoA = new ProductoElaborado("ProductoElaboradoA", 10);
		productoElaboradoA.addProducto(productoElaboradoB);
		
		ProductoBasico rulemanes = new ProductoBasico("rulemanes", 2);
		
		productoElaboradoA.addProducto(rulemanes);
		
		System.out.println(productoElaboradoA.enlistarProducto());
	}
}
