package ordenTopologico1;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class GrafoDos {

	Queue<String> colaDeVectores = new LinkedList<String>();
	Map<String, LinkedList<Vertice>> coleccionDeVectores = new HashMap<String, LinkedList<Vertice>>();
	



	public void agregarArista(Vertice origen,Vertice destino) {
		
		String nombreDestino = destino.getNombre();
		
		if(!coleccionDeVectores.containsKey(nombreDestino)) {
			coleccionDeVectores.put(nombreDestino, new LinkedList<Vertice>());
			}

		if(!coleccionDeVectores.containsKey(origen.getNombre())) {
			coleccionDeVectores.put(origen.getNombre(), new LinkedList<Vertice>());
			}
		
		coleccionDeVectores.get(nombreDestino).add(origen);
	};

	public int calcularGradosDeSalida(Vertice vertice) {
		int gradosDeEntrada = 0;
		
		for (Entry<String, LinkedList<Vertice>> listaAdyacencia : coleccionDeVectores.entrySet()) {
			for (Vertice verticeDeSalida: listaAdyacencia.getValue()) {
				if(verticeDeSalida.getNombre() == vertice.getNombre()) {
					gradosDeEntrada++;
				}
			}
		}
		
		return gradosDeEntrada;
	}
	
	public Map<String,Integer> generarMapaConEntradas(){
		Map<String, Integer> mapasDeEntradas = new HashMap<String, Integer>();
	
		for (String vectores : coleccionDeVectores.keySet()) {
			mapasDeEntradas.put(vectores, coleccionDeVectores.get(vectores).size());
		}
		return mapasDeEntradas;
		
	}
	
	
	public int calcularGradosDeEntrada(Vertice vertice) {		
		return coleccionDeVectores.get(vertice.getNombre()).size();
	}
		
	public Map<String, LinkedList<Vertice>> getColeccionDeVectores() {
		return coleccionDeVectores;
	}		

	public static void main(String[] args) {
		
		GrafoDos grafo = new GrafoDos();
		
		grafo.agregarArista(new Vertice("V0"),new Vertice("V1"));
		grafo.agregarArista(new Vertice("V0"),new Vertice("V2"));
		grafo.agregarArista(new Vertice("V1"),new Vertice("V3"));
		grafo.agregarArista(new Vertice("V2"),new Vertice("V4"));
		grafo.agregarArista(new Vertice("V3"),new Vertice("V5"));
		grafo.agregarArista(new Vertice("V4"),new Vertice("V5"));
		
		System.out.println(grafo.coleccionDeVectores);
	}

}
