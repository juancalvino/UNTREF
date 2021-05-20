package oficina;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 *La oficina de personal de una empresa nos contrata para organizar la informacion de sus sueldos de cada sector.
 *En este momento la informacion esta totalmente desorganizada. Son fichas sin ningun orden,contsa del 
 *sector donde trabaja, nombre de la persona y su sueldo.
 * Nos piden que armemos una salida donde , para cada sector donde, para cada sector, se encuentre el nombre en orden alfabetico y su sueldo.
 * 
 *
 */

public class Oficina {

	Map<String, List<Empleado>> listaOrganizada = new HashMap<String, List<Empleado>>();
	
	public Map<String, List<Empleado>> devolverListaOrdenadaPorSector(List<Empleado> listaDeEmpleados){
		
		for (Empleado empleado : listaDeEmpleados) {
			if(!listaOrganizada.containsKey(empleado.getSector())) {
				listaOrganizada.put(empleado.getSector(), new LinkedList<Empleado>(List.of(empleado)));
			}
			else {
				List<Empleado> listaEmpleado =listaOrganizada.get(empleado.getSector());
				listaEmpleado.add(empleado);
			}
		}

		return listaOrganizada;
	}
	
	public static void main(String[] args) {
		List<Empleado> listaDeEmpleados = new LinkedList<Empleado>(List.of(
												new Empleado("Compras", "Juan", 100)
											   ,new Empleado("Ventas", "Pedro", 100)
											   ,new Empleado("Compras", "Ana", 200)
											   ,new Empleado("Administracion", "Abi", 100)
											   ,new Empleado("Ventas", "Teresa", 200)
											   ));	
		Oficina oficina = new Oficina();
		System.out.println(oficina.devolverListaOrdenadaPorSector(listaDeEmpleados));
	}
}
