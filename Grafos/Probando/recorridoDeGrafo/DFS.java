package recorridoDeGrafo;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import grafo.Arista;
import grafo.Grafo;
import grafo.Vertice;

public class DFS {

	Set<String> conjunto;
	Grafo grafo;
	private int contador;
	
	public Set<String> recorrerRecursivo(Grafo grafo, Vertice origen) {

		conjunto = new LinkedHashSet<String>();
		contador = 0;
		
		this.grafo = grafo;
		recorrerRecursivo(origen);
		
		return conjunto;
	}

	private Vertice recorrerRecursivo(Vertice origen) {

		conjunto.add(origen.getNombre());
		contador++;
		
		LinkedList<Arista> coleccionDeAristas = grafo.getColeccionDeAristas().get(origen.getNombre());
		
		if(!coleccionDeAristas.isEmpty()) {
			
			for(Arista arista :coleccionDeAristas ) {
				
				if(!conjunto.contains(arista.getDestino().getNombre())
						&& contador < grafo.getColeccionDeAristas().keySet().size() ) {
					recorrerRecursivo(arista.getDestino());
				}
			}
		}
		
		return origen;
	}	
	
	
	//TODO REVISAR!
	public Set<String> recorrer(Grafo grafo, Vertice origen){

		Stack<Vertice> pila = new Stack<Vertice>();
		conjunto = new LinkedHashSet<String>();
		
		pila.add(origen);
		conjunto.add(origen.getNombre());
			
		while(!pila.isEmpty()) {
			Vertice vertice = pila.pop();
			for(Arista arista : grafo.getArestasDeSalidaDel(vertice)) {
				if(!conjunto.contains(arista.getDestino().getNombre())) {
					pila.add(arista.getDestino());
					conjunto.add(arista.getDestino().getNombre());
				}
			
			}
		
		}
		return conjunto;
	}		
	
	
	public static void main(String[] args) {
		
		Grafo grafo = new Grafo();
		
		grafo.agregarArista(new Vertice("A"), new Vertice("B"), 1);
		grafo.agregarArista(new Vertice("A"), new Vertice("C"), 1);
		grafo.agregarArista(new Vertice("A"), new Vertice("D"), 1);
		grafo.agregarArista(new Vertice("C"), new Vertice("E"), 1);
		grafo.agregarArista(new Vertice("C"), new Vertice("F"), 1);
		grafo.agregarArista(new Vertice("D"), new Vertice("F"), 1);
		
		DFS dfs= new DFS();
		
		System.out.println(dfs.recorrerRecursivo(grafo, new Vertice("A")));
		System.out.println(dfs.recorrer(grafo, new Vertice("A")));
		
	}
		
}
	

