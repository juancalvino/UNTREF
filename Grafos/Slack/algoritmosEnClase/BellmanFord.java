package algoritmosEnClase;

import java.util.HashMap;

import grafosEnClase.Arista;
import grafosEnClase.GrafoExcepcion;
import grafosEnClase.Vertice;

public class BellmanFord {

		private HashMap<String, Vertice> grafo;

		public BellmanFord(HashMap<String, Vertice> grafo) {
		 this.grafo = grafo;
		}	
			
			
		public HashMap<String, String> ordenar(String verticeInicial) {
				
				HashMap<String, String> predecesores = new HashMap<>();
				HashMap<String, Double> distancias = new HashMap<>();
				
				for (String vertice : grafo.keySet()) {
					
					distancias.put(vertice, Double.MAX_VALUE);
					predecesores.put(vertice, null);
				}
				
				distancias.put(verticeInicial, 0.0);
				
				for (int i = 1; i < grafo.keySet().size(); i++) {
					
					for (String vertice : grafo.keySet()) {
						
						for (Arista aristaAdyacente : grafo.get(vertice).getAristasAdyacentes()) {
							
							String verticeAdyacente = aristaAdyacente.destino;
							
							double nuevaDistancia = distancias.get(vertice) + aristaAdyacente.peso;
							
							if (nuevaDistancia < distancias.get(verticeAdyacente)) {
								
								distancias.put(verticeAdyacente, nuevaDistancia);
								predecesores.put(verticeAdyacente, vertice);
							}
						}
					}
				}
				
				for (String vertice : grafo.keySet()) {
					
					for (Arista aristaAdyacente : grafo.get(vertice).getAristasAdyacentes()) {
						
						String verticeAdyacente = aristaAdyacente.destino;
						
						double nuevaDistancia = distancias.get(vertice) + aristaAdyacente.peso;
						
						if (nuevaDistancia < distancias.get(verticeAdyacente)) {
							
							throw new GrafoExcepcion("No se puede calcular el orden "
								+ "topológico porque el grafo tiene un ciclo.");
					}
				}
			}
			
			return predecesores;
		}
}
