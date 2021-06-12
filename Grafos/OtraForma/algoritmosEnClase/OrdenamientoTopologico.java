package algoritmosEnClase;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import grafosEnClase.Arista;
import grafosEnClase.GrafoExcepcion;
import grafosEnClase.Vertice;

public class OrdenamientoTopologico {

	private HashMap<String, Vertice> grafo;
	
	public OrdenamientoTopologico(HashMap<String, Vertice> grafo) {
		this.grafo = grafo;
	}
	
	
	public LinkedList<String> ordenar() {
		HashMap<String, Integer> gradoDeVertices = this.obtenerGradoDeVertices();
		Queue<String> colaVertices = new LinkedList<>();

		for (String vertice : gradoDeVertices.keySet()) {
			if (gradoDeVertices.get(vertice) == 0)
				colaVertices.add(vertice);
		}

		LinkedList<String> verticesOrdenados = new LinkedList<String>();

		while (!colaVertices.isEmpty()) {
			String vertice = colaVertices.poll();
			verticesOrdenados.add(vertice);

			for (Arista arista : grafo.get(vertice).getAristasAdyacentes()) {
				int nuevoGrado = gradoDeVertices.get(arista.destino) - 1;
				gradoDeVertices.put(arista.destino, nuevoGrado);
				if (nuevoGrado == 0)
					colaVertices.add(arista.destino);
			}
		}

		if (verticesOrdenados.size() != grafo.keySet().size())
			throw new GrafoExcepcion("No se puede calcular el orden "
					+ "topológico porque el grafo tiene un ciclo.");

		return verticesOrdenados;
	}

	private HashMap<String, Integer> obtenerGradoDeVertices() {

		HashMap<String, Integer> gradoDeVertices = new HashMap<>();

		for (String vertice : grafo.keySet()) {
			int grado = this.grafo.get(vertice).getrGrado();
			gradoDeVertices.put(vertice, grado);
		}

		return gradoDeVertices;
	}

	
}
