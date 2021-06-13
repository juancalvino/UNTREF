package recorridoDeGrafo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import grafo.Arista;
import grafo.Grafo;
import grafo.Vertice;

public class BFS {
 
	Queue<Vertice> cola = new LinkedList<Vertice>();
	Set<String> lista = new HashSet<String>();
	
	
	public Set<String> recorrer(Grafo grafo, Vertice origen) {
	
		cola.add(origen);
		lista.add(origen.getNombre());
				
		while(!cola.isEmpty()) {
			Vertice vertice = cola.poll();
			for(Arista arista : grafo.getArestasDeSalidaDel(vertice)) {
				if(!lista.contains(arista.getDestino().getNombre()))
				cola.add(arista.getDestino());
				lista.add(arista.getDestino().getNombre());
			}
			
		}
		
		return lista;
	}
	
	
	public static void main(String[] args) {
		
		Grafo grafo = new Grafo();
		
		grafo.agregarArista(new Vertice("A"), new Vertice("B"), 1);
		grafo.agregarArista(new Vertice("A"), new Vertice("C"), 1);
		grafo.agregarArista(new Vertice("A"), new Vertice("D"), 1);
		grafo.agregarArista(new Vertice("D"), new Vertice("F"), 1);
		grafo.agregarArista(new Vertice("C"), new Vertice("E"), 1);
		grafo.agregarArista(new Vertice("C"), new Vertice("F"), 1);
		
		BFS bfs= new BFS();
		
		System.out.println(bfs.recorrer(grafo, new Vertice("A")));
		
	}
	
}	