package propio.OrdenamientoTopologico;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ordenTopologico1.Grafo;
import ordenTopologico1.Vertice;

import java.util.Queue;

public class OrdenamientoTopologico {

	
	public String ordenarGrafo(Grafo grafo) {

		Queue<String> colaDeVectores = new LinkedList<String>();
		List<String> resultado = new LinkedList<String>();
		Map<String,Integer> mapaDeGrados = grafo.calcularGradosDeEntrada();
		
		
		for (Entry<String, Integer> gradoCero : mapaDeGrados.entrySet()) {
			if(gradoCero.getValue() == 0) {
				colaDeVectores.add(gradoCero.getKey());
			}
		}
		
		while(!colaDeVectores.isEmpty()) {
		
			String vector = colaDeVectores.poll();
			resultado.add(vector);
			LinkedList<Vertice> listaDeAdyacentes = grafo.getColeccionDeVectores().get(vector);
	
			for(Vertice adyacente : listaDeAdyacentes) {
				String vectorAdyacente = adyacente.getNombre();
				int grado = mapaDeGrados.get(vectorAdyacente) -1;
				mapaDeGrados.put(vectorAdyacente, grado);
				
				if(grado == 0) {
					colaDeVectores.add(vectorAdyacente);
				}
			}
		}
		
		return resultado.toString();
	}
	
}
