package algoritmosEnClase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

import grafosEnClase.Arista;
import grafosEnClase.Distancia;
import grafosEnClase.Vertice;

public class Dijktra {

	private HashMap<String, Vertice> grafo;

	public Dijktra(HashMap<String, Vertice> grafo) {
		this.grafo = grafo;
	}
	
	public HashMap<String, String> ordenar(String verticeInicial) {
			
			PriorityQueue<Distancia> colaDePrioridad = new PriorityQueue<>();
			HashMap<String, String> predecesores = new HashMap<>();
			HashMap<String, Double> distancias = new HashMap<>();
			HashMap<String, Boolean> estaVisitado = new HashMap<>();
			
			for (String vertice : grafo.keySet()) {
				
				distancias.put(vertice, Double.MAX_VALUE);
				predecesores.put(vertice, null);
				estaVisitado.put(vertice, false);
			}
			
			distancias.put(verticeInicial, 0.0);
			
			colaDePrioridad.add(new Distancia(verticeInicial, 0.0));
			
			while (!colaDePrioridad.isEmpty()) {
				
				Distancia unaDistancia = colaDePrioridad.poll();
				
				if (!estaVisitado.get(unaDistancia.obtenerVertice())) {
					
					estaVisitado.put(unaDistancia.obtenerVertice(), true);
					
					HashSet<Arista> aristas = grafo.get(unaDistancia.obtenerVertice()).getAristasAdyacentes();
					
					for (Arista aristaAdyacente : aristas) {
						
						String verticeAdyacente = aristaAdyacente.destino;
						
						double nuevaDistancia = (unaDistancia.obtenerValor() + aristaAdyacente.peso);
						
						if (!estaVisitado.get(verticeAdyacente)
								&& nuevaDistancia < distancias.get(verticeAdyacente)) {
							
							distancias.put(verticeAdyacente, nuevaDistancia);
							predecesores.put(verticeAdyacente, unaDistancia.obtenerVertice());
							colaDePrioridad.add(new Distancia(verticeAdyacente, nuevaDistancia));
						}
					}
				}
			}
			
			return predecesores;
		}
}
