package grafo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


public class Grafo {

	private HashMap<String, Vertice> vertices = new HashMap<String, Vertice>();

	public void agregarArista(String inicio, String destino, int peso) {
		if (!vertices.containsKey(inicio)) {
			Vertice nuevoVertice = new Vertice(inicio);
			vertices.put(inicio, nuevoVertice);
		}
		if (!vertices.containsKey(destino)) {
			Vertice nuevoDestino = new Vertice(destino);
			vertices.put(destino, nuevoDestino);
		}
		vertices.get(inicio).agregarArista(new Arista(vertices.get(destino), peso));
	}

	

	public HashMap<String, String> dijkstra(String inicio) {
		HashMap<String, Boolean> visitados = new HashMap<String, Boolean>();
		HashMap<String, Double> distancias = new HashMap<String, Double>();
		HashMap<String, String> camino = new HashMap<String, String>();
		HashMap<String, Integer> caminoDirecto = new HashMap<String, Integer>();;
		HashMap<String, String> predecesores = new HashMap<String, String>();
		PriorityQueue<Distancia> cola = new PriorityQueue<Distancia>();


		
		
		for (String vertice : vertices.keySet()) {
			camino.put(vertice, null);
			distancias.put(vertice, Double.MAX_VALUE);
			visitados.put(vertice, Boolean.FALSE);
		}
		
		distancias.put(inicio, 0.0);
		cola.add(new Distancia(inicio, 0.0));
		caminoDirecto.put(inicio, 0);
		
		while (!cola.isEmpty()) {
			Distancia distancia = cola.poll();
			String predecesesor = predecesores.containsKey(distancia.getVertice())?  predecesores.get(distancia.getVertice()):null;
			int caminoPredecesor = caminoDirecto.containsKey(predecesesor)? caminoDirecto.get(predecesesor) : Integer.MAX_VALUE;
			
			if ((!visitados.get(distancia.getVertice()) ) || (caminoDirecto.get(distancia.getVertice()) < caminoPredecesor )) {
				visitados.put(distancia.getVertice(), Boolean.TRUE);
				for (Map.Entry<String, Arista> arista : vertices.get(distancia.getVertice()).getListaDeAristas()
						.entrySet()) {
					if (!visitados.get(arista.getKey())) {
						double nuevaDstancia = distancia.getDistancia() + arista.getValue().getPeso();
						if ( (nuevaDstancia < distancias.get(arista.getKey()))) {
							distancias.put(arista.getKey(), nuevaDstancia);
							caminoDirecto.put(arista.getKey(), caminoDirecto.get(distancia.getVertice()) + 1);
							predecesores.put(distancia.getVertice(), arista.getKey());
							camino.put(arista.getKey(), distancia.getVertice());
							cola.add(new Distancia(arista.getKey(), distancias.get(arista.getKey())));
							
						}
					}
				}

			}
		}
		return camino;
	}



	@Override
	public String toString() {
		String respuesta = vertices.keySet().toString() + "\n";
		for (Map.Entry<String, Vertice> vertice : vertices.entrySet()) {
			respuesta += vertice.getKey() + " : ";
			respuesta += vertice.getValue().toString() + "\n";
		}
		return respuesta;
	}

}
