package grafos;
import java.util.HashMap;
import java.util.Map;

public class Grafo {
	
	private HashMap<String, Vertice> vertices = new HashMap<String, Vertice>();
	
	
	public void agregarArista(String inicio, String destino, int peso) {
		if(!vertices.containsKey(inicio)) {
			Vertice nuevoVertice = new Vertice(inicio);
			vertices.put(inicio, nuevoVertice);
		}
		if(!vertices.containsKey(destino)) {
			Vertice nuevoDestino = new Vertice(destino);
			vertices.put(destino, nuevoDestino);
		}
		vertices.get(inicio).agregarArista(new Arista(vertices.get(destino),peso));
	}
	
	public HashMap<String, Vertice> getVertices() {
		return vertices;
	}
	
	
	@Override
	public String toString() {
		String res = vertices.keySet().toString() + "\n";
		for(Map.Entry<String, Vertice> vertice : vertices.entrySet()) {
			res += vertice.getKey() + " : " ;
			res += vertice.getValue().toString() + "\n" ;
		}
		return res;
	}
	
}
