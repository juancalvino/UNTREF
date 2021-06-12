package grafo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class Grafo {

	Map<String, LinkedList<Arista>> coleccionDeVectores = new HashMap<String, LinkedList<Arista>>();
	

	public void agregarArista(Vertice origen,Vertice destino, double peso) {
		
		String verticeOrigen = origen.getNombre();
		
		if(!coleccionDeVectores.containsKey(verticeOrigen)) {
			coleccionDeVectores.put(verticeOrigen, new LinkedList<Arista>());
			}
		
		if(!coleccionDeVectores.containsKey(destino.getNombre())) {
			coleccionDeVectores.put(destino.getNombre(), new LinkedList<Arista>());
		}		
		
		coleccionDeVectores.get(verticeOrigen).add(new Arista(destino,peso));
	};

	
	public Map<String,Integer> calcularGradosDeEntrada() {

		Map<String,Integer> gradosDeEntrada = new HashMap<String, Integer>();
		
		for (Entry<String, LinkedList<Arista>> listaAdyacencia : coleccionDeVectores.entrySet()) {
		
			if(!gradosDeEntrada.containsKey(listaAdyacencia.getKey())) {
				gradosDeEntrada.put(listaAdyacencia.getKey(), 0);
				}
			
			for (Arista verticeDeSalida: listaAdyacencia.getValue()) {
				
				String vertice = verticeDeSalida.getDestino().getNombre();
				
				int grados = 0;
				
				if(gradosDeEntrada.containsKey(vertice)) {
					grados = gradosDeEntrada.get(vertice);
				}
					gradosDeEntrada.put(vertice, ++grados);	
			}
		}
		
		return gradosDeEntrada;	
}
	
	public LinkedList<Arista>  getArestasDeSalidaDel (Vertice origen) {
		return coleccionDeVectores.get(origen.getNombre());
	}
	
	@Override
	public String toString() {
		return coleccionDeVectores.keySet().toString();
	}
	
	public int calcularGradosDeSalida(Vertice vertice) {		
		return coleccionDeVectores.get(vertice.getNombre()).size();
	}
		
	public Map<String, LinkedList<Arista>> getColeccionDeAristas() {
		return coleccionDeVectores;
	}		

}
