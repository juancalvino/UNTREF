package fabi;
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

	public Map<String, Set<String>> prim() {
		PriorityQueue<AristaAEM> cola = new PriorityQueue<AristaAEM>();
		Map<String, Set<String>> arbolMinimo = new HashMap<String, Set<String>>();
		HashMap<String, Boolean> estaVisitado = new HashMap<>();
		for (String vertice : vertices.keySet()) {
			estaVisitado.put(vertice, false);
		}
		String v = vertices.keySet().iterator().next();
		for (Map.Entry<String, Arista> arista : vertices.get(v).getListaDeAristas().entrySet()) {
			cola.add(new AristaAEM(v, arista.getKey(), arista.getValue().getPeso()));
		}
		estaVisitado.put(v, true);
		while (!cola.isEmpty() && arbolMinimo.size() < vertices.size() - 1) {
			AristaAEM aristaActual = cola.poll();
			if (!estaVisitado.get(aristaActual.getOrigen()) || !estaVisitado.get(aristaActual.getDestino())) {
				Set<String> set = new HashSet<String>();
				if (arbolMinimo.containsKey(aristaActual.getOrigen())) {
					set = arbolMinimo.get(aristaActual.getOrigen());
				}
				set.add(aristaActual.getDestino());
				arbolMinimo.put(aristaActual.getOrigen(), set);
				String visitar = null;
				if (!estaVisitado.get(aristaActual.getOrigen())) {
					visitar = aristaActual.getOrigen();
				} else {
					visitar = aristaActual.getDestino();
				}
				estaVisitado.put(visitar, true);
				for (Map.Entry<String, Arista> arista : vertices.get(visitar).getListaDeAristas().entrySet()) {
					if (!estaVisitado.get(arista.getValue().getVerticeDestino().getNombre())) {
						cola.add(new AristaAEM(visitar, arista.getValue().getVerticeDestino().getNombre(),
								arista.getValue().getPeso()));
					}
				}
			}
		}
		return arbolMinimo;
	}

	public Map<String, Set<String>> kruskal() {
		Map<String, Set<String>> arbolMinimo = new HashMap<String, Set<String>>();
		ConjuntoAEM conjuntoAEM = new ConjuntoAEM(vertices.keySet());
		PriorityQueue<AristaAEM> cola = new PriorityQueue<AristaAEM>();
		for (String vertice : vertices.keySet()) {
			for (Map.Entry<String, Arista> arista : vertices.get(vertice).getListaDeAristas().entrySet()) {
				cola.add(new AristaAEM(vertice, arista.getKey(), arista.getValue().getPeso()));
			}
		}
		while (!cola.isEmpty() && arbolMinimo.size() < vertices.size() - 1) {
			AristaAEM aristaAEM = cola.poll();
			if (!conjuntoAEM.find(aristaAEM.getOrigen()).equals(conjuntoAEM.find(aristaAEM.getDestino()))) {
				Set<String> set = new HashSet<String>();
				if (arbolMinimo.containsKey(aristaAEM.getOrigen())) {
					set = arbolMinimo.get(aristaAEM.getOrigen());
				}
				set.add(aristaAEM.getDestino());
				arbolMinimo.put(aristaAEM.getOrigen(), set);
				conjuntoAEM.union(aristaAEM.getOrigen(), aristaAEM.getDestino());
			}
		}
		return arbolMinimo;
	}

	public HashMap<String, String> dijkstra(String inicio) {
		HashMap<String, Boolean> visitados = new HashMap<String, Boolean>();
		HashMap<String, Double> distancias = new HashMap<String, Double>();
		HashMap<String, String> camino = new HashMap<String, String>();
		PriorityQueue<Distancia> cola = new PriorityQueue<Distancia>();
		for (String vertice : vertices.keySet()) {
			camino.put(vertice, null);
			distancias.put(vertice, Double.MAX_VALUE);
			visitados.put(vertice, Boolean.FALSE);
		}
		distancias.put(inicio, 0.0);
		cola.add(new Distancia(inicio, 0.0));
		while (!cola.isEmpty()) {
			Distancia distancia = cola.poll();
			if (!visitados.get(distancia.getVertice())) {
				visitados.put(distancia.getVertice(), Boolean.TRUE);
				for (Map.Entry<String, Arista> arista : vertices.get(distancia.getVertice()).getListaDeAristas()
						.entrySet()) {
					if (!visitados.get(arista.getKey())) {
						double nuevaDstancia = distancia.getDistancia() + arista.getValue().getPeso();
						if (nuevaDstancia < distancias.get(arista.getKey())) {
							distancias.put(arista.getKey(), nuevaDstancia);
							camino.put(arista.getKey(), distancia.getVertice());
							cola.add(new Distancia(arista.getKey(), distancias.get(arista.getKey())));
						}
					}
				}
			}
		}
		return camino;
	}

	public HashMap<String, String> bellmanFord(String inicio) throws GrafoExcepcion {
		HashMap<String, Double> distancias = new HashMap<String, Double>();
		HashMap<String, String> camino = new HashMap<String, String>();
		for (String vertice : vertices.keySet()) {
			camino.put(vertice, null);
			distancias.put(vertice, Double.MAX_VALUE);
		}
		distancias.put(inicio, 0.0);
		for (int i = 1; i <= vertices.size() - 1; i++) {
			for (Map.Entry<String, Vertice> vertice : vertices.entrySet()) {
				for (Map.Entry<String, Arista> arista : vertice.getValue().getListaDeAristas().entrySet()) {
					double nuevaDstancia = distancias.get(vertice.getKey()) + arista.getValue().getPeso();
					if (nuevaDstancia < distancias.get(arista.getKey())) {
						distancias.put(arista.getKey(), nuevaDstancia);
						camino.put(arista.getKey(), vertice.getKey());
					}
				}
			}
		}
		for (Map.Entry<String, Vertice> vertice : vertices.entrySet()) {
			for (Map.Entry<String, Arista> arista : vertice.getValue().getListaDeAristas().entrySet()) {
				double nuevaDstancia = distancias.get(vertice.getKey()) + arista.getValue().getPeso();
				if (nuevaDstancia < distancias.get(arista.getKey())) {
					throw new GrafoExcepcion("No se puede calcular el camino minimo porque tiene ciclos negativos");
				}
			}
		}
		return camino;
	}

	public List<String> ordenamientoTopologico() throws GrafoExcepcion {
		Queue<Vertice> cola = new LinkedList<Vertice>();
		List<String> camino = new LinkedList<String>();
		HashMap<String, Integer> gradosDeEntrada = calcularGradoDeEntrada(vertices);
		for (Map.Entry<String, Vertice> vertice : vertices.entrySet()) {
			if (gradosDeEntrada.get(vertice.getKey()) == 0) {
				cola.add(vertice.getValue());
			}
		}
		while (!cola.isEmpty()) {
			Vertice v = cola.poll();
			camino.add(v.getNombre());
			for (Map.Entry<String, Arista> arista : v.getListaDeAristas().entrySet()) {
				gradosDeEntrada.put(arista.getKey(),
						gradosDeEntrada.get(arista.getValue().getVerticeDestino().getNombre()) - 1);
				if (gradosDeEntrada.get(arista.getValue().getVerticeDestino().getNombre()) == 0) {
					cola.add(arista.getValue().getVerticeDestino());
				}
			}
		}
		if (camino.size() != vertices.size()) {
			throw new GrafoExcepcion("No se puede calcular el orden topologico porque el grafo tiene ciclos");
		}
		return camino;
	}

	private HashMap<String, Integer> calcularGradoDeEntrada(HashMap<String, Vertice> vertices) {
		HashMap<String, Integer> gradosEntradaVertice = new HashMap<>();
		for (Map.Entry<String, Vertice> vertice : vertices.entrySet()) {
			if (!gradosEntradaVertice.containsKey(vertice.getKey())) {
				gradosEntradaVertice.put(vertice.getKey(), 0);
			}
			for (Map.Entry<String, Arista> arista : vertice.getValue().getListaDeAristas().entrySet()) {
				int grado = 1;
				if (gradosEntradaVertice.containsKey(arista.getValue().getVerticeDestino().getNombre())) {
					grado = gradosEntradaVertice.get(arista.getValue().getVerticeDestino().getNombre()) + 1;
				}
				gradosEntradaVertice.put(arista.getValue().getVerticeDestino().getNombre(), grado);
			}
		}
		return gradosEntradaVertice;
	}

	public HashMap<String, String> bfs(String inicio) {
		HashMap<String, String> predecesores = new HashMap<String, String>();
		Queue<String> cola = new LinkedList<String>();
		for (String vertice : vertices.keySet()) {
			predecesores.put(vertice, null);
		}
		cola.add(inicio);
		while (!cola.isEmpty()) {
			String vertice = cola.poll();
			for (String verticeAdyacente : vertices.get(vertice).getListaDeAristas().keySet()) {
				if (predecesores.get(verticeAdyacente) == null && !verticeAdyacente.equals(inicio)) {
					predecesores.put(verticeAdyacente, vertice);
					cola.add(verticeAdyacente);
				}
			}
		}
		return predecesores;
	}

	public HashMap<String, String> dfs(String inicio) {
		HashMap<String, String> predecesores = new HashMap<String, String>();
		Stack<String> pila = new Stack<String>();
		for (String vertice : vertices.keySet()) {
			predecesores.put(vertice, null);
		}
		pila.push(inicio);
		while (!pila.isEmpty()) {
			String vertice = pila.pop();
			for (String verticeAdyacente : vertices.get(vertice).getListaDeAristas().keySet()) {
				if (predecesores.get(verticeAdyacente) == null && !verticeAdyacente.equals(inicio)) {
					predecesores.put(verticeAdyacente, vertice);
					pila.push(verticeAdyacente);
				}
			}
		}
		return predecesores;
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
	
	public static void main(String[] args) {
		Grafo grafo = new Grafo();
		grafo.agregarArista("V1", "V2", 1);
		grafo.agregarArista("V2", "V1", 1);

		grafo.agregarArista("V1", "V3", 1);
		grafo.agregarArista("V3", "V1", 1);

		grafo.agregarArista("V2", "V4", 1);
		grafo.agregarArista("V4", "V2", 1);

		grafo.agregarArista("V2", "V5", 1);
		grafo.agregarArista("V5", "V2", 1);

		grafo.agregarArista("V4", "V3", 1);
		grafo.agregarArista("V3", "V4", 1);

		grafo.agregarArista("V5", "V3", 1);
		grafo.agregarArista("V3", "V5", 1);
		
		System.out.println(grafo.bfs("V1"));

	}

}
