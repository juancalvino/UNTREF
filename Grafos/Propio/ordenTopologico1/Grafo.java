package ordenTopologico1;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class Grafo {

	Map<String, LinkedList<Vertice>> coleccionDeVectores = new HashMap<String, LinkedList<Vertice>>();
	

	public void agregarArista(Vertice origen,Vertice destino) {
		
		String verticeOrigen = origen.getNombre();
		
		if(!coleccionDeVectores.containsKey(verticeOrigen)) {
			coleccionDeVectores.put(verticeOrigen, new LinkedList<Vertice>());
			}
		
		if(!coleccionDeVectores.containsKey(destino.getNombre())) {
			coleccionDeVectores.put(destino.getNombre(), new LinkedList<Vertice>());
		}		
		
		coleccionDeVectores.get(verticeOrigen).add(destino);
	};

	public Map<String,Integer> calcularGradosDeEntrada() {

		Map<String,Integer> gradosDeEntrada = new HashMap<String, Integer>();
		
		for (Entry<String, LinkedList<Vertice>> listaAdyacencia : coleccionDeVectores.entrySet()) {
		
			if(!gradosDeEntrada.containsKey(listaAdyacencia.getKey())) {
				gradosDeEntrada.put(listaAdyacencia.getKey(), 0);
				}
			
			for (Vertice verticeDeSalida: listaAdyacencia.getValue()) {
				
				String vertice = verticeDeSalida.getNombre();
				
				int grados = 0;
				
				if(gradosDeEntrada.containsKey(vertice)) {
					grados = gradosDeEntrada.get(vertice);
				}
					gradosDeEntrada.put(vertice, ++grados);	
			}
		}
		
		return gradosDeEntrada;	
}
	
	public LinkedList<Vertice>  getVerticesDeSalida (Vertice origen) {
		return coleccionDeVectores.get(origen.getNombre());
	}
	
	@Override
	public String toString() {
		return coleccionDeVectores.keySet().toString();
	}
	
	public int calcularGradosDeSalida(Vertice vertice) {		
		return coleccionDeVectores.get(vertice.getNombre()).size();
	}
		
	public Map<String, LinkedList<Vertice>> getColeccionDeVectores() {
		return coleccionDeVectores;
	}		

}
