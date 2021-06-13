package tendidoMinimo;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.Queue;

import grafo.Arista;
import grafo.Grafo;
import grafo.Vertice;

public class Prim {

	public LinkedHashSet<String> prim(Grafo grafo) {
		LinkedHashSet<String> visitados = new LinkedHashSet<String>(); 
		Queue<Arista> colaPrioridad = new PriorityQueue<Arista>(new PrioridadDePeso());
	
		String destino = grafo.getColeccionDeAristas().keySet().iterator().next();
		
		visitados.add(destino);
		
		for(Arista arista : grafo.getArestasDeSalidaDel(destino)) {
			if(!visitados.contains(arista.getDestino().getNombre())) {
				colaPrioridad.add(arista);
			}
		}
		
		while(!colaPrioridad.isEmpty()) {
			Vertice vertice = colaPrioridad.poll().getDestino();
			visitados.add(vertice.getNombre());
			
			for(Arista arista : grafo.getArestasDeSalidaDel(vertice.getNombre())) {
				if(!visitados.contains(arista.getDestino().getNombre())) {
					colaPrioridad.add(arista);
				}
			}	
		}
		return visitados;
	}

	
	public class PrioridadDePeso implements Comparator<Arista> {
		
		@Override
		public int compare(Arista arista1, Arista arista2) {
			return arista1.getPeso() > arista2.getPeso()
					? 1 : -1;
		}
		
	}
	
	public static void main(String[] args) {
		Grafo grafo = new Grafo();
		grafo.agregarArista(new Vertice("V0"),new Vertice("V1"), 2);
		grafo.agregarArista(new Vertice("V1"),new Vertice("V0"), 2);
		grafo.agregarArista(new Vertice("V0"),new Vertice("V3"), 1);
		grafo.agregarArista(new Vertice("V3"),new Vertice("V0"), 1);
		grafo.agregarArista(new Vertice("V1"),new Vertice("V3"), 3);
		grafo.agregarArista(new Vertice("V3"),new Vertice("V1"), 3);
		grafo.agregarArista(new Vertice("V4"),new Vertice("V1"), 10);
		grafo.agregarArista(new Vertice("V1"),new Vertice("V4"), 10);
		grafo.agregarArista(new Vertice("V0"),new Vertice("V2"), 4);
		grafo.agregarArista(new Vertice("V2"),new Vertice("V0"), 4);
		grafo.agregarArista(new Vertice("V5"),new Vertice("V2"), 5);
		grafo.agregarArista(new Vertice("V2"),new Vertice("V5"), 5);
		grafo.agregarArista(new Vertice("V2"),new Vertice("V3"), 2);
		grafo.agregarArista(new Vertice("V3"),new Vertice("V2"), 2);
		grafo.agregarArista(new Vertice("V4"),new Vertice("V3"), 2);
		grafo.agregarArista(new Vertice("V3"),new Vertice("V4"), 2);
		grafo.agregarArista(new Vertice("V5"),new Vertice("V3"), 8);
		grafo.agregarArista(new Vertice("V3"),new Vertice("V5"), 8);
		grafo.agregarArista(new Vertice("V6"),new Vertice("V3"), 4);
		grafo.agregarArista(new Vertice("V3"),new Vertice("V6"), 4);
		grafo.agregarArista(new Vertice("V6"),new Vertice("V4"), 6);
		grafo.agregarArista(new Vertice("V4"),new Vertice("V6"), 6);
		grafo.agregarArista(new Vertice("V5"),new Vertice("V6"), 1);
		grafo.agregarArista(new Vertice("V6"),new Vertice("V5"), 1);
		
		System.out.println(new Prim().prim(grafo));
	}
	
}

