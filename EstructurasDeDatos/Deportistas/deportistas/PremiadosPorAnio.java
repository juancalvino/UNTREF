package deportistas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PremiadosPorAnio {

	Map<Integer, List<Deportista>> premiadosPorAnio = new TreeMap<Integer, List<Deportista>>();
	
	
	public Map<Integer,List<Deportista>> devolverListaPorAnio(List<Deportista> lista){
		
		for (Deportista deportista:lista ) {
			int anioDelPremio = deportista.getAnio();
			if(!premiadosPorAnio.containsKey(deportista.getAnio())){
				List<Deportista> listaDeportistas = new LinkedList<Deportista>(List.of(deportista));
				premiadosPorAnio.put(anioDelPremio, listaDeportistas);
			}
			else {
				premiadosPorAnio.get(anioDelPremio).add(deportista);
			}
		}
		
		return premiadosPorAnio;
	}
	
	public static void main(String[] args) {
		List<Deportista> listaDeDeportistas = new ArrayList<Deportista>();
		listaDeDeportistas.add(new Deportista("Gabriela Sabatini", 1990, "Individual F US Open"));
		listaDeDeportistas.add(new Deportista("Gabriela Sabatini", 1988, "Dobles F US Open"));
		listaDeDeportistas.add(new Deportista("Steffi Graf", 1988, "Dobles F US Open"));
		listaDeDeportistas.add(new Deportista("Gabriela Sabatini", 1991, "Dobles F Wimbledon"));
		listaDeDeportistas.add(new Deportista("Steffi Graf", 1991, "Dobles F Wimbledon"));
		
		PremiadosPorAnio listaPorAnio = new PremiadosPorAnio();
		System.out.println(listaPorAnio.devolverListaPorAnio(listaDeDeportistas));
	}
}
