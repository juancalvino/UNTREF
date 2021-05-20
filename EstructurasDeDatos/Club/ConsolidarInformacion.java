import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import deportistas.Deportista;

import java.util.TreeMap;
import java.util.TreeSet;

public class ConsolidarInformacion {

	Map<String, Set<String>> listaDeSociosConEntrenador = new TreeMap<String, Set<String>>();
	

	Map<String, Set<String>>  devolverListaDeSociosConEntrenadores(Map<String, LinkedList<String>> dicciEntrena){
		
		for (Entry<String, LinkedList<String>> listaEntrenador : dicciEntrena.entrySet()) {
			String entrenador = listaEntrenador.getKey();

			for(String socio : listaEntrenador.getValue()) {
				if(!listaDeSociosConEntrenador.containsKey(socio)) {
					Set<String> entrenadoresDelSocio = new TreeSet<String>(List.of(entrenador));
					listaDeSociosConEntrenador.put(socio, entrenadoresDelSocio);
				}
				else {
					listaDeSociosConEntrenador.get(socio).add(entrenador);
				}
			}
		}
		
		return listaDeSociosConEntrenador;
	}	
	

	
	public static void main(String[] args) {
		Map<String, LinkedList<String>> dicciEntrena = new HashMap<String, LinkedList<String>>();
		dicciEntrena.put("Bielsa", new LinkedList<>(List.of("Juan","Alberto")));
		dicciEntrena.put("Alvarez", new LinkedList<>(List.of("Tom", "Alberto", "Vero")));

		Map<String, Set<String>> lista = new ConsolidarInformacion().devolverListaDeSociosConEntrenadores(dicciEntrena);
		System.out.println(lista);
		
		}
	
	}

	//	Map<String, List<String>>  devolverListaDeSociosConEntrenadores(Map<String, LinkedList<String>> dicciEntrena){
//	
//	for (Entry<String, LinkedList<String>> listaEntrenador : dicciEntrena.entrySet()) {
//		String entrenador = listaEntrenador.getKey();
//
//		for(String socio : listaEntrenador.getValue()) {
//			if(!listaDeSociosConEntrenador.containsKey(socio)) {
//				List<String> entrenadoresDelSocio = new LinkedList<String>(List.of(entrenador));
//				listaDeSociosConEntrenador.put(socio, entrenadoresDelSocio);
//			}
//			else {
//				List<String> entrenadoresDelSocio = listaDeSociosConEntrenador.get(socio);
//				entrenadoresDelSocio.add(entrenador);
//				entrenadoresDelSocio.sort(null);
//				
//			}
//		}
//	}
//	
//	return listaDeSociosConEntrenador;
//}

