package patronComposite;

import java.util.ArrayList;
import java.util.List;

public class Pizzeria {

	private List<Producto> menu = new ArrayList<Producto>();

	public void agregarProductos(Producto p) {
		menu.add(p);
	}

	public void getMenu() {
		System.out.println(menu);
	}

	public static void main(String[] args) {
		Pizzeria laMejor = new Pizzeria();
		Producto pizza = new Pizza("Grande", 500);
		Producto porcionPizza = new PorcionPizza("PorcionPizza", 100);
		Producto porcionFaina = new PorcionFaina("PorcionFaina", 80);
		Producto gaseosa = new Gaseosa("Coca", 120);

		Combo comboUno = new Combo("ComboUno");
		Combo comboDos = new Combo("ComboDos");
		Combo comboTres = new Combo("ComboTres");

		comboUno.addProducto(porcionPizza);
		comboUno.addProducto(porcionFaina);
		comboUno.addProducto(gaseosa);

		comboDos.addProducto(porcionPizza);
		comboDos.addProducto(porcionFaina);
		comboDos.addProducto(gaseosa);
		comboDos.addProducto(porcionPizza);

		comboTres.addProducto(comboUno);
		comboTres.addProducto(comboDos);

		laMejor.agregarProductos(pizza);
		laMejor.agregarProductos(porcionPizza);
		laMejor.agregarProductos(porcionFaina);
		laMejor.agregarProductos(gaseosa);
		laMejor.agregarProductos(comboUno);
		laMejor.agregarProductos(comboDos);
		laMejor.agregarProductos(comboTres);

		laMejor.getMenu();

	}

}
