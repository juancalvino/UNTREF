package grafos.dijkstra;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import grafos.*;

public class Dijkstra {
	
	private HashMap<String, Vertice> vertices;

	public Dijkstra(Grafo grafo) {
		this.vertices = grafo.getVertices();
	}

	  public Map<String, String> dijkstra(String inicio) {
	        
	        PriorityQueue<Distancia> h = new PriorityQueue<Distancia>();
	        
	        Map<String, Boolean> visitados = new HashMap<String, Boolean>();
	        
	        Map<String, Double> distancias = new HashMap<String, Double>();
	        
	        Map<String, String> predecesores = new HashMap<String, String>();
	        
	        for (Map.Entry<String, Vertice> vertice : vertices.entrySet()) {
	            visitados.put(vertice.getKey(), false);
	            distancias.put(vertice.getKey(), Double.MAX_VALUE);
	            predecesores.put(vertice.getKey(), null);
	        }
	        
	        distancias.put(inicio, 0.0);
	        
	        h.add(new Distancia(inicio, 0.0));
	        
	        while(!h.isEmpty()) {
	            Distancia distancia = h.poll();
	            
	            if(!visitados.get(distancia.getVertice())) {
	                visitados.put(distancia.getVertice(), true);
	                for (Map.Entry<String, Arista> aristaAdyacente : vertices.get(distancia.getVertice()).getListaDeAristas().entrySet()) {
	                    if(!visitados.get(aristaAdyacente.getKey())) {
	                        if(distancia.getDistancia() + aristaAdyacente.getValue().getPeso() < distancias.get(aristaAdyacente.getKey())) {
	                            distancias.put(aristaAdyacente.getKey(), distancia.getDistancia() + aristaAdyacente.getValue().getPeso());
	                            predecesores.put(aristaAdyacente.getKey(), distancia.getVertice());
	                            h.add(new Distancia(aristaAdyacente.getKey(), distancias.get(aristaAdyacente.getKey())));
	                        }
	                    }
	                }
	            }
	        }
	        
	        return predecesores;
	    }
	
}
