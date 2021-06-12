package algoritmosEnClase.krustal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import grafosEnClase.*;


public class Kruskal {
	
	private HashMap<String, Vertice> vertices;

	public Kruskal(HashMap<String, Vertice> vertices) {
		this.vertices = vertices;
	}
	
	public HashMap<String, Set<String>> ordenar() {
		
		ConjuntoAEM S = new ConjuntoAEM(vertices.keySet());
		
		HashMap<String, Set<String>> T = new HashMap<String, Set<String>>();
		
		PriorityQueue<AristaAEM> H = new PriorityQueue<AristaAEM>();
		
		for(String vertice : vertices.keySet()) {
			
			//Recorre el mapa de aristas del nodo
			for(Arista arista: vertices.get(vertice).getAristasAdyacentes()) {
				
				H.add(new AristaAEM(vertice, arista.getDestino(), arista.getPeso()));
				
			}
		}
		
		while(!H.isEmpty() && T.size() < vertices.size() - 1) {
			
			AristaAEM arista = H.poll();
			
			if(S.find(arista.getOrigen()) != S.find(arista.getDestino())) {
				
				Set<String> set = new HashSet<String>();
				
				if(T.containsKey(arista.getOrigen())) {
					set = T.get(arista.getOrigen());
				}
				
				set.add(arista.getDestino());
				
				T.put(arista.getOrigen(), set);
				
				S.union(arista.getOrigen(), arista.getDestino());
			}
			
		}
		
		return T;
		
	}

	public static void main(String[] args) throws GrafoExcepcion {
		
		Grafo grafo = new Grafo();

		grafo.agregarArista("1", "2", 6);
		grafo.agregarArista("2", "1", 6);

		grafo.agregarArista("1", "3", 1);
		grafo.agregarArista("3", "1", 1);

		grafo.agregarArista("1", "4", 5);
		grafo.agregarArista("4", "1", 5);

		grafo.agregarArista("2", "5", 3);
		grafo.agregarArista("5", "2", 3);

		grafo.agregarArista("2", "3", 5);
		grafo.agregarArista("3", "2", 5);

		grafo.agregarArista("5", "3", 6);
		grafo.agregarArista("3", "5", 6);

		grafo.agregarArista("5", "6", 6);
		grafo.agregarArista("6", "5", 6);

		grafo.agregarArista("3", "6", 4);
		grafo.agregarArista("3", "6", 4);

		grafo.agregarArista("3", "4", 5);
		grafo.agregarArista("4", "3", 5);

		grafo.agregarArista("4", "6", 2);
		grafo.agregarArista("6", "4", 2);

		System.out.println(new Kruskal(grafo.getGrafo()).ordenar());
		
		System.out.println(" Resultado: {1=[3], 2=[5], 3=[2, 6], 6=[4]} ");
	}
}
