package algoritmosEnClase;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import grafo.Arista;
import grafo.Grafo;

public class BFS {

	public HashMap<String, Integer> busqueda(Grafo grafo, String origen) {
		
		HashMap<String, Integer> distancias = new HashMap<String, Integer>();
		Queue<String> cola = new LinkedList<String>();

		
		for (String vertice : grafo.getColeccionDeAristas().keySet()) {
			distancias.put(vertice, Integer.MAX_VALUE);
		}
		
		cola.add(origen);
		distancias.put(origen, 0);
		
		while (!cola.isEmpty()) {
			
			String vertice = cola.poll();
			Integer peso = distancias.get(vertice);
			
			LinkedList<Arista> listaDeAristas = grafo.getColeccionDeAristas().get(vertice);
			
			for (Arista arista : listaDeAristas) {
				
				String verticeAdyacente = arista.getDestino().getNombre();
				int acumulado = (int) (peso + arista.getPeso());
				
				if ( acumulado < distancias.get(verticeAdyacente)) {

					distancias.put(verticeAdyacente, acumulado);
					cola.add(verticeAdyacente);					
				}
			}
		}
		
		return distancias;
	}
	
//	public HashMap<String, String> busquedaALoAnchoCaminos(String verticeInicial) {
//		
//		HashMap<String, String> predecesores = new HashMap<String, String>();
//		
//		Queue<String> cola = new LinkedList<String>();
//		
//		for (String vertice : grafo.keySet()) {
//			
//			predecesores.put(vertice, null);
//		}
//		
//		cola.add(verticeInicial);
//		
//		while (!cola.isEmpty()) {
//			
//			String verticePadre = cola.poll();
//			
//			HashSet<Arista> aristas = grafo.get(verticePadre).obtenerAristasAdyacentes();
//			
//			for (Arista aristaAdyacente : aristas) {
//				
//				String verticeAdyacente = aristaAdyacente.destino;
//				
//				if (predecesores.get(verticeAdyacente) == null
//						&& !verticeAdyacente.equals(verticeInicial)) {
//					
//					predecesores.put(verticeAdyacente, verticePadre);
//					cola.add(verticeAdyacente);					
//				}
//			}
//		}
//		
//		return predecesores;
//	}
//	
//	public HashMap<String, VerticeDistancia> busquedaALoAncho(String verticeInicial) {
//		
//		HashMap<String, VerticeDistancia> predecesoresConDistancia = new HashMap<>();
//		
//		Queue<String> cola = new LinkedList<String>();
//		
//		for (String vertice : grafo.keySet()) {
//			
//			predecesoresConDistancia.put(vertice, new VerticeDistancia());
//		}
//		
//		cola.add(verticeInicial);
//		
//		predecesoresConDistancia.put(verticeInicial, new VerticeDistancia(null, 0));
//		
//		while (!cola.isEmpty()) {
//			
//			String verticePadre = cola.poll();
//			
//			Integer distanciaVerticePadre = predecesoresConDistancia.get(verticePadre).obtenerDistancia();
//			
//			HashSet<Arista> aristas = grafo.get(verticePadre).obtenerAristasAdyacentes();
//			
//			for (Arista aristaAdyacente : aristas) {
//				
//				String verticeAdyacente = aristaAdyacente.destino;
//				
//				if (predecesoresConDistancia.get(verticeAdyacente).obtenerNombrePadre() == null
//						&& !verticeAdyacente.equals(verticeInicial)) {
//					
//					predecesoresConDistancia.put(verticeAdyacente, new VerticeDistancia(verticePadre, distanciaVerticePadre + 1));
//					
//					cola.add(verticeAdyacente);					
//				}
//			}
//		}
//		
//		return predecesoresConDistancia;
//	}
//	
	
//	public static void main(String[] args) {
//
//		Grafo grafoConAristaPositivas = new Grafo();
//		
//		grafoConAristaPositivas.agregarArista("V0", "V1", 1);
//		grafoConAristaPositivas.agregarArista("V1", "V0", 1);
//		grafoConAristaPositivas.agregarArista("V0", "V2", 2);
//		grafoConAristaPositivas.agregarArista("V1", "V3", 3);
//		grafoConAristaPositivas.agregarArista("V2", "V4", 3);
//		grafoConAristaPositivas.agregarArista("V3", "V5", 4);
//		grafoConAristaPositivas.agregarArista("V4", "V5", 4);
//		grafoConAristaPositivas.agregarArista("V2", "V5", 10);
//		
//		System.out.println(grafoConAristaPositivas.busquedaALoAncho("V0"));
//}
}