package Local;

import java.util.ArrayList;
import java.util.List;


public class Tienda {
	
	private List<Electrodomestico> catalogo;
	
	public Tienda() {
		catalogo = new ArrayList<Electrodomestico>();
	}
	
	public List<Electrodomestico> getCatalogo(){
		return catalogo;
	}
	
	public void agregar(Electrodomestico objeto) {
		catalogo.add(objeto);
	}
	
	public void enlistarCatalogo() {
		System.out.println(catalogo);
	}
	
	public boolean verificacion(Electrodomestico objeto) {
		return objeto.isFunciona();
	}
	
	public double vender(Electrodomestico objeto) {
		catalogo.remove(objeto);
		return objeto.getPrecio();
	}
	
	
	public static void main(String[] args) {
		Tienda sistema = new Tienda();
		sistema.agregar(new Heladera("Samsung", EficienciaEnergetica.A, 620, 50_000));
		sistema.agregar(new Cocina("Domeq", 4, 60_000));
		sistema.agregar(new Televisor("BGH", 32, "1920 X 1080 P", 30_000));

		sistema.enlistarCatalogo();
	}
}
