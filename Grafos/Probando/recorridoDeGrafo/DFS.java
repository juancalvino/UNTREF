package recorridoDeGrafo;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

import grafo.Arista;
import grafo.Grafo;
import grafo.Vertice;

public class DFS {

	Set<String> conjunto = new LinkedHashSet<String>();
	Grafo grafo;
	
	public Set<String> recorrer(Grafo grafo, Vertice origen) {

		this.grafo = grafo;
		recorrer(origen);
		
		return conjunto;
	}

	public Vertice recorrer(Vertice origen) {

		conjunto.add(origen.getNombre());

		LinkedList<Arista> coleccionDeAristas = grafo.getColeccionDeAristas().get(origen.getNombre());
		
		if(!coleccionDeAristas.isEmpty()) {
			
			for(Arista arista :coleccionDeAristas ) {
				
				if(!conjunto.contains(arista.getDestino().getNombre())) {
					recorrer(arista.getDestino());
				}
			}
		}
		
		return origen;
	}	
		
	public static void main(String[] args) {
		
		Grafo grafo = new Grafo();
		
		grafo.agregarArista(new Vertice("A"), new Vertice("B"), 1);
		grafo.agregarArista(new Vertice("A"), new Vertice("C"), 1);
		grafo.agregarArista(new Vertice("A"), new Vertice("D"), 1);
		grafo.agregarArista(new Vertice("D"), new Vertice("F"), 1);
		grafo.agregarArista(new Vertice("C"), new Vertice("E"), 1);
		grafo.agregarArista(new Vertice("C"), new Vertice("F"), 1);
		
		DFS dfs= new DFS();
		
		System.out.println(dfs.recorrer(grafo, new Vertice("A")));
		
	}
		
}
	

