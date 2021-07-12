package biPartito;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Grafo {

	private HashMap<String, Vertice> vertices = new HashMap<String, Vertice>();

	public void agregarArista(String inicio, String destino, int peso) {
		if (!vertices.containsKey(inicio)) {
			Vertice nuevoVertice = new Vertice(inicio);
			vertices.put(inicio, nuevoVertice);
		}
		if (!vertices.containsKey(destino)) {
			Vertice nuevoDestino = new Vertice(destino);
			vertices.put(destino, nuevoDestino);
		}
		vertices.get(inicio).agregarArista(new Arista(vertices.get(destino), peso));
	}
	
	public enum Color{
		Rojo,Azul;
	}
	
	public boolean verificarSiEsBipartito(String inicio) {
		HashMap<String, String> predecesores = new HashMap<String, String>();
		HashMap<String, Color> pintados = new HashMap<String, Grafo.Color>();
		Queue<String> cola = new LinkedList<String>();
		
		Color color = Color.Rojo;
		
		for (String vertice : vertices.keySet()) {
			predecesores.put(vertice, null);
			pintados.put(vertice, null);
		}
		cola.add(inicio);
		pintados.put(inicio, color);
		
		
		while (!cola.isEmpty()) {
			String vertice = cola.poll();
			color =  Color.Rojo == pintados.get(vertice) ? Color.Azul : Color.Rojo;
			
			for (String verticeAdyacente : vertices.get(vertice).getListaDeAristas().keySet()) {
				if (!elVerticeFueVisitado(verticeAdyacente, predecesores, inicio)) {
					predecesores.put(verticeAdyacente, vertice);
					pintados.put(verticeAdyacente, color);
					cola.add(verticeAdyacente);
				}
				if(pintados.get(vertice) == pintados.get(verticeAdyacente)){
					return false;
				}
			}
		}
		return true;
	}
	
	
	private boolean elVerticeFueVisitado(String verticeAdyacente,HashMap<String, String> predecesores, String inicio) {
		return predecesores.get(verticeAdyacente) != null || verticeAdyacente.equals(inicio);
	}


	@Override
	public String toString() {
		String respuesta = vertices.keySet().toString() + "\n";
		for (Map.Entry<String, Vertice> vertice : vertices.entrySet()) {
			respuesta += vertice.getKey() + " : ";
			respuesta += vertice.getValue().toString() + "\n";
		}
		return respuesta;
	}
	
}
