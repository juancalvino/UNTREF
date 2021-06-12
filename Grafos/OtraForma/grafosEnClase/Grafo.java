package grafosEnClase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import algoritmosEnClase.Dijktra;
import algoritmosEnClase.OrdenamientoTopologico;

public class Grafo {

	private HashMap<String, Vertice> grafo;

	public Grafo() {
		this.grafo = new HashMap<String, Vertice>();
	}


	public void agregarArista(String verticeOrigen, String verticeDestino, double peso) {

		Arista arista = new Arista(verticeDestino, peso);
		
		if (!grafo.containsKey(verticeOrigen))
			grafo.put(verticeOrigen, new Vertice());
		
		if (!grafo.containsKey(verticeDestino))
			grafo.put(verticeDestino, new Vertice());
		
		grafo.get(verticeOrigen).addArista(arista);
		
		grafo.get(verticeDestino).aumentarGrado();
	}

	public HashMap<String, Vertice> getGrafo() {
		return grafo;
	}



	@Override
	public String toString() {

		String mensaje = grafo.keySet().toString() + "\n";

		for (String vertice : grafo.keySet())
			mensaje += vertice + ": " + grafo.get(vertice).getAristasAdyacentes() + "\n";

		return mensaje;
	}

}
